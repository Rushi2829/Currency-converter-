import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates;

    static {
        // Hardcoded exchange rates (replace with actual API calls)
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Available Currencies: USD, EUR, GBP");
        
        // Input base and target currencies
        System.out.print("Enter base currency code: ");
        String baseCurrency = scanner.next().toUpperCase();
        
        System.out.print("Enter target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();

        // Input amount to convert
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform currency conversion
        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display the result
        System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseRate = exchangeRates.get(baseCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        // Perform currency conversion
        return (amount / baseRate) * targetRate;
    }
}