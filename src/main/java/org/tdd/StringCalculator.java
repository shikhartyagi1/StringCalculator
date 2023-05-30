package org.tdd;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator implements AdditionCalculator{

    @Override
    public int add(@NotNull String req) {
        if(req.equals("")) return 0;
        String delimiter = ",";
        if(req.startsWith("//")){
            delimiter = Character.toString(req.charAt(2));
            req = req.substring(5);
        }
        String numbers[] = splitNumbers(req, delimiter + "|\n");
        return sum(numbers);
    }
    private static String[] splitNumbers(@NotNull String req, String divider){
        return req.split(divider);
    }
    private static int sum(String[] numbers){
        String negativeNumberSequence = Arrays.stream(numbers).mapToInt(Integer::parseInt).filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if (!negativeNumberSequence.isEmpty()) throw new IllegalArgumentException("negative number: " + negativeNumberSequence);

        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
    private static int toInt(String number){
        return Integer.parseInt(number);
    }
}
