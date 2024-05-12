import java.util.Arrays;

/**
 * You are given an n x n integer matrix grid.
 * <p>
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * <p>
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 * <p>
 * Return the generated matrix.
 * <p>
 * Example 1:
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * Output: [[9,9],[8,6]]
 * Explanation: The diagram above shows the original matrix and the generated matrix.
 * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
 */

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };
        Solution solution = new Solution();
        int[][] result = solution.largestLocal(array);

        assert (Arrays.deepEquals(result, (new int[][]{
                {9, 9},
                {8, 6}
        })));

        System.out.println(Arrays.deepToString(result));

    }
}

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] newArr = new int[grid.length - 2][grid[0].length - 2];
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[0].length; j++) {
                newArr[i][j] = findMaxValue(grid, i + 1, j + 1);
            }
        }
        return newArr;
    }

    private int findMaxValue(int[][] grid, int x, int y) {
        int max = Integer.MIN_VALUE;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (grid[i][j] > max)
                    max = grid[i][j];
            }
        }
        return max;
    }
}