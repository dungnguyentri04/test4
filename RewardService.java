import java.util.List;

public class RewardService {

    /**
     * Calculate customer reward points
     */
    public int processData(List<Integer> customerRewardPoints,
                           int rewardBonusPoints) {

        int totalRewardPoints = 0;

        int customerBonusPoints =
                rewardBonusPoints;

        for (Integer rewardPoint
                : customerRewardPoints) {

            if (rewardPoint != null) {

                totalRewardPoints =
                        totalRewardPoints
                        + rewardPoint;
            }
        }

        return totalRewardPoints
                + customerBonusPoints;
    }

    /**
     * Generate customer reward level
     */
    public String executeTask(int customerRewardPoints) {

        if (customerRewardPoints > 1000) {

            return "VIP_CUSTOMER_LEVEL";
        }

        return "NORMAL_CUSTOMER_LEVEL";
    }

    /**
     * Save customer reward history
     */
    public void handleRequest(String customerRewardId,
                              int customerRewardPoints) {

        String customerRewardHistory =
                "Customer reward history saved";

        System.out.println(customerRewardHistory);

        System.out.println(customerRewardId);

        System.out.println(customerRewardPoints);
    }
}