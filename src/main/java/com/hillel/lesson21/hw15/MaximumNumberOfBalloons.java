package com.hillel.lesson21.hw15;

public class MaximumNumberOfBalloons {
    private int targetCount = 0;
    private String target = "balloon";
    public int maxNumberOfBalloons(String text) {
        if (text == null) {
            return 0;
        }
        StringBuilder textBuilder = new StringBuilder(text);
        for (char letter : target.toCharArray()) {
            if (textBuilder.toString().contains(String.valueOf(letter))) {
                textBuilder.deleteCharAt(textBuilder.indexOf(String.valueOf(letter)));
            } else {
                return targetCount;
            }
        }
        targetCount++;
        if (textBuilder.toString().length() < target.length()) {
            return targetCount;
        } else {
            maxNumberOfBalloons(textBuilder.toString());
        }
        return targetCount;
    }
}
