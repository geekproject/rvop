package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Rosenbrock implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;

        for(int i = 0; i < solution.length -1; i++) {
            result += 100 *
                    Math.pow(Math.pow(solution[i], 2) - solution[i+1], 2) +
                    Math.pow(1 - solution[i], 2);
        }


        return result;
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
        return "Rosenbrock";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-10,10);
    }
}
