package org.example.FootballScores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FootballScores {

    public static List<Integer> getScores(List<Integer> teamA, List<Integer> teamB) {
        List<Integer> result = new ArrayList<>(); // this is the result list
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>(); // this is the frequency map, the tree map is a red black tree, so it is sorted

        for (int goals : teamA) {
            frequencyMap.put(goals, frequencyMap.getOrDefault(goals, 0) + 1);
        }
        //  after this for loop, the frequencyMap will be like this:
        // 2 -> 4
        // 4 -> 1
        // 5 -> 1
        // 8 -> 3


        int totalCount = 0;
        for (int goals : frequencyMap.keySet()) {
            totalCount += frequencyMap.get(goals);
            frequencyMap.put(goals, totalCount);
        }
        //  after this for loop, the frequencyMap will be like this:
        // 2 -> 4
        // 4 -> 5
        // 5 -> 6
        // 8 -> 9

        for (int goals : teamB) {
            Map.Entry<Integer, Integer> entry = frequencyMap.floorEntry(goals); // this will return the greatest key less than or equal to the given key, or null if there is no such key. example: if the goals is 3, it will return 2 -> 4
            int count = (entry != null) ? entry.getValue() : 0;
            result.add(count); // add the count to the result list
        }
        //after this for loop, the result list will be like this:
        // 4, 0, 6, 8

        return result;
    }


    public static void main(String[] args) {
        System.out.println(getScores(List.of(2, 8, 2, 2, 10, 5, 4, 8, 2), List.of(3, 1, 7, 8))); // expected [4, 0, 6, 8]
    }
}
