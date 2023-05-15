package com.hillel.lesson21.hw15;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int goodPairsCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    goodPairsCount++;
                }
            }
        }
        return goodPairsCount;
    }
}
