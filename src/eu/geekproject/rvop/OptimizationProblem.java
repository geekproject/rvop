package eu.geekproject.rvop;

/**
 *
 * @author halfdan
 */
public interface OptimizationProblem {
    double evaluate(double[] individuum);
    String getName();
}
