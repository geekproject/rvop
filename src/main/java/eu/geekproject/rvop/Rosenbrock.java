package eu.geekproject.rvop;

import eu.geekproject.rvop.constraints.Constraint;
import eu.geekproject.rvop.constraints.ValueConstraint;

import java.util.ArrayList;
import java.util.List;

/**
 * Sphere
 */
public class Rosenbrock implements OptimizationProblem {
    private List<Constraint> constraints;
    private int dimension;

    @Override
    public double evaluate(double[] individual) {
        double sum = 0.0;
        double [] v = new double[individual.length];

        for (int i = 0; i < individual.length; i++) {
            v[i] = individual[i] + 1;
        }

        for (int i = 0 ; i < (individual.length-1) ; i ++) {
            double temp1 = (v[i] * v[i]) - v[i+1];
            double temp2 = v[i] - 1.0;
            sum += (100.0 * temp1 * temp1) + (temp2 * temp2);
        }

        return sum;
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
            this.constraints.add(new ValueConstraint(-10,10));
        }
    }

    @Override
    public String getName() {
        return "Rosenbrock";
    }

    @Override
    public List<Constraint> getDefaultConstraints() {
        return this.constraints;
    }
}
