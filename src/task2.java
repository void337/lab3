import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = readInteger(scanner, "Введите количество строк (n): ");
        int m = readInteger(scanner, "Введите количество столбцов (m): ");
        scanner.close();

        int[][] nums = new int[n][m];
        fillArrayWithRandomValues(nums);

        System.out.println("Сгенерированный массив:");
        printArray(nums);

        Integer maxNegative = findMaxNegative(nums);
        if (maxNegative != null) {
            System.out.println("Наибольший отрицательный элемент: " + maxNegative);
        } else {
            System.out.println("В массиве нет отрицательных элементов.");
        }
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    public static void fillArrayWithRandomValues(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(200) - 100; // Случайные числа от -100 до 100
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static Integer findMaxNegative(int[][] array) {
        Integer maxNegative = null;
        for (int[] row : array) {
            for (int element : row) {
                if (element < 0) {
                    if (maxNegative == null || element > maxNegative) {
                        maxNegative = element;
                    }
                }
            }
        }
        return maxNegative;
    }
}