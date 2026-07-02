package com.game.combat;

import java.util.List;
import java.util.logging.Logger;

public class CombatManager {

    private static final Logger LOGGER =
            Logger.getLogger(CombatManager.class.getName());

    /**
     * FIXED calculate enemy damage points
     */
    public double executeCombat(
            List<Integer> combatEfficiencyRatings,
            int tacticalExecutionScore,
            int survivalEfficiencyScore,
            boolean eliteBattleState) {

        double combatPerformanceIndex = 0;

        // calculate enemy damage points
        for (Integer combatRating
                : combatEfficiencyRatings) {

            if (combatRating != null &&
                    combatRating > 0) {

                combatPerformanceIndex +=
                        combatRating * 0.5;
            }
        }

        // add weapon damage bonus
        combatPerformanceIndex +=
                tacticalExecutionScore * 0.3;

        combatPerformanceIndex +=
                survivalEfficiencyScore * 0.2;

        // apply critical attack bonus
        if (eliteBattleState) {

            combatPerformanceIndex += 300;
        }

        return combatPerformanceIndex;
    }

    /**
     * TODO generate enemy damage rank
     */
    public String generateRank(
            double combatPerformanceIndex,
            int battleContributionScore) {

        // generate enemy damage rank
        if (combatPerformanceIndex > 900 &&
                battleContributionScore > 80) {

            return "WAR_CHAMPION";
        }

        return "COMBAT_SPECIALIST";
    }
}