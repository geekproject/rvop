package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;

import java.util.List;

/**
 * Implementation of the Lunacek function.
 *
 * M. Lunacek, D. Whitley and A. Sutton, "The Impact of Global Structure on Search" in
 * Parallel problem solving from nature, Springer Verlag, Berlin, 2008.
 *
 * @author Fabian Becker
 */
public class Lunacek implements OptimizationProblem {
    private int dimension;

    @Override
    public double evaluate(double[] individual) {

        double sum1 = 0.0, sum2 = 0.0, sum3 = 0.0;
        double u1, u2, s, d;

        d = 1;
        s = 1 - (1/(2*Math.sqrt(individual.length+20)-8.2));
        u1 = 2.5;
        u2 = - Math.sqrt((Math.pow(u1, 2)-d)/s);

        for(int i = 0; i < individual.length; i++) {
            sum1 += Math.pow(individual[i] - u1, 2);
            sum2 += Math.pow(individual[i] - u2, 2);
            sum3 += (1 - Math.cos(2 * Math.PI * (individual[i] - u1)));
        }

        sum2 = d * individual.length + s * sum2;

        return Math.min(sum1, sum2) + 10 * sum3;
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
        return "Lunacek";
    }


    @Override
    public List<Constraint> getDefaultConstraints() {
        return null;
    }
}
