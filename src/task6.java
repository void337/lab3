import java.util.Scanner;

public class task6 {

    public static double leftRectangleIntegration(double[] x, double[] y) {
        double integral = 0.0;
        for (int i = 0; i < x.length - 1; i++) {
            double width = x[i + 1] - x[i];
            double height = y[i];
            integral += width * height;
        }
        return integral;
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

    public static double exactIntegral(double a, double b) {
        return (Math.exp(b) - Math.exp(a)) - (Math.pow(b, 4) / 4 - Math.pow(a, 4) / 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало интервала (a):");
        double a = readDouble(scanner);
        System.out.println("Введите конец интервала (b):");
        double b = readDouble(scanner);
        int numPoints = 101;
        double step = (b - a) / (numPoints - 1);
        double[] x = new double[numPoints];
        double[] y = new double[numPoints];

        for (int i = 0; i < numPoints; i++) {
            x[i] = a + i * step; 
            y[i] = Math.exp(x[i]) - Math.pow(x[i], 3); 
        }

        double numericalIntegral = leftRectangleIntegration(x, y);
        double exactIntegralValue = exactIntegral(a, b);

        System.out.println("Начало интервала: " + a);
        System.out.println("Конец интервала: " + b);
        System.out.println("Численное значение интеграла: " + numericalIntegral);
        System.out.println("Точное значение интеграла: " + exactIntegralValue);
        System.out.println("Разница: " + Math.abs(numericalIntegral - exactIntegralValue));
        scanner.close();
    }
}
