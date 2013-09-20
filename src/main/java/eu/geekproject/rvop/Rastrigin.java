package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Rastrigin implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] solution) {
        double result = 10* solution.length;
        for (double anIndividual : solution) {
            result += anIndividual * anIndividual - 10 * Math.cos(2 * Math.PI * anIndividual);
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
        return "Rastrigin";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-10,10);
    }
}
