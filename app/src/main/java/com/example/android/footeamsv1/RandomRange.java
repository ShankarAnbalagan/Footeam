package com.example.android.footeamsv1;

import java.util.Random;

/**
 * Created by Shankar on 02-09-2017.
 */

class RandomRange {
    public int randnum(int s, int e){


        int START = s;
        int END = e;
        Random random = new Random();
        int num=showRandomInteger(START, END, random);
        return num;
    }



    public int showRandomInteger(int aStart, int aEnd, Random aRandom){
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        long range = (long)aEnd - (long)aStart + 1;
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        return randomNumber;
    }
}
