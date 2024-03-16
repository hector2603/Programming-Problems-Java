package org.example.LonelyInteger;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {
        return a.stream().collect(groupingBy( Function.identity() , counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1 ).findFirst()
                .orElse(new AbstractMap.SimpleEntry<>(0,0L)).getKey();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/org/example/LonelyInteger/result.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Thread t = new Thread(() -> {});

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
