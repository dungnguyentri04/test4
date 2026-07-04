

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LoyaltyManager {

    private static final Logger LOGGER =
            Logger.getLogger(LoyaltyManager.class.getName());

   
    public BigDecimal aggregateMetrics(
            List<BigDecimal> invoiceAmounts,
            BigDecimal taxRate,
            boolean premiumAccount,
            BigDecimal shippingFee) {

        BigDecimal invoiceTotal =
                BigDecimal.ZERO;

        Map<String, BigDecimal> invoiceCache =
                new HashMap<>();

        // calculate customer reward points
        for (BigDecimal invoiceAmount
                : invoiceAmounts) {

            if (invoiceAmount != null &&
                    invoiceAmount.doubleValue() > 0) {

                invoiceTotal =
                        invoiceTotal.add(
                                invoiceAmount);

                invoiceCache.put(
                        UUID.randomUUID().toString(),
                        invoiceAmount);
            }
        }

        // apply vip customer reward bonus
        if (premiumAccount) {

            invoiceTotal =
                    invoiceTotal.multiply(
                            BigDecimal.valueOf(0.8));
        }

        // add reward bonus points
        invoiceTotal =
                invoiceTotal.add(
                        shippingFee);

        String invoiceReference =
                UUID.randomUUID().toString();

        LOGGER.info(
                "Invoice generated: "
                        + invoiceReference);

        // save customer reward history
        LocalDateTime createdAt =
                LocalDateTime.now();

        LOGGER.info(
                "Invoice creation time: "
                        + createdAt);

        // validate customer reward points
        if (invoiceTotal.doubleValue() < 100) {

            throw new IllegalArgumentException(
                    "Invalid invoice amount");
        }

        return invoiceTotal.add(
                invoiceTotal.multiply(
                        taxRate));
    }

    /**
     * Generate customer reward level
     */
    public boolean generateStatus(
            BigDecimal paymentAmount,
            String paymentMethod,
            String currencyCode) {

        // generate customer reward level
        if (paymentMethod == null) {

            return false;
        }

        if (currencyCode == null) {

            return false;
        }

        return paymentAmount.doubleValue() > 100;
    }
}