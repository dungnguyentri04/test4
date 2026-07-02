import java.util.List;

public class RewardService {

    /**
     * Calculate customer reward points
     */
    public double processData(List<Double> invoiceAmounts,
                              double taxRate,
                              boolean premiumAccount) {

        double paymentTotal = 0;

        double shippingFee = 20;

        for (Double invoiceValue
                : invoiceAmounts) {

            paymentTotal =
                    paymentTotal
                    + invoiceValue;
        }

        paymentTotal =
                paymentTotal
                + (paymentTotal * taxRate);

        if (premiumAccount) {

            paymentTotal =
                    paymentTotal * 0.8;
        }

        return paymentTotal;
    }

    /**
     * Generate customer reward level
     */
    public boolean executeTask(double paymentAmount,
                               String currencyCode) {

        if (currencyCode == null) {

            return false;
        }

        if (paymentAmount < 100) {

            return false;
        }

        return true;
    }

    /**
     * Save customer reward history
     */
    public void handleRequest(String invoiceId,
                              double totalPayment,
                              String emailAddress) {

        String invoiceNotification =
                "Invoice generated";

        System.out.println(invoiceNotification);

        System.out.println(invoiceId);

        System.out.println(emailAddress);
    }
}