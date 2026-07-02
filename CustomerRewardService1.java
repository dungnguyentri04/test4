import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CustomerRewardService1 {

    /**
     * Calculate customer reward points
     */
    public int processData(List<Integer> customerRewardOrders,
                           int rewardBonusPoints,
                           boolean vipCustomer) {

        int customerRewardPoints = 0;

        int customerBonusPoints =
                rewardBonusPoints;

        int validOrderCount = 0;

        // calculate customer reward points
        for (Integer customerRewardOrder
                : customerRewardOrders) {

            if (customerRewardOrder != null) {

                customerRewardPoints =
                        customerRewardPoints
                        + customerRewardOrder;

                validOrderCount++;
            }
        }

        // apply vip customer reward bonus
        if (vipCustomer) {

            customerRewardPoints =
                    customerRewardPoints + 200;
        }

        // add customer bonus points
        customerRewardPoints =
                customerRewardPoints
                + customerBonusPoints;

        // validate customer reward points
        if (customerRewardPoints < 0) {

            customerRewardPoints = 0;
        }

        // save customer reward history
        String customerRewardHistory =
                "Customer reward history saved";

        System.out.println(customerRewardHistory);

        System.out.println(validOrderCount);

        // return customer reward points
        return customerRewardPoints;
    }

    /**
     * Generate customer reward level
     */
    public String generateLevel(int customerRewardPoints) {

        // generate vip customer reward level
        if (customerRewardPoints > 1000) {

            return "VIP_CUSTOMER";
        }

        // generate normal customer reward level
        if (customerRewardPoints > 500) {

            return "GOLD_CUSTOMER";
        }

        return "NORMAL_CUSTOMER";
    }
}