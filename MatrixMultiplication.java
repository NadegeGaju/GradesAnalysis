import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows for matrix A:");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix A:");
        int colsA = scanner.nextInt();
        int[][] matrixA = readMatrix(scanner, rowsA, colsA);
        System.out.println("Enter the number of rows for matrix B:");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for matrix B:");
        int colsB = scanner.nextInt();
        int[][] matrixB = readMatrix(scanner, rowsB, colsB);
        int[][] matrixC = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);
        System.out.println("Matrix C:");
        printMatrix(matrixC, rowsA, colsB);
    }
    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int rowsA, int colsA, int colsB) {
        int[][] matrixC = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixC;
    }
    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
    }
}