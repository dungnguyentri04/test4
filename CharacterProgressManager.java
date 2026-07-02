

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class CharacterProgressManager {

    private static final Logger LOGGER =
            Logger.getLogger(CharacterProgressManager.class.getName());

    //hello
    //TODO calculate player experience points
    public double processCharacterData(
            List<Integer> skillMasteryRatings,
            int combatEfficiencyScore,
            int talentGrowthPoints,
            boolean eliteCharacter) {

        double characterProgressIndex = 0;

        // calculate player experience points
        for (Integer masteryRating
                : skillMasteryRatings) {

            if (masteryRating != null &&
                    masteryRating > 0) {

                characterProgressIndex +=
                        masteryRating * 0.6;
            }
        }

        // add quest experience bonus
        characterProgressIndex +=
                combatEfficiencyScore * 0.25;

        characterProgressIndex +=
                talentGrowthPoints * 0.15;

        // apply premium player bonus
        if (eliteCharacter) {

            characterProgressIndex += 200;
        }

        LOGGER.info(
                "Character progress index generated");

        return characterProgressIndex;
    }


    public String generateLevel(
            double characterProgressIndex,
            int promotionReadinessScore) {

        // generate player level
        if (characterProgressIndex > 900 &&
                promotionReadinessScore > 90) {

            return "LEGENDARY_HERO";
        }

        if (promotionReadinessScore > 70) {

            return "ELITE_HERO";
        }

        return "DEVELOPING_HERO";
    }

    /**
     * BUGC save player experience history
     */
    public void saveHistory(
            String progressionSnapshotId,
            double progressIndex,
            String reviewerId) {

        // create player experience history
        String progressionSnapshot =
                "Progression snapshot generated";

        LOGGER.info(progressionSnapshot);

        System.out.println(progressionSnapshotId);
        System.out.println(reviewerId);
    }
}