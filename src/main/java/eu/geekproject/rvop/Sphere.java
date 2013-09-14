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
    private int dimension;

    @Override
    public double evaluate(double[] individuum) {
        double result = 0.0;
        for(double v : individuum) {
            result += Math.pow(v, 2);
        }
        return result;
    }


    @Override
    public void setDimension(int dimension) {
        this.dimension = dimension;
        this.updateConstraints();
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    private void updateConstraints() {
        this.constraints =  new ArrayList<Constraint>(this.dimension);
        for(int i = 0; i < this.dimension; i++) {
            this.constraints.add(new ValueConstraint(-10,10));
        }
    }

    @Override
    public String getName() {
        return "Sphere";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
