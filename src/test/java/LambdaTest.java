import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.*;

public class LambdaTest{

    class Apple{
        private Double weight;

        public Apple(){

        }

        public Apple(Double weight){
            this.weight = weight;
        }

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

    @Test
    void referenceConstructor(){
//        Supplier<Apple> c1 = () -> new Apple();
        Supplier<Apple> c1 = Apple::new;
//        Function<Double, Apple> c2 = (i) -> new Apple(i);
        Function<Double, Apple> c2 = Apple::new;


        List<Double> weights = Arrays.asList(7.0, 3.0, 4.0, 10.0);
        List<Apple> apples = map(weights, Apple::new);

    }

    public List<Apple> map(List<Double> list, Function<Double, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Double i : list){
            result.add(f.apply(i));
        }
        return result;
    }


}


