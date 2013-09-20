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

    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;

        double fractional = 0.0;
        double cosine = 0.0;
        double term = 0.0;

        for(int i = 0; i < solution.length; i++) {
            for(int j = 0; j < solution.length; j++) {
                term = 100 * Math.pow((Math.pow(solution[i], 2) - solution[j]), 2) + Math.pow(1 - Math.pow(solution[j], 2),2);
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
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public String getName() {
        return "Whitley";
    }


    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-10.24,10.24);
    }
}
