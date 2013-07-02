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
    private List<Constraint> constraints;
    private int dimension;

    /**
     * Evaluation of individuum by the Styblinsky-Tang function.
     *
     * Global optimum: f(x)=-39.166165n for x = -2.903351
     *
     * @param individuum
     * @return
     */
    @Override
    public double evaluate(double[] individuum) {        
        double result = 0.0;
        for (int i = 0; i < individuum.length; i++) {
            result  += Math.pow(individuum[i], 4) - 16 * Math.pow(individuum[i], 2) + 5 * individuum[i];
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
        this.updateConstraints();
    }

    /**
     * Updates the default constraints whenever the dimension
     * has changed.
     */
    private void updateConstraints() {
        this.constraints = new ArrayList<Constraint>(this.dimension);
        for(int i = 0; i < dimension; i++) {
            constraints.add(new ValueConstraint(-5, 5));
        }
    }

    @Override
    public String getName() {
        return "StyblinskyTang";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }

}
