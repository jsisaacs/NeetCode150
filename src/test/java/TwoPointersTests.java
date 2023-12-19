import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import twoPointers.TwoPointers;

import java.util.List;

public class TwoPointersTests {
    @Test
    void isPalindromeTest() {
        String s = "aba";
        boolean out = TwoPointers.isPalindrome(s);
        Assertions.assertTrue(out);
    }

    @Test
    void twoSumSortedInputTest() {
        int[] nums = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int t = 542;
        int[] expected = {24, 32};
        Assertions.assertArrayEquals(expected, TwoPointers.twoSumSortedInput(nums, t));
    }

    @Test
    void threeSumTest() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> answer = TwoPointers.threeSum(nums);
        List<List<Integer>> expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        Assertions.assertEquals(expected, answer);
    }
}
