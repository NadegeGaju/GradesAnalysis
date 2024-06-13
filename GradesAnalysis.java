import java.util.Arrays;
import java.util.Scanner;

public class GradesAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the grades of the students: ");
        String input = scanner.nextLine();
        String[] gradesStr = input.split(" ");
        int[] scores = new int[gradesStr.length];

        for (int i = 0; i < gradesStr.length; i++) {
            scores[i] = Integer.parseInt(gradesStr[i]);
        }int max = Arrays.stream(scores).max().getAsInt();
        int min = Arrays.stream(scores).min().getAsInt();
        double average = Arrays.stream(scores).average().getAsDouble();

        System.out.println("\nValues:");
        System.out.println("The maximum grade is " + max);
        System.out.println("The minimum grade is " + min);
        System.out.println("The average grade is " + average);
        System.out.println("\nGraph:");
        int[] scoreCounts = new int[5];

        for (int score : scores) {
            if (score >= 81) {
                scoreCounts[4]++;
            } else if (score >= 61) {
                scoreCounts[3]++;
            } else if (score >= 41) {
                scoreCounts[2]++;
            } else if (score >= 21) {
                scoreCounts[1]++;
            } else {
                scoreCounts[0]++;
            }
        }

        int maxCount = Arrays.stream(scoreCounts).max().getAsInt();

        for (int i = maxCount; i >= 1; i--) {
            System.out.printf("%2d > ", i);
            for (int j = 0; j < 5; j++) {
                int count = scoreCounts[4 - j];
                if (count >= i) {
                    System.out.print("#######");
                } else {
                    System.out.print("       ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.print("   ");
        System.out.println("I 0-20  I 21-40 I 41-60 I 61-80 I 81-100I");

        scanner.close();
    }
}