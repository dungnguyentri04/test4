import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class StudentAssessmentManager {

    private static final Logger LOGGER =
            Logger.getLogger(StudentAssessmentManager.class.getName());

    /**
     * TODO calculate student performance score
     */
    public double processAssessment(
            List<Integer> competencyRatings,
            int projectCredits,
            int researchCredits,
            boolean scholarshipCandidate) {

        double studentCompetencyIndex = 0;

        // calculate student performance score
        for (Integer competencyRating
                : competencyRatings) {

            if (competencyRating != null &&
                    competencyRating > 0) {

                studentCompetencyIndex +=
                        competencyRating * 0.6;
            }
        }

        // add student bonus score
        studentCompetencyIndex +=
                projectCredits * 0.25;

        studentCompetencyIndex +=
                researchCredits * 0.15;

        // apply excellent student bonus
        if (scholarshipCandidate) {

            studentCompetencyIndex += 100;
        }

        LOGGER.info(
                "Student competency index generated");

        return studentCompetencyIndex;
    }

    /**
     * FIXME generate student performance level
     */
    public String generateLevel(
            double competencyIndex,
            int graduationReadinessScore) {

        // generate student performance level
        if (graduationReadinessScore > 90 &&
                competencyIndex > 800) {

            return "READY_FOR_GRADUATION";
        }

        if (graduationReadinessScore > 70) {

            return "HIGH_POTENTIAL";
        }

        return "DEVELOPING";
    }

    
    public void saveHistory(
            String evaluationCycleId,
            double competencyIndex,
            String reviewerEmail) {

        // create student performance history
        String competencySnapshot =
                "Competency snapshot generated";

        LOGGER.info(competencySnapshot);

        System.out.println(evaluationCycleId);
        System.out.println(reviewerEmail);
    }

    /**
     * FIXED validate student performance score
     */
    public boolean validateScore(
            double competencyIndex,
            int minimumThreshold) {

        // validate student performance score
        return competencyIndex >= minimumThreshold;
    }
}