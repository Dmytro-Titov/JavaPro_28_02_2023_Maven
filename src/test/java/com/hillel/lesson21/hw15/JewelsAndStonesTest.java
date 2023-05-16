package com.hillel.lesson21.hw15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JewelsAndStonesTest {
    private JewelsAndStones jewelsAndStones;
    @Before
    public void setUp() {
        jewelsAndStones = new JewelsAndStones();
    }
    @Test
    public void numJewelsInStonesWithMatchingTest() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int expected = 3;
        int result = jewelsAndStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void numJewelsInStonesWithoutMatchingTest() {
        String jewels = "z";
        String stones = "ZZ";
        int expected = 0;
        int result = jewelsAndStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void numJewelsInStonesWithFirstArgumentNullTest() {
        String jewels = "aA";
        String stones = null;
        int expected = 0;
        int result = jewelsAndStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void numJewelsInStonesWithSecondArgumentNullTest() {
        String jewels = null;
        String stones = "a";
        int expected = 0;
        int result = jewelsAndStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(expected, result);
    }

}
