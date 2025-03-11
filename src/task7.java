import java.util.Scanner;

public class task7 {

    public static String convertToBase(int decimalNumber, int base) {
        if (decimalNumber == 0) return "0";
        StringBuilder result = new StringBuilder(); // Для хранения результата

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            result.insert(0, remainder);
            decimalNumber = decimalNumber / base;
        }

        return result.toString();
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число в десятичной системе:");
        int decimalNumber = readInteger(scanner);
        System.out.println("Введите основание системы счисления (от 2 до 8):");
        int base = readInteger(scanner);

        if (base < 2 || base > 8) {
            System.out.println("Ошибка! Основание системы счисления должно быть от 2 до 8.");
            return;
        }

        String convertedNumber = convertToBase(decimalNumber, base);
        System.out.println("Число " + decimalNumber + " в системе счисления с основанием " + base + " равно: " + convertedNumber);

        String checkResult = Integer.toString(decimalNumber, base);
        System.out.println("Проверка с использованием Integer.toString(): " + checkResult);

        scanner.close();
    }
}