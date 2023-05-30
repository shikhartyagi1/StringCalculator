package org.tdd;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class StringCalculator implements AdditionCalculator{

    @Override
    public int add(@NotNull String req) {
        if(req.equals("")) return 0;
        String delimiter = ",";
        String numbers[] = splitNumbers(req, delimiter + "|\n");
        return sum(numbers);
    }
    private static String[] splitNumbers(@NotNull String req, String divider){
        return req.split(divider);
    }
    private static int sum(String[] numbers){
        int sum = 0;
        for(String number : numbers) sum += toInt(number);
        return sum;
    }
    private static int toInt(String number){
        return Integer.parseInt(number);
    }
}
