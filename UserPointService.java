// ========================== VERSION CŨ ==========================

import java.util.List;

public class UserPointService {

    /**
     * Calculate reward points for customer
     */
    public int calculateRewardPoints(List<Integer> orders,
                                     int bonusPoint) {

        int totalPoint = 0;

        int extraPoint = bonusPoint;

        for (Integer order : orders) {

            if (order != null) {

                totalPoint = totalPoint + order;
            }
        }

        return totalPoint + extraPoint;
    }

    /**
     * Generate customer level
     */
    public String generateLevel(int totalPoint) {

        if (totalPoint > 1000) {
            return "VIP";
        }

        return "NORMAL";
    }

    /**
     * Save customer point history
     */
    public void saveHistory(String userId,
                            int totalPoint) {

        String message = "Point saved";

        System.out.println(message);

        System.out.println(userId + ":" + totalPoint);
    }
}