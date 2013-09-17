package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Whitley implements OptimizationProblem {
    private int dimension;
    private List<Constraint> constraints;

    @Override
    public double evaluate(double[] individual) {
        double result = 0.0;

        double fractional = 0.0;
        double cosine = 0.0;
        double term = 0.0;

        for(int i = 0; i < individual.length; i++) {
            for(int j = 0; j < individual.length; j++) {
                term = 100 * Math.pow((Math.pow(individual[i], 2) - individual[j]), 2) + Math.pow(1 - Math.pow(individual[j], 2),2);
                fractional = Math.pow(100*term, 2)/4000;
                cosine = Math.cos(term);

                result += fractional - cosine + 1;

            }
        }
        return result;
    }

    @Override
    public void setDimension(int dimension) {
        this.dimension = dimension;
        this.updateConstraints();
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    private void updateConstraints() {
        this.constraints =  new ArrayList<>(this.dimension);
        for(int i = 0; i < this.dimension; i++) {
            this.constraints.add(new ValueConstraint(-10.24,10.24));
        }
    }

    @Override
    public String getName() {
        return "Whitley";
    }


    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
