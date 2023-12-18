import arraysAndHashing.ArraysAndHashing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArraysAndHashingTests {
    @Test
    void containsDuplicateTest() {
        int[] nums = {1, 2, 3, 4, 5, 4};
        boolean hasDup = ArraysAndHashing.containsDuplicate(nums);
        Assertions.assertTrue(hasDup);
    }

    @Test
    void isAnagramTest() {
        String s = "anagram";
        String t = "nagaram";
        Assertions.assertTrue(ArraysAndHashing.isAnagram(s, t));
    }

    @Test
    void twoSumTest() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] pairs = ArraysAndHashing.twoSum(nums, target);
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, pairs);
    }

    @Test
    void groupAnagramsTest() {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groups = ArraysAndHashing.groupAnagrams(strings);
        List<List<String>> expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("bat"),
                List.of("tan", "nat")

        );
        Assertions.assertEquals(expected, groups);
    }

    @Test
    void topKFrequentTest() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] output = ArraysAndHashing.topKFrequent(nums, k);
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, output);
    }

    @Test
    void productExceptSelfTest() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] answer = ArraysAndHashing.productExceptSelf(nums);
        int[] expected = {0, 0, 9, 0, 0};
        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    void sumExceptSelfTest() {
        int[] nums = {1, 6, 4, 2, 5, 3};
        int[] answer = ArraysAndHashing.sumExceptSelf(nums);
        int[] expected = {20, 15, 17, 19, 16, 18};
        Assertions.assertArrayEquals(expected, answer);
    }

    @Test
    void isValidSudokuTest() {

    }
}
