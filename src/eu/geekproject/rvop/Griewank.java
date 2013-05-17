package eu.geekproject.rvop;

/**
 *
 */
public class Griewank implements OptimizationProblem {
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
    public String getName() {
        return "Griewank";
    }
}
