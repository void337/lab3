import java.util.Scanner;

enum CirclePosition {
    NO_INTERSECTION,       // Окружности не пересекаются и не вложены
    TOUCHING,             // Окружности касаются в одной точке
    TWO_INTERSECTIONS,    // Окружности пересекаются в двух точках
    COINCIDENT,           // Окружности совпадают
    SECOND_INSIDE_FIRST,  // Вторая окружность вложена в первую
    FIRST_INSIDE_SECOND   // Первая окружность вложена во вторую
}

public class task4 {

    public static CirclePosition checkCircles(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (distance == 0 && r1 == r2) return CirclePosition.COINCIDENT;

        if (distance == r1 + r2) return CirclePosition.TOUCHING;
        
        if (distance < r1 + r2 && distance > Math.abs(r1 - r2)) return CirclePosition.TWO_INTERSECTIONS; 

        if (distance == Math.abs(r1 - r2)) return CirclePosition.TOUCHING;
        
        if (distance < Math.abs(r1 - r2)) {
            if (r1 > r2) return CirclePosition.SECOND_INSIDE_FIRST;
            else return CirclePosition.FIRST_INSIDE_SECOND;
        }
        return CirclePosition.NO_INTERSECTION;
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

        System.out.println("Введите координаты центра первой окружности (x1, y1):");
        int x1 = readInteger(scanner);
        int y1 = readInteger(scanner);

        System.out.println("Введите радиус первой окружности (r1):");
        int r1 = readInteger(scanner);

        System.out.println("Введите координаты центра второй окружности (x2, y2):");
        int x2 = readInteger(scanner);
        int y2 = readInteger(scanner);
        System.out.println("Введите радиус второй окружности (r2):");
        int r2 = readInteger(scanner);

        CirclePosition result = checkCircles(x1, y1, r1, x2, y2, r2);

        switch (result) {
            case NO_INTERSECTION -> System.out.println("Окружности не пересекаются и ни одна из них не вложена в другую.");
            case TOUCHING -> System.out.println("Окружности касаются в одной точке.");
            case TWO_INTERSECTIONS -> System.out.println("Окружности пересекаются в двух точках.");
            case COINCIDENT -> System.out.println("Окружности совпадают.");
            case SECOND_INSIDE_FIRST -> System.out.println("Вторая окружность вложена в первую.");
            case FIRST_INSIDE_SECOND -> System.out.println("Первая окружность вложена во вторую.");
            default -> System.out.println("Неизвестный результат.");
        }
        scanner.close();
    }
}