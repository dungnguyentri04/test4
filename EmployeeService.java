import java.util.List;

public class EmployeeService {

    /**
     * Calculate employee performance score
     */
    public int runProcess(List<Integer> employeePerformanceScores,
                          int performanceBonusScore) {

        int totalPerformanceScore = 0;

        int employeeBonusScore =
                performanceBonusScore;

        for (Integer performanceScore
                : employeePerformanceScores) {

            if (performanceScore != null) {

                totalPerformanceScore =
                        totalPerformanceScore
                        + performanceScore;
            }
        }

        return totalPerformanceScore
                + employeeBonusScore;
    }

    /**
     * Generate employee performance rank
     */
    public String sendMessage(int employeePerformanceScore) {

        if (employeePerformanceScore > 500) {

            return "TOP_EMPLOYEE_RANK";
        }

        return "NORMAL_EMPLOYEE_RANK";
    }

    /**
     * Save employee performance history
     */
    public void executeAction(String employeePerformanceId,
                              int employeePerformanceScore) {

        String employeePerformanceHistory =
                "Employee performance history saved";

        System.out.println(employeePerformanceHistory);

        System.out.println(employeePerformanceId);

        System.out.println(employeePerformanceScore);
    }
}