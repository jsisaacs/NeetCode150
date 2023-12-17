import org.arraysAndHashing.ArraysAndHashing;
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
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] pairs = ArraysAndHashing.twoSum(nums, target);
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, pairs);
    }

    @Test
    void groupAnagrams() {
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
    void topKFrequent() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] output = ArraysAndHashing.topKFrequent(nums, k);
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, output);
    }
}
