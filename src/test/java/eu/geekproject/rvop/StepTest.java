package eu.geekproject.rvop;

import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class StepTest {
    private Step stepFunction;

    @Before
    public void setUp() throws Exception {
        stepFunction = new Step();
        stepFunction.setDimension(30);
    }

    @Test
    public void testEvaluate() throws Exception {
        double[] individuum = new double[30];
        org.junit.Assert.assertEquals(0.0, stepFunction.evaluate(individuum), 0.00);
    }
}
