package eu.geekproject.rvop.constraints;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 *
 */
public class ValueConstraintTest {
    private ValueConstraint valueConstraint;

    @Before
    public void setUp() throws Exception {
        valueConstraint = new ValueConstraint(0.0, 10.0);
    }

    @Test
    public void testCheck() throws Exception {
        org.junit.Assert.assertFalse(valueConstraint.check(-1));
        org.junit.Assert.assertFalse(valueConstraint.check(10.01));
        org.junit.Assert.assertTrue(valueConstraint.check(5.0));
    }

    @Test
    public void testGetMin() throws Exception {
        org.junit.Assert.assertEquals(0.0, valueConstraint.getMin(), 0.01);
    }

    @Test
    public void testGetMax() throws Exception {
        org.junit.Assert.assertEquals(10.0, valueConstraint.getMax(), 0.01);
    }
}
