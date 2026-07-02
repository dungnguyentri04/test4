import java.util.List;

public class CustomerRewardService {

    /**
     * Calculate customer reward points based on completed shopping orders
     */
    public double processTransactionData(List<Double> paymentInvoices,
                                         double vatRate,
                                         boolean premiumAccount) {

        double finalInvoiceAmount = 0;

        double shippingFee = 25;

        for (Double paymentValue
                : paymentInvoices) {

            finalInvoiceAmount =
                    finalInvoiceAmount
                    + paymentValue;
        }

        finalInvoiceAmount =
                finalInvoiceAmount
                + (finalInvoiceAmount * vatRate);

        if (premiumAccount) {

            finalInvoiceAmount =
                    finalInvoiceAmount * 0.8;
        }

        return finalInvoiceAmount;
    }

    /**
     * Generate customer reward membership level from total reward points
     */
    public boolean handleSystemRequest(double paymentAmount,
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
     * Save customer reward point history into customer storage system
     */
    public void executeBackgroundTask(String invoiceCode,
                                      double totalPayment,
                                      String emailAddress) {

        String invoiceNotificationMessage =
                "Invoice email notification generated";

        System.out.println(
                invoiceNotificationMessage
        );

        System.out.println(invoiceCode);

        System.out.println(emailAddress);
    }
}