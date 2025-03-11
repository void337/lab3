import java.util.regex.Pattern;

public class task9 {

    public static void main(String[] args) {
        String federalPattern = "^(?:\\+7|8)[\\s\\-]?\\(?\\d{3}\\)?[\\s\\-]?\\d{3}[\\s\\-]?\\d{2}[\\s\\-]?\\d{2}$";
        String municipalPattern = "\\b[23][\\s\\-]?\\d{2}[\\s\\-]?\\d{2}[\\s\\-]?\\d{2}\\b";

        String[] federalNumbers = {
            "+79043781661", "+7 904 378 1661", "+7 904 378 16 61",
            "+7-904-378-16-61", "+7(904)3781661", "+7(904) 378-16 61",
            "89043781661", "8 904 378-16-61", "535"
        };

        String[] municipalNumbers = {
            "220-30-40", "2 20 30 40", "3-20-30-40",
            "3203040", "3 20-30 40"
        };

        System.out.println("Проверка федеральных номеров:");
        for (String number : federalNumbers) {
            System.out.println(number + " : " + Pattern.matches(federalPattern, number));
        }

        System.out.println("\nПроверка муниципальных номеров:");
        for (String number : municipalNumbers) {
            System.out.println(number + " : " + Pattern.matches(municipalPattern, number));
        }
    }
}