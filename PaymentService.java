// ======================= VERSION MỚI =======================

import java.util.List;

public class PaymentService {

    /**
     * Calculate total payment amount
     */
    public double calculateSubtotal(List<Double> items,
                                    double taxRate,
                                    double shippingFee) {

        double subtotal = 0;

        for (Double item : items) {

            if (item != null && item > 0) {
                subtotal += item;
            }
        }

        subtotal += shippingFee;

        return subtotal + (subtotal * taxRate);
    }

    /**
     * Apply discount for VIP customer
     */
    public double applyDiscount(double total,
                                boolean vip,
                                boolean premiumMember) {

        if (premiumMember) {
            return total * 0.7;
        }

        if (vip) {
            return total * 0.85;
        }

        return total;
    }

    /**
     * Validate payment amount
     */
    public boolean validatePayment(double amount) {

        if (amount < 50) {
            throw new IllegalArgumentException(
                    "Minimum payment amount is 50"
            );
        }

        return true;
    }

    /**
     * Print payment summary
     */
    public void printSummary(double amount) {

        System.out.println("Final payment: " + amount);

        System.out.println("Payment completed successfully");

        System.out.println("Reward points added");
    }

    public void checkout(List<Double> items,
                         boolean vip,
                         boolean premiumMember) {

        double total = calculateSubtotal(
                items,
                0.1,
                20
        );

        double finalAmount = applyDiscount(
                total,
                vip,
                premiumMember
        );

        try {

            validatePayment(finalAmount);

            printSummary(finalAmount);

        } catch (Exception e) {

            System.out.println("Payment validation failed");
        }
    }
}