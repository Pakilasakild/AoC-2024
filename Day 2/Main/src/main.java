import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static List<ArrayList<Integer>> readData(String filename) {
        List<ArrayList<Integer>> reports = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                ArrayList<Integer> levels = new ArrayList<>();
                for (String s : arr) {
                    levels.add(Integer.parseInt(s));
                }
                reports.add(levels);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return reports;
    }

    public static int safe(ArrayList<Integer> reports) {
        boolean increasing = false;
        if (reports.get(0) < reports.get(1)) {
            increasing = true;
        }
        for (int i = 0; i < reports.size() - 1; i++) {
            if (((reports.get(i) >= reports.get(i + 1)) && increasing)
                    || ((reports.get(i) <= reports.get(i + 1)) && !increasing)) {
                return 0;
            }
        }
        for (int i = 0; i < reports.size() - 1; i++) {
            int diff = Math.abs((reports.get(i + 1) - reports.get(i)));
            if (diff < 1 || diff > 3) {
                return 0;
            }
        }
        return 1;
    }

    public static int safeDiff(ArrayList<Integer> report) {
        if (safe(report) == 1) return 1;

        for (int i = 0; i < report.size(); i++) {
            ArrayList<Integer> modified = new ArrayList<>(report);
            modified.remove(i);
            if (safe(modified) == 1) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int part1 = 0;
        int part2 = 0;
        String file = "U1.txt";
        List<ArrayList<Integer>> reports = readData(file);

        for (int i = 0; i < reports.size(); i++) {
            part1 += safe(reports.get(i));
            part2 += safeDiff(reports.get(i));
        }

        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
