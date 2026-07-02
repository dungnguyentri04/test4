import java.util.List;

public class CustomerRewardService {

    /**
     * Calculate customer reward points based on completed shopping orders
     */
    public int processTransactionData(List<Integer> customerRewardOrders,
                                      int rewardPointBonus) {

        int customerRewardPoints = 0;

        int additionalRewardPoints =
                rewardPointBonus;

        for (Integer rewardOrderPoint
                : customerRewardOrders) {

            if (rewardOrderPoint != null) {

                customerRewardPoints =
                        customerRewardPoints
                        + rewardOrderPoint;
            }
        }

        return customerRewardPoints
                + additionalRewardPoints;
    }

    /**
     * Generate customer reward membership level from total reward points
     */
    public String handleSystemRequest(int customerRewardPoints) {

        if (customerRewardPoints > 1000) {

            return "VIP_REWARD_CUSTOMER";
        }

        return "NORMAL_REWARD_CUSTOMER";
    }

    /**
     * Save customer reward point history into customer storage system
     */
    public void executeBackgroundTask(String customerRewardId,
                                      int customerRewardPoints) {

        String customerRewardHistoryMessage =
                "Customer reward history saved";

        System.out.println(
                customerRewardHistoryMessage
        );

        System.out.println(customerRewardId);

        System.out.println(customerRewardPoints);
    }
}