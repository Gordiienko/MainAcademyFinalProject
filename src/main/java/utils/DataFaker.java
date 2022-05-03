package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;

public class DataFaker {
    private static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }


    public static String getBirthdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(faker.date().birthday());

    }

}
