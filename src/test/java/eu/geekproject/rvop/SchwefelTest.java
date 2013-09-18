package eu.geekproject.rvop;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class SchwefelTest {
    private Schwefel schwefelFunction;

    @Before
    public void setUp() throws Exception {
        schwefelFunction = new Schwefel();
        schwefelFunction.setDimension(30);
    }

    @Test
    public void testEvaluate() throws Exception {
        for(int i = 1; i <= 30; i++) {
            double[] individual = new double[i];
            //org.junit.Assert.assertEquals(0.0, schwefelFunction.evaluate(individual), 0.001);
            for(int j = 0; j < individual.length; j++) {
                individual[j] = 420.968746;
            }
            org.junit.Assert.assertEquals(0.0, schwefelFunction.evaluate(individual), 0.001);
        }
    }
}
