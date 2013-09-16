package eu.geekproject.rvop;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 */
public class RosenbrockTest {
    private Rosenbrock rosenbrockFunction;

    @Before
    public void setUp() throws Exception {
        this.rosenbrockFunction = new Rosenbrock();
    }

    @Test
    public void testEvaluate() throws Exception {
        for(int i = 1; i <= 30; i++) {
            double[] individual = new double[i];
            for(int j = 0; j < individual.length; j++) {
                individual[j] = 1;
            }
            Assert.assertEquals(0, rosenbrockFunction.evaluate(individual), 0.001);
        }
    }
}
