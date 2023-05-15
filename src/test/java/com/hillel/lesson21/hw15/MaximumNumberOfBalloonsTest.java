package com.hillel.lesson21.hw15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumNumberOfBalloonsTest {
    private MaximumNumberOfBalloons maximumNumberOfBalloons;
    @Before
    public void setUp() {
        maximumNumberOfBalloons = new MaximumNumberOfBalloons();
    }
    @Test
    public void maxNumberOfBalloonsWithMatchingTest() {
        String text = "loonbalxballpoon";
        int expected = 2;
        int result = maximumNumberOfBalloons.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void maxNumberOfBalloonsWithoutMatchingTest() {
        String text = "hillel";
        int expected = 0;
        int result = maximumNumberOfBalloons.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void maxNumberOfBalloonsWithNullTest() {
        String text = null;
        int expected = 0;
        int result = maximumNumberOfBalloons.maxNumberOfBalloons(text);
        Assert.assertEquals(expected, result);
    }
}
