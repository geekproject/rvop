package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Schwefel implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;
        double alpha = 418.982887;
        for(int i = 0; i < solution.length; i++) {
            result += -solution[i] * Math.sin(Math.sqrt(Math.abs(solution[i])));
        }
        return result + alpha * solution.length;
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
        return "Schwefel";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-512,512);
    }
}
