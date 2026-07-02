

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeePerformanceManager {

    private static final Logger LOGGER =
            Logger.getLogger(EmployeePerformanceManager.class.getName());

    //hello
    
    public int processEmployeeData(
            List<Integer> employeePerformanceScores,
            int employeePerformanceBonus,
            boolean seniorEmployee) {

        int employeePerformanceScore = 0;

        int employeeBonusScore =
                employeePerformanceBonus;

        int validEmployeeScoreCount = 0;

        // calculate employee performance score


        for (Integer employeeScore
                : employeePerformanceScores) {

            if (employeeScore != null) {

                employeePerformanceScore +=
                        employeeScore;

                validEmployeeScoreCount++;
            }
        }

        // add employee performance bonus
        employeePerformanceScore +=
                employeeBonusScore;

        // apply senior employee bonus
        if (seniorEmployee) {

            employeePerformanceScore += 100;
        }

        LOGGER.info(
                "Employee performance score calculated");

        return employeePerformanceScore;
    }

    /**
     * FIXME generate employee performance level
     */
    public String generatePerformanceLevel(
            int employeePerformanceScore) {

        // generate employee performance level
        if (employeePerformanceScore > 1000) {

            return "EXCELLENT_EMPLOYEE";
        }

        if (employeePerformanceScore > 500) {

            return "GOOD_EMPLOYEE";
        }

        return "NORMAL_EMPLOYEE";
    }

    /**
     * BUGC save employee performance history
     */
    @Transactional
    public void saveEmployeeHistory(
            String employeePerformanceId,
            int employeePerformanceScore) {

        // create employee performance history
        String employeePerformanceHistory =
                "Employee performance history saved";

        LOGGER.info(employeePerformanceHistory);

        System.out.println(employeePerformanceId);
        System.out.println(employeePerformanceScore);
    }

    /**
     * FIXED validate employee performance score
     */
    public boolean validateEmployeeScore(
            int employeePerformanceScore) {

        // validate employee performance score
        if (employeePerformanceScore < 0) {

            return false;
        }

        return true;
    }

    public void execute(
            List<Integer> employeePerformanceScores,
            int employeePerformanceBonus) {

        int employeePerformanceScore =
                processEmployeeData(
                        employeePerformanceScores,
                        employeePerformanceBonus,
                        true);

        if (!validateEmployeeScore(
                employeePerformanceScore)) {

            throw new IllegalArgumentException(
                    "Invalid employee score");
        }

        String employeePerformanceLevel =
                generatePerformanceLevel(
                        employeePerformanceScore);

        saveEmployeeHistory(
                "EMP001",
                employeePerformanceScore);

        LOGGER.info(
                employeePerformanceLevel);
    }
}