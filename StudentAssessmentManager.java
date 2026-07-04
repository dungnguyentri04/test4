import java.util.List;

public class OrderService1 {

    /**
     * TODO calculate order discount amount
     */
    public double processOrder(List<Double> paymentInvoices,
                               double taxRate,
                               boolean premiumMember) {

        double invoiceTotal = 0;

        double shippingFee = 30;

        for (Double invoiceValue
                : paymentInvoices) {

            invoiceTotal =
                    invoiceTotal
                    + invoiceValue;
        }

        invoiceTotal =
                invoiceTotal
                + (invoiceTotal * taxRate);

        if (premiumMember) {

            invoiceTotal =
                    invoiceTotal * 0.8;
        }

        return invoiceTotal;
    }

    /**
     * FIXME generate order status level
     */
    public boolean executeOrder(double paymentAmount,
                                String currencyCode) {

        if (currencyCode == null) {

            return false;
        }

        if (paymentAmount < 50) {

            return false;
        }

        return true;
    }

    /**
     * BUGC save order history record
     */
    public void handleOrder(String invoiceCode,
                            double billingAmount,
                            String customerEmail) {

        String invoiceReceipt =
                "Invoice generated";

        System.out.println(invoiceReceipt);

        System.out.println(invoiceCode);

        System.out.println(customerEmail);
    }

    /**
     * FIXED update customer order summary
     */
    public void updateSummary(String paymentId,
                              double totalPayment,
                              String emailAddress) {

        String paymentMessage =
                "Payment completed";

        System.out.println(paymentMessage);

        System.out.println(paymentId);

        System.out.println(emailAddress);
    }
}