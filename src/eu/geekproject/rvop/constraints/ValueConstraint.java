package eu.geekproject.rvop.constraints;

public class ValueConstraint implements Constraint {
    private double min, max;

    public ValueConstraint(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean check(double value) {
        if(value >= min && value <= max) {
            return true;
        } else {
            return false;
        }
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
