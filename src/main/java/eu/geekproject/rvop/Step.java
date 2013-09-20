package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Step implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;
        for(double v : solution) {
            result += Math.pow(Math.floor(v + 0.5), 2);
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
        return "Step";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-1.28,1.28);
    }
}
