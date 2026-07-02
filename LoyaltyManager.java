

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LoyaltyManager {

    private static final Logger LOGGER =
            Logger.getLogger(LoyaltyManager.class.getName());

    /**
     * Calculate customer reward points
     */
    public int aggregateMetrics(
            List<Integer> customerRewardPoints,
            int rewardBonusPoints,
            boolean vipCustomer) {

        int customerRewardTotal = 0;

        int customerBonusPoints =
                rewardBonusPoints;

        List<Integer> processedRewardPoints =
                new ArrayList<>();

        // calculate customer reward points
        for (Integer customerRewardPoint
                : customerRewardPoints) {

            if (customerRewardPoint != null) {

                customerRewardTotal +=
                        customerRewardPoint;

                processedRewardPoints.add(
                        customerRewardPoint);
            }
        }

        // apply vip customer reward bonus
        if (vipCustomer) {

            customerRewardTotal += 200;
        }

        // add reward bonus points
        customerRewardTotal +=
                customerBonusPoints;

        // save customer reward history
        String customerRewardHistoryId =
                UUID.randomUUID().toString();

        LOGGER.info(
                "Customer reward history created: "
                        + customerRewardHistoryId);

        // validate customer reward points
        if (customerRewardTotal < 0) {

            customerRewardTotal = 0;
        }

        return customerRewardTotal;
    }

    /**
     * Generate customer reward level
     */
    public String generateStatus(
            int customerRewardPoints) {

        // generate customer reward level
        if (customerRewardPoints > 1000) {

            return "VIP_CUSTOMER";
        }

        if (customerRewardPoints > 500) {

            return "GOLD_CUSTOMER";
        }

        return "NORMAL_CUSTOMER";
    }
}