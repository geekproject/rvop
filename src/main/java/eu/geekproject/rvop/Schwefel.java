package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Schwefel implements OptimizationProblem {
    private List<Constraint> constraints;
    private int dimension;

    @Override
    public double evaluate(double[] individuum) {
        double result = 0.0;
        for(int i = 0; i < individuum.length; i++) {
            result += -individuum[i] * Math.sin(Math.sqrt(Math.abs(individuum[i])));
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
        this.constraints =  new ArrayList<>(this.dimension);
        for(int i = 0; i < this.dimension; i++) {
            this.constraints.add(new ValueConstraint(-500,500));
        }
    }

    @Override
    public String getName() {
        return "Schwefel";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
