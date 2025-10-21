package org.example;

/*
사과 리스트를 인수로 받아 다양한 방법으로 문자열을 생성(커스터마이즈된 다양한 toString 메서드와 같이) 할 수 있도록 파라미터화된 prettyPrintApple 메서드를 구현하시오.
예를 들어 prettyPrintApple 메서드가 각각의 사과 무게를 출력하도록 지시할 수 있다. 혹은 각각의 사과가 무거운지 가벼운지 출력하도록 지시할 수 있다.
 */

import org.example.behavior_parameterized.Apple;
import org.example.behavior_parameterized.AppleFormatter;

import java.util.List;

public class BehaviorParameterized {

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for(Apple apple : inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

}
