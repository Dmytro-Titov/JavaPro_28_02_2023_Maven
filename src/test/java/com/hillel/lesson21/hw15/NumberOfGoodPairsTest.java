package com.hillel.lesson21.hw15;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfGoodPairsTest {
    private NumberOfGoodPairs numberOfGoodPairs;
    @Before
    public void setUp() {
        numberOfGoodPairs = new NumberOfGoodPairs();
    }
    @Test
    public void numIdenticalPairsWithMatchingTest() {
        int[] nums = {1,2,3,1,1,3};
        int expected = 4;
        int result = numberOfGoodPairs.numIdenticalPairs(nums);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void numIdenticalPairsWithoutMatchingTest() {
        int[] nums = {1,2,3};
        int expected = 0;
        int result = numberOfGoodPairs.numIdenticalPairs(nums);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void numIdenticalPairsWithNullTest() {
        int[] nums = null;
        int expected = 0;
        int result = numberOfGoodPairs.numIdenticalPairs(nums);
        Assert.assertEquals(expected, result);
    }


}
