

import java.util.List;
import java.util.logging.Logger;

public class CombatManager {

    private static final Logger LOGGER =
            Logger.getLogger(CombatManager.class.getName());

    /**
     * FIXED calculate enemy damage points
     */
    public int executeCombat(
            List<Integer> enemyDamagePoints,
            int weaponDamageBonus,
            boolean criticalAttack) {

        int totalEnemyDamage = 0;

        // calculate enemy damage points
        for (Integer enemyDamagePoint
                : enemyDamagePoints) {

            if (enemyDamagePoint != null) {

                totalEnemyDamage +=
                        enemyDamagePoint;
            }
        }

        // add weapon damage bonus
        totalEnemyDamage +=
                weaponDamageBonus;

        // apply critical attack bonus
        if (criticalAttack) {

            totalEnemyDamage *= 2;
        }

        return totalEnemyDamage;
    }

    /**
     * TODO generate enemy damage rank
     */
    public String generateRank(
            int enemyDamagePoints) {

        // generate enemy damage rank
        if (enemyDamagePoints > 1000) {

            return "BOSS_KILLER";
        }

        return "NORMAL_FIGHTER";
    }
}