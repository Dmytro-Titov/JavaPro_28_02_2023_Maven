package com.hillel.lesson21.hw15;

public class MaximumNumberOfBalloons {
    private int targetCount = 0;
    private String target = "balloon";
    public int maxNumberOfBalloons(String text) {
        if (text == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(text);
        for (char letter : target.toCharArray()) {
            if (sb.toString().contains(String.valueOf(letter))) {
                sb.deleteCharAt(sb.indexOf(String.valueOf(letter)));
            } else {
                return targetCount;
            }
        }
        targetCount++;
        if (sb.toString().length() < target.length()) {
            return targetCount;
        } else {
            maxNumberOfBalloons(sb.toString());
        }
        return targetCount;
    }
}
