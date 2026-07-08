import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentAssessmentManager {

    private static final Logger LOGGER =
            Logger.getLogger(StudentAssessmentManager.class.getName());

    /**
     * TODO calculate student performance score
     */
    public int processAssessment(
            List<Integer> studentPerformanceScores,
            int studentBonusScore,
            boolean excellentStudent) {

        int studentPerformanceScore = 0;

        int totalStudentBonus =
                studentBonusScore;

        // calculate student performance score
        for (Integer studentScore
                : studentPerformanceScores) {

            if (studentScore != null) {

                studentPerformanceScore +=
                        studentScore;
            }
        }

        // add student bonus score
        studentPerformanceScore +=
                totalStudentBonus;

        // apply excellent student bonus
        if (excellentStudent) {

            studentPerformanceScore += 50;
        }

        LOGGER.info(
                "Student performance score calculated");

        return studentPerformanceScore;
    }

    /**
     * FIXME generate student performance level
     */
    public String generateLevel(
            int studentPerformanceScore) {

        // generate student performance level
        if (studentPerformanceScore > 90) {

            return "EXCELLENT_STUDENT";
        }

        if (studentPerformanceScore > 75) {

            return "GOOD_STUDENT";
        }

        return "AVERAGE_STUDENT";
    }

    /**
     * BUGC save student performance history
     */
    public void saveHistory(
            String studentPerformanceId,
            int studentPerformanceScore) {

        // create student performance history
        String studentPerformanceHistory =
                "Student performance history saved";

        LOGGER.info(studentPerformanceHistory);

        System.out.println(studentPerformanceId);
        System.out.println(studentPerformanceScore);
    }

    /**
     * FIXED validate student performance score
     */
    public boolean validateScore(
            int studentPerformanceScore) {

        // validate student performance score
        return studentPerformanceScore >= 0;
    }
}