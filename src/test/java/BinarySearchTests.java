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
}
