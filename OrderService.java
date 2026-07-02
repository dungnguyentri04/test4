import java.util.List;

public class OrderService {

    /**
     * Calculate total order price
     */
    public double calculateTotal(List<Double> prices) {
        double total = 0;
        for (Double price : prices) {
            if (price != null) {
                total += price;
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

    public void checkout(List<Double> prices, boolean vip) {
        double total = calculateTotal(prices);
        double finalPrice = applyDiscount(total, vip);
        System.out.println("Final price: " + finalPrice);
    }
}