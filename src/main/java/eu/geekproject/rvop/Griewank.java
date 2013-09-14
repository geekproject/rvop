package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;

import java.util.List;

/**
 *
 */
public class Griewank implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] individuum) {
        double sum = 0.0;
        double prod = 0.0;

        for(int i = 0; i < individuum.length; i++) {
            sum += Math.pow(individuum[i], 2);
            prod *= individuum[i] / Math.sqrt(i+1);
        }

        return 1 + (sum/4000) - prod;
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
        return "Griewank";
    }


    @Override
    public List<Constraint> getDefaultConstraints() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
