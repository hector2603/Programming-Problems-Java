package org.example.Leetcode.TopKFrequentElements;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TopKFrequentElements {

    public static void main(String[] args) {

    }

    /*
    * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    *
    * */

    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(groupingBy(element -> element, counting()))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
