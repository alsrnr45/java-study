package org.example.behavior_parameterized;

public class AppleFancyFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        return apple.getWeight() > 140 ? "heavy" : "light";
    }
}
