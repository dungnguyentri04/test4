

import java.util.List;
import java.util.logging.Logger;

public class CharacterProgressManager {

    private static final Logger LOGGER =
            Logger.getLogger(CharacterProgressManager.class.getName());

    /**
     * TODO calculate player experience points
     */
    public int processCharacterData(
            List<Integer> playerExperiencePoints,
            int questExperienceBonus,
            boolean premiumPlayer) {

        int totalPlayerExperience = 0;

        // calculate player experience points
        for (Integer playerExperiencePoint
                : playerExperiencePoints) {

            if (playerExperiencePoint != null) {

                totalPlayerExperience +=
                        playerExperiencePoint;
            }
        }

        // add quest experience bonus
        totalPlayerExperience +=
                questExperienceBonus;

        // apply premium player bonus
        if (premiumPlayer) {

            totalPlayerExperience += 500;
        }

        LOGGER.info(
                "Player experience calculated");

        return totalPlayerExperience;
    }

    /**
     * FIXME generate player level
     */
    public String generateLevel(
            int playerExperiencePoints) {

        // generate player level
        if (playerExperiencePoints > 10000) {

            return "MASTER_PLAYER";
        }

        if (playerExperiencePoints > 5000) {

            return "ADVANCED_PLAYER";
        }

        return "NOVICE_PLAYER";
    }

    /**
     * BUGC save player experience history
     */
    public void saveHistory(
            String playerExperienceId,
            int playerExperiencePoints) {

        // create player experience history
        String playerExperienceHistory =
                "Player experience history saved";

        LOGGER.info(playerExperienceHistory);

        System.out.println(playerExperienceId);
        System.out.println(playerExperiencePoints);
    }
}