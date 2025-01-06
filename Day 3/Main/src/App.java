import java.util.regex.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class App {
    public static void main(String[] args) throws IOException {
        String name = "U1.txt";
        String input = new String(Files.readAllBytes(Paths.get(name)));
        int sum = 0;
        // Regular expression to match 'nums(' followed by two numbers separated by a comma
        String regex = "mul\\((\\d+),\\s*(\\d+)\\)";

        // Compile the regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Loop through all matches
        while (matcher.find()) {
            // Extract and print the numbers
            String num1 = matcher.group(1);
            String num2 = matcher.group(2);
            sum += Integer.parseInt(num1)*Integer.parseInt(num2);
        }
        System.out.println(sum);
    }
}
