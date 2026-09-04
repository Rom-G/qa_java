package com.example;

import java.util.List;

public class Lion {

    Predator predator;
    FelineBehaviour felineBehaviour;
    boolean hasMane;

    public Lion(Feline feline, FelineBehaviour felineBehaviour, String sex) throws Exception {
        this.predator = feline;
        this.felineBehaviour = felineBehaviour;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() throws Exception {
        return felineBehaviour.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
