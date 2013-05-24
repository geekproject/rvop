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
public class StyblinskiTang implements OptimizationProblem {
    private List<Constraint> constraints;

    public StyblinskiTang(int dimensions) {
        this.constraints = new ArrayList<Constraint>(dimensions);
        for(int i = 0; i < dimensions; i++) {
            constraints.add(new ValueConstraint(-5, 5));
        }
    }

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

    @Override
    public String getName() {
        return "StyblinskiTang";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }

}
