/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author becker
 */
public class StyblinskyTang implements OptimizationProblem {
    private int dimension;

    /**
     * Evaluation of individuum by the Styblinsky-Tang function.
     *
     * Global optimum: f(x)=-39.166165n for x = -2.903351
     *
     *
     * @param solution
     * @return
     */
    @Override
    public double evaluate(double[] solution) {
        double result = 0.0;
        for (int i = 0; i < solution.length; i++) {
            result  += Math.pow(solution[i], 4) - 16 * Math.pow(solution[i], 2) + 5 * solution[i];
        }
        return result / 2;
    }

    /**
     * Set the dimension of the Problem
     * @param dimension
     */
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
        return "StyblinskyTang";
    }

    @Override
    public Constraint getDefaultConstraint() {
        return new ValueConstraint(-5, 5);
    }

}
