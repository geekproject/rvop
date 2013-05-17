package eu.geekproject.rvop;

/**
 * Sphere
 */
public class Sphere implements OptimizationProblem {
    @Override
    public double evaluate(double[] individuum) {
        double result = 0.0;
        for(double v : individuum) {
            result += Math.pow(v, 2);
        }
        return result;
    }

    @Override
    public String getName() {
        return "Sphere";
    }
}
