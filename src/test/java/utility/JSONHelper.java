package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Creditcard;
import pojo.User;

import java.io.File;
import java.io.IOException;

public class JSONHelper {

    public static User read(final String path) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
          return objectMapper.readValue(new File("src/test/resources/testData/"+ path +".json"), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("src/test/resources/testData/outputUser.json"), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Creditcard read1(final String path) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("src/test/resources/testData/"+ path +".json"), Creditcard.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void write1(){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("src/test/resources/testData/outputUser.json"), Creditcard.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

