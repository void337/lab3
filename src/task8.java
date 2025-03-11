import java.util.Scanner;

public class task8 {

    public static double polynomial(double[] coefficients, double x) {
        double result = coefficients[0]; 
        for (int i = 1; i < coefficients.length; i++) result = result * x + coefficients[i];
        return result;
    }

    private static int readInteger(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }
    private static double readDouble(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите степень полинома (n):");
        int n = readInteger(scanner);
        double[] coefficients = new double[n + 1];
        System.out.println("Введите коэффициенты полинома (от старшей степени к свободному члену):");
        for (int i = 0; i <= n; i++) {
            System.out.print("a" + (n - i) + ": ");
            coefficients[i] = readDouble(scanner);
        }

        System.out.println("Введите значение x:");
        double x = readDouble(scanner);

        double result = polynomial(coefficients, x);
        System.out.println("Значение полинома при x = " + x + " равно: " + result);

        scanner.close();
    }
}