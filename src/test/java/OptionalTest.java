import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

@Slf4j
public class OptionalTest {

    public int newReadDuration(Properties properties, String name){
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(OptionalTest::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public int readDuration(Properties properties, String name){
        String value = properties.getProperty(name);
        if(value != null){
            try{
                int i = Integer.parseInt(name);
                if(i > 0){
                    return i;
                }
            } catch (NumberFormatException e){
                log.atError().log(e.getMessage());
                throw e;
            }
        }
        return 0;
    }

    public static Optional<Integer> stringToInt(String str) {
        try{
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

