import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class LambdaTest{

    class Apple{
        private Double weight;

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }
    }

    @Test
    void simpleLambda(){

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

        assertThat(byWeight.compare(x, y)).isEqualTo(-1);
    }

    public String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/fruit.txt"))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader br) throws IOException;
    }

    @Test
    void executeAroundPattern() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        assertThat(oneLine).contains("Apple");
        assertThat(twoLine).contains("AppleBanana");
    }


}


