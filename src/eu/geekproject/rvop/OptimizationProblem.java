package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import java.util.List;

/**
 *
 * @author halfdan
 */
public interface OptimizationProblem {
    double evaluate(double[] individuum);
    String getName();
    List<Constraint> getDefaultConstraints();
}
