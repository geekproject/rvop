/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.geekproject.rvop;

/**
 *
 * @author becker
 */
public class StyblinskiTang implements OptimizationProblem {

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
    
}
