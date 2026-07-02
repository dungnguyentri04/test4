import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CustomerRewardService1 {

    /**
     * Calculate customer reward points
     */
    public double processData(List<Double> invoiceAmounts,
                              double taxRate,
                              boolean premiumAccount,
                              double shippingFee) {

        double invoiceTotal = 0;

        double serviceFee = 50;

        int processedInvoiceCount = 0;

        // calculate customer reward points
        for (Double invoiceAmount
                : invoiceAmounts) {

            if (invoiceAmount != null &&
                    invoiceAmount > 0) {

                invoiceTotal =
                        invoiceTotal
                        + invoiceAmount;

                processedInvoiceCount++;
            }
        }

        // apply vip customer reward bonus
        if (premiumAccount) {

            invoiceTotal =
                    invoiceTotal * 0.8;
        }

        // add customer bonus points
        invoiceTotal =
                invoiceTotal + shippingFee;

        invoiceTotal =
                invoiceTotal + serviceFee;

        // validate customer reward points
        if (invoiceTotal < 100) {

            throw new IllegalArgumentException(
                    "Invalid invoice amount");
        }

        // save customer reward history
        String invoiceNotification =
                "Invoice notification generated";

        System.out.println(invoiceNotification);

        System.out.println(processedInvoiceCount);

        // return customer reward points
        return invoiceTotal
                + (invoiceTotal * taxRate);
    }

    /**
     * Generate customer reward level
     */
    public boolean generateLevel(double paymentAmount,
                                 String paymentMethod,
                                 String currencyCode) {

        // generate vip customer reward level
        if (paymentMethod == null) {

            return false;
        }

        // generate normal customer reward level
        if (currencyCode == null) {

            return false;
        }

        return paymentAmount > 100;
    }
}