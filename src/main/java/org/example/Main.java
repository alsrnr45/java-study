package org.example;

import org.example.behavior_parameterized.Apple;
import org.example.behavior_parameterized.AppleFancyFormatter;
import org.example.behavior_parameterized.ApplePrintWeightFormatter;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(Apple.Color.GREEN, 150));
        apples.add(new Apple(Apple.Color.RED, 140));

        BehaviorParameterized.prettyPrintApple(apples, new AppleFancyFormatter());
        BehaviorParameterized.prettyPrintApple(apples, new ApplePrintWeightFormatter());
    }

}