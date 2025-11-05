import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class LambdaTest{
    @Test
    void simpleLambda(){

        class Apple{
            private Double weight;

            public Double getWeight() {
                return weight;
            }

            public void setWeight(Double weight) {
                this.weight = weight;
            }
        }

        Apple x =  new Apple();
        x.setWeight(3.0);
        Apple y = new Apple();
        y.setWeight(4.0);

//        Comparator<Apple> byWeight = new Comparator<Apple>() {
//            public int compare(Apple x, Apple y) {
//                return x.getWeight().compareTo(y.getWeight());
//            }
//        };


//        Comparator<Apple> byWeight = (x, y) -> x.getWeight().compareTo(y.getWeight());

        Comparator<Apple> byWeight = Comparator.comparing(Apple::getWeight);

        Assertions.assertThat(byWeight.compare(x, y)).isEqualTo(-1);
    }
}


