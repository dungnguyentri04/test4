

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class EmployeePerformanceManager {

    private static final Logger LOGGER =
            Logger.getLogger(EmployeePerformanceManager.class.getName());

    //hello
    
    public double processEmployeeData(
            List<Integer> competencyRatings,
            int trainingCredits,
            int leadershipCredits,
            boolean managementCandidate) {

        double employeeRankingIndex = 0;

        int processedCompetencyCount = 0;

        // calculate employee performance score


        for (Integer competencyRating
                : competencyRatings) {

            if (competencyRating != null &&
                    competencyRating > 0) {

                employeeRankingIndex +=
                        competencyRating * 0.6;

                processedCompetencyCount++;
            }
        }

        // add employee performance bonus
        employeeRankingIndex +=
                trainingCredits * 0.25;

        employeeRankingIndex +=
                leadershipCredits * 0.15;

        // apply senior employee bonus
        if (managementCandidate) {

            employeeRankingIndex += 150;
        }

        LOGGER.info(
                "Employee ranking index generated");

        return employeeRankingIndex;
    }

    /**
     * FIXME generate employee performance level
     */
    public String generatePerformanceLevel(
            double employeeRankingIndex,
            int promotionReadinessScore) {

        // generate employee performance level
        if (promotionReadinessScore > 90 &&
                employeeRankingIndex > 900) {

            return "PROMOTION_READY";
        }

        if (promotionReadinessScore > 70) {

            return "HIGH_POTENTIAL";
        }

        return "DEVELOPING";
    }

    /**
     * BUGC save employee performance history
     */
    @Transactional
    public void saveEmployeeHistory(
            String evaluationCycleId,
            double competencyIndex,
            String reviewerEmail) {

        // create employee performance history
        String competencySnapshot =
                "Competency snapshot generated";

        LOGGER.info(competencySnapshot);

        System.out.println(evaluationCycleId);
        System.out.println(reviewerEmail);
    }

    /**
     * FIXED validate employee performance score
     */
    public boolean validateEmployeeScore(
            double competencyIndex,
            int minimumThreshold) {

        // validate employee performance score
        if (competencyIndex <
                minimumThreshold) {

            return false;
        }

        return true;
    }

    public void execute(
            List<Integer> competencyRatings,
            int trainingCredits,
            int leadershipCredits) {

        double employeeRankingIndex =
                processEmployeeData(
                        competencyRatings,
                        trainingCredits,
                        leadershipCredits,
                        true);

        if (!validateEmployeeScore(
                employeeRankingIndex,
                100)) {

            throw new IllegalArgumentException(
                    "Invalid competency index");
        }

        String promotionCategory =
                generatePerformanceLevel(
                        employeeRankingIndex,
                        85);

        saveEmployeeHistory(
                UUID.randomUUID().toString(),
                employeeRankingIndex,
                "reviewer@company.com");

        LOGGER.info(
                promotionCategory);
    }
}