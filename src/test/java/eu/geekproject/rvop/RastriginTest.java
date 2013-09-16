package eu.geekproject.rvop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class RastriginTest
    private Rastrigin rastriginFunction;

    @Before
    public void setUp() throws Exception {
        rastriginFunction = new Rastrigin();
    }

    @Test
    public void testEvaluate() throws Exception {
        for(int i = 1; i <= 30; i++) {
            double[] individual = new double[i];
            Assert.assertEquals(0, rastriginFunction.evaluate(individual), 0.001);
        }
    }
}
