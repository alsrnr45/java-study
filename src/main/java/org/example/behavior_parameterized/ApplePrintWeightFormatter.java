package org.example.behavior_parameterized;

public class ApplePrintWeightFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        return "weight : " + apple.getWeight();
    }
}
