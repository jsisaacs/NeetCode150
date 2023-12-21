package binarySearch;

public class BinarySearch {
    /**
     * 704. Binary Search
     * @param nums int array sorted in ascending order
     * @param target int
     * @return the index of target if it exists in nums, otherwise -1
     * @implNote time is O(logn), space is O(1)
     */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    /**
     * 74. Search a 2D Matrix
     * @param matrix m x n int matrix; each row is sorted in non-decreasing order; 1st int of each row is greater than
     *               the last int of the previous row
     * @param target int
     * @return true if target is in matrix, false otherwise
     * @implNote time is O(log(nm)), space is O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int columns = matrix[0].length;
        int targetRow = -1;
        while (startRow <= endRow) {
            int middleRow = startRow + (endRow - startRow) / 2;
            if (matrix[middleRow][0] <= target && matrix[middleRow][columns - 1] >= target) {
                targetRow = middleRow;
                break;
            }
            else if (matrix[middleRow][0] < target) {
                startRow = middleRow + 1;
            }
            else {
                endRow = middleRow - 1;
            }
        }
        if (targetRow == -1) return false;
        int leftCol = 0;
        int rightCol = matrix[targetRow].length - 1;
        while (leftCol <= rightCol) {
            int middleCol = leftCol + (rightCol - leftCol) / 2;
            if (matrix[targetRow][middleCol] == target) return true;
            else if (matrix[targetRow][middleCol] < target) leftCol = middleCol + 1;
            else rightCol = middleCol - 1;
        }
        return false;
    }
}
