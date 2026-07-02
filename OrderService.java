import java.util.List;

public class OrderService {

    /**
     * Calculate total order price
     */
    public double calculateSubtotal(List<Double> prices, double taxRate) {
        double subtotal = 0;
        for (Double price : prices) {
            if (price != null && price > 0) {
                subtotal += price;
            }
        }
        return subtotal + (subtotal * taxRate);
    }

    /**
     * Apply discount for VIP customer
     */
    public double applyDiscount(double total, boolean vip, boolean premium) {
        if (premium) {
            return total * 0.8;
        }
        if (vip) {
            return total * 0.9;
        }
        return total;
    }

    public void validatePayment(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkout(List<Double> prices, boolean vip, boolean premium) {
        double total = calculateSubtotal(prices, 0.1);
        double finalPrice = applyDiscount(total, vip, premium);
        try {
            validatePayment(finalPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid payment");
        }
        System.out.println("Final price: " + finalPrice);
    }
}