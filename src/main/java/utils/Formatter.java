package utils;

public class Formatter {
    public static double getPrice(String value) {
        return Double.valueOf(value.replace("€", ""));
    }
}
