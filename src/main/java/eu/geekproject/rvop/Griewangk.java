package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.List;

/**
 *
 */
public class Griewangk implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double sum = 0.0;
        double prod = 1.0;

        for(int i = 0; i < solution.length; i++) {
            sum += Math.pow(solution[i], 2);
            prod *= Math.cos(solution[i] / Math.sqrt(i+1));
        }

        return sum/4000 - prod + 1;
    }

    @Override
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public String getName() {
        return "Griewangk";
    }


    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-600, 600);
    }
}
