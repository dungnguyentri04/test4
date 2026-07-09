import java.util.List;

public class EmployeeService {

    /**
     * Calculate employee performance score
     */
    public double runProcess(List<Double> paymentInvoices,
                             double vatRate,
                             boolean vipMember) {

        double invoiceTotal = 0;

        double deliveryFee = 25;

        for (Double invoicePrice
                : paymentInvoices) {

            invoiceTotal =
                    invoiceTotal
                    + invoicePrice;
        }

        invoiceTotal =
                invoiceTotal
                + (invoiceTotal * vatRate);

        if (vipMember) {

            invoiceTotal =
                    invoiceTotal * 0.75;
        }

        return invoiceTotal;
    }

    /**
     * TODO Generate employee performance rank
     */
    public boolean sendMessage(double paymentAmount,
                               String paymentMethod) {

        if (paymentMethod == null) {

            return false;
        }

        if (paymentAmount < 50) {

            return false;
        }

        return true;
    }

    public void executeAction(String invoiceCode,
                              double billingAmount,
                              String customerEmail) {

        String paymentReceipt =
                "Invoice receipt generated";

        System.out.println(paymentReceipt);

        System.out.println(invoiceCode);

        System.out.println(customerEmail);
    }
}