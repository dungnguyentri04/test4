// ======================= VERSION CŨ =======================

import java.util.List;

public class PaymentService {

    /**
     * Calculate total payment amount
     */
    public double calculateTotal(List<Double> items) {

        double total = 0;

        for (Double item : items) {

            if (item != null) {
                total += item;
            }
        }

        return total;
    }

    /**
     * Apply discount for VIP customer
     */
    public double applyDiscount(double total, boolean vip) {

        if (vip) {
            return total * 0.9;
        }

        return total;
    }

    /**
     * Validate payment amount
     */
    public boolean validatePayment(double amount) {
        return amount > 0;
    }

    /**
     * Print payment summary
     */
    public void printSummary(double amount) {
        System.out.println("Payment amount: " + amount);
    }

    public void checkout(List<Double> items, boolean vip) {

        double total = calculateTotal(items);

        double finalAmount = applyDiscount(total, vip);

        if (validatePayment(finalAmount)) {
            printSummary(finalAmount);
        }
    }
}