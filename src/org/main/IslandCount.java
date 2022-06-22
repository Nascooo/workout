package org.main;

public class IslandCount {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {1, 0, 1, 0, 1}};
        int numberOfIslands = getNumberOfIslands(matrix);
        System.out.println(numberOfIslands);
    }


    static int getNumberOfIslands(int[][] binaryMatrix) {
        if (binaryMatrix.length == 0) return 0;
        int count = 0;
        for (int row = 0; row < binaryMatrix.length; row++) {
            for (int column = 0; column < binaryMatrix[row].length; column++) {
                if (binaryMatrix[row][column] == 1) {
                    boolean island = isIsland(binaryMatrix, row, column);
                    if (island)
                        count++;
                }
            }
        }
        return count;
    }

    private static boolean isIsland(int[][] binaryMatrix, int row, int column) {
        //searchBetween the index up down left right
        if (row < 0 || column < 0 || row >= binaryMatrix.length || column >= binaryMatrix[row].length) return false;

        if (binaryMatrix[row][column] == 1) {
            binaryMatrix[row][column] = 0;
            boolean island3 = isIsland(binaryMatrix, row - 1, column);
            boolean island2 = isIsland(binaryMatrix, row + 1, column);
            boolean island1 = isIsland(binaryMatrix, row, column + 1);
            boolean island = isIsland(binaryMatrix, row, column - 1);
            if (!island && !island1 && !island2 && !island3) {
                return true;
            }
        }
        return false;
    }


}
