// ========================== VERSION MỚI ==========================

import java.util.List;

public class UserPointService {

    /**
     * Calculate reward points for customer
     */
    public double calculateRewardPoints(List<Double> payments,
                                        double taxRate,
                                        boolean premiumMember) {

        double subtotal = 0;

        double shippingFee = 25;

        for (Double payment : payments) {

            subtotal += payment;
        }

        subtotal = subtotal + (subtotal * taxRate);

        if (premiumMember) {

            subtotal = subtotal * 0.8;
        }

        return subtotal;
    }

    /**
     * Generate customer level
     */
    public boolean generateLevel(double amount,
                                 String currency) {

        if (currency == null) {
            return false;
        }

        if (amount < 50) {
            return false;
        }

        return true;
    }

    /**
     * Save customer point history
     */
    public void saveHistory(String invoiceId,
                            double amount,
                            String email) {

        String notification = "Invoice generated";

        System.out.println(notification);

        System.out.println(invoiceId);

        System.out.println(email);
    }
}