package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Rastrigin implements OptimizationProblem {
    private List<Constraint> constraints;
    private int dimension;

    @Override
    public double evaluate(double[] individual) {
        double result = 10* individual.length;
        for (double anIndividual : individual) {
            result += anIndividual * anIndividual - 10 * Math.cos(2 * Math.PI * anIndividual);
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
            this.constraints.add(new ValueConstraint(-10,10));
        }
    }

    @Override
    public String getName() {
        return "Rastrigin";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
