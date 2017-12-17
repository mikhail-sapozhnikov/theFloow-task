package com.thefloow.utils;

import java.util.Random;

/**
 * A class with calculation methods which can be helpful in tests
 */
public class CalculationUtils {

    public int getRandomNum(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

}
