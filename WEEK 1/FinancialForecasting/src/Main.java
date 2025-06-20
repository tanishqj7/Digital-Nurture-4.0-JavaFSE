import java.util.Scanner;

public class Main {

    public static double futureValue(int n, double initialValue, double growthRate) {
        if (n == 0) return initialValue;
        return futureValue(n - 1, initialValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial amount: ");
        double initial = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (e.g., 0.05 for 5%): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double result = futureValue(years, initial, rate);
        System.out.printf("Future Value after %d years: $%.2f\n", years, result);

        scanner.close();
    }
}
