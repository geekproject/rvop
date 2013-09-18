package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Schwefel implements OptimizationProblem {
    private List<Constraint> constraints;
    private int dimension;

    @Override
    public double evaluate(double[] individual) {
        double result = 0.0;
        double alpha = 418.982887;
        for(int i = 0; i < individual.length; i++) {
            result += -individual[i] * Math.sin(Math.sqrt(Math.abs(individual[i])));
        }
        return result + alpha * individual.length;
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
            this.constraints.add(new ValueConstraint(-512,512));
        }
    }

    @Override
    public String getName() {
        return "Schwefel";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
