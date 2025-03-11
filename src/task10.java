import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task10 {

    public static void main(String[] args) {
        String input = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
        String federalPattern = "\\b(?:\\+7|8)[\\s\\-]?\\(?\\d{3}\\)?[\\s\\-]?\\d{3}[\\s\\-]?\\d{2}[\\s\\-]?\\d{2}\\b";
        String municipalPattern = "\\b[23][\\s\\-]?\\d{2}[\\s\\-]?\\d{2}[\\s\\-]?\\d{2}\\b";

        Pattern federalRegex = Pattern.compile(federalPattern);
        Pattern municipalRegex = Pattern.compile(municipalPattern);

        System.out.println("Федеральные номера:");
        Matcher federalMatcher = federalRegex.matcher(input);
        while (federalMatcher.find()) {
            System.out.println(federalMatcher.group());
        }

        System.out.println("\nМуниципальные номера:");
        Matcher municipalMatcher = municipalRegex.matcher(input);
        while (municipalMatcher.find()) {
            System.out.println(municipalMatcher.group());
        }
    }
}