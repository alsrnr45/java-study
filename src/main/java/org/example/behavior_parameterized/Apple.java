package org.example.behavior_parameterized;


public class Apple {
    private Color color;
    private int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color.toString();
    }

    public int getWeight() {
        return weight;
    }

    public enum Color{
        RED, GREEN, YELLOW
    }
}
