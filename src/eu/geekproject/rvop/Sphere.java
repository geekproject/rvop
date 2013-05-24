package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Sphere implements OptimizationProblem {
    private List<Constraint> constraints;

    public Sphere(int dimensions) {
        this.constraints =  new ArrayList<Constraint>(dimensions);
        for(int i = 0; i < dimensions; i++) {
            this.constraints.add(new ValueConstraint(-10,10));
        }
    }

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

    @Override
    public List<Constraint> getDefaultConstraints() {
        this.constraints;
    }
}
