import java.io.*;              // For file handling
import java.nio.file.*;        // For reading entire file at once
import java.util.regex.*;      // For regex pattern matching

public class App2 {
    public static void main(String[] args) {
        try {
            // Specify the file path
            String filePath = "U1.txt"; // Replace with your file path

            // Read the entire file content at once into a string
            String input = new String(Files.readAllBytes(Paths.get(filePath)));

            // Regular expressions
            String mulRegex = "mul\\((\\d+),\\s*(\\d+)\\)";  // Matches mul(x, y)
            String doRegex = "do\\(\\)";                         // Matches do()
            String dontRegex = "don't\\(\\)";                     // Matches don't()

            // Compile regex patterns
            Pattern mulPattern = Pattern.compile(mulRegex);
            Pattern doPattern = Pattern.compile(doRegex);
            Pattern dontPattern = Pattern.compile(dontRegex);

            // Track whether mul is enabled (default: enabled)
            boolean isMulEnabled = true;

            // Process the input string
            Matcher mulMatcher = mulPattern.matcher(input);
            Matcher doMatcher = doPattern.matcher(input);
            Matcher dontMatcher = dontPattern.matcher(input);

            int sum = 0; // Sum of results

            int index = 0; // Current index while scanning

            // Scan through the input string
            while (index < input.length()) {
                // Check for 'don't()'
                if (dontMatcher.find(index) && dontMatcher.start() == index) {
                    isMulEnabled = false;
                    index = dontMatcher.end();
                } 
                // Check for 'do()'
                else if (doMatcher.find(index) && doMatcher.start() == index) {
                    isMulEnabled = true;
                    index = doMatcher.end();
                } 
                // Check for 'mul(x, y)'
                else if (mulMatcher.find(index) && mulMatcher.start() == index) {
                    if (isMulEnabled) {
                        int num1 = Integer.parseInt(mulMatcher.group(1));
                        int num2 = Integer.parseInt(mulMatcher.group(2));
                        sum += num1 * num2; // Add product to sum
                    }
                    index = mulMatcher.end();
                } 
                // Move to the next character if no match
                else {
                    index++;
                }
            }

            // Print the final result
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
