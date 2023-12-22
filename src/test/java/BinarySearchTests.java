import binarySearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    @Test
    void binarySearchTest() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int output = BinarySearch.search(nums, target);
        int expected = 4;
        Assertions.assertEquals(expected, output);
    }

    @Test
    void searchMatrixTest() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 11;
        boolean output = BinarySearch.searchMatrix(matrix, target);
        boolean expected = true;
        Assertions.assertEquals(expected, output);
    }

    @Test
    void minEatingSpeedTest() {
        int[] piles = {805306368, 805306368, 805306368};
        int h = 1000000000;
        int k = BinarySearch.minEatingSpeed(piles, h);
        int expected = 3;
        Assertions.assertEquals(expected, k);
    }

    @Test
    void findMinTest() {
        int[] nums = {5, 1, 2, 3, 4};
        int output = BinarySearch.findMin(nums);
        int expected = 1;
        Assertions.assertEquals(expected, output);
    }

    @Test
    void searchRotatedTest() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int output = BinarySearch.searchRotated(nums, target);
        int expected = 4;
        Assertions.assertEquals(expected, output);

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        target = 3;
        output = BinarySearch.searchRotated(nums2, target);
        expected = -1;
        Assertions.assertEquals(expected, output);

        int[] nums3 = {1};
        target = 0;
        output = BinarySearch.searchRotated(nums3, target);
        Assertions.assertEquals(expected, output);

        int[] nums4 = {1, 3};
        target = 3;
        output = BinarySearch.searchRotated(nums4, target);
        expected = 1;
        Assertions.assertEquals(expected, output);
    }
}
