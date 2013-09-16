package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;

import java.util.List;

/**
 *
 */
public class Ackley implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] individuum) {
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (double anIndividuum : individuum) {
            sum1 += (anIndividuum * anIndividuum);
            sum2 += (Math.cos(2 * Math.PI * anIndividuum));
        }

        return (-20.0 * Math.exp(-0.2 * Math.sqrt(sum1 / ((double )individuum.length))) -
                Math.exp(sum2 / ((double )individuum.length)) + 20.0 + Math.E);
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
        return "Ackley";
    }


    @Override
    public List<Constraint> getDefaultConstraints() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}