package com.hillel.lesson21.hw15;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || stones == null) {
            return 0;
        }
        int jewelCount = 0;
        for (char jewel : jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    jewelCount++;
                }
            }
        }
        return jewelCount;
    }
}
