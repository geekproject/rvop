package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

/**
 * Weighted Sphere (similar to De-Jong)
 */
public class WeightedSphere implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;
        for(int i = 0; i < solution.length; i++) {
            result += i * Math.pow(solution[i], 2);
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
        return "WeightedSphere";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-5.12,5.12);
    }
}
