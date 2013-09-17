package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import java.util.List;

/**
 *
 * @author halfdan
 */
public interface OptimizationProblem {
    double evaluate(double[] individual);
    void setDimension(int dimension);
    int getDimension();
    String getName();
    List<Constraint> getDefaultConstraints();
}
