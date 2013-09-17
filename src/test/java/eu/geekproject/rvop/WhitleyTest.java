package eu.geekproject.rvop;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class WhitleyTest {
    private Whitley whitleyFunction;

    @Before
    public void setUp() throws Exception {
        whitleyFunction = new Whitley();
    }

    @Test
    public void testEvaluate() throws Exception {
        double[] individual;
        for(int i = 1; i <= 30; i++) {
            individual = new double[i];
            for(int j = 0; j < individual.length; j++) {
                individual[j] = 1;
            }
            org.junit.Assert.assertEquals(0, whitleyFunction.evaluate(individual), 0.001);
        }
    }
}
