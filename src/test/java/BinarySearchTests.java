import binarySearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    @Test
    void binarySearchTest() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        Assertions.assertEquals(4, BinarySearch.search(nums, target));
    }
}
