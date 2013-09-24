package eu.geekproject.rvop;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class GriewangkTest {
    private Griewangk griewangkFunction;

    @Before
    public void setUp() throws Exception {
        griewangkFunction = new Griewangk();
        griewangkFunction.setDimension(30);
    }

    @Test
    public void testEvaluate() throws Exception {
        for(int i = 1; i <= 30; i++) {
            double[] individual = new double[i];
            org.junit.Assert.assertEquals(0.0, griewangkFunction.evaluate(individual), 0.001);
        }
    }
}
