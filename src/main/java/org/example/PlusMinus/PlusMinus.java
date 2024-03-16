package org.example.PlusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class PlusMinus {


    public static void plusMinus(List<Integer> arr) {
        var result = arr.stream()
                .collect(groupingBy(element -> element.compareTo(0), counting()))
                .entrySet().stream()
                .collect(toMap(Map.Entry::getKey, entry -> entry.getValue().doubleValue() / arr.size()));

        System.out.printf("%.6f%n", result.getOrDefault(1,0.0));
        System.out.printf("%.6f%n", result.getOrDefault(-1,0.0));
        System.out.printf("%.6f%n", result.getOrDefault(0,0.0));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }


}
