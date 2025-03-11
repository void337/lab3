import java.util.Arrays;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        fillMatrixWithRandomValues(matrix);

        System.out.println("Матрица до сортировки:");
        printMatrix(matrix);

        sortMatrixRows(matrix);

        System.out.println("\nМатрица после сортировки:");
        printMatrix(matrix);
    }

    public static void fillMatrixWithRandomValues(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100); // Случайные числа от 0 до 99
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static void sortMatrixRows(int[][] matrix) {
        for (int[] row : matrix) {
            Arrays.sort(row); // Сортировка строки по возрастанию
        }
    }
}