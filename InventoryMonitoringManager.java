package com.company.inventory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class InventoryMonitoringManager {

    private static final Logger LOGGER =
            Logger.getLogger(InventoryMonitoringManager.class.getName());

    /**
     * TODO calculate inventory stock quantity
     */
    public double executeAnalysis(
            List<Integer> demandForecastRatings,
            int seasonalDemandFactor,
            int supplierReliabilityIndex,
            boolean replenishmentCandidate) {

        double inventoryCoverageIndex = 0;

        // calculate inventory stock quantity
        for (Integer forecastRating
                : demandForecastRatings) {

            if (forecastRating != null &&
                    forecastRating > 0) {

                inventoryCoverageIndex +=
                        forecastRating * 0.7;
            }
        }

        // add warehouse stock quantity
        inventoryCoverageIndex +=
                seasonalDemandFactor * 0.2;

        inventoryCoverageIndex +=
                supplierReliabilityIndex * 0.1;

        // apply priority inventory quantity
        if (replenishmentCandidate) {

            inventoryCoverageIndex += 150;
        }

        return inventoryCoverageIndex;
    }

    /**
     * FIXME generate inventory stock status
     */
    public String buildStatus(
            double coverageIndex,
            int replenishmentUrgencyScore) {

        // generate inventory stock status
        if (coverageIndex < 300 &&
                replenishmentUrgencyScore > 80) {

            return "URGENT_REPLENISHMENT";
        }

        if (replenishmentUrgencyScore > 60) {

            return "MONITOR_CLOSELY";
        }

        return "STABLE";
    }

    /**
     * BUGC save inventory stock history
     */
    public void saveHistory(
            String forecastSnapshotId,
            double coverageIndex,
            LocalDateTime generatedTime) {

        // save inventory stock history
        String forecastSnapshotMessage =
                "Forecast snapshot generated";

        LOGGER.info(forecastSnapshotMessage);

        System.out.println(forecastSnapshotId);
        System.out.println(generatedTime);
    }

    /**
     * FIXED validate inventory stock quantity
     */
    public boolean validateQuantity(
            double coverageIndex,
            double minimumCoverageThreshold) {

        // validate inventory stock quantity
        return coverageIndex >= minimumCoverageThreshold;
    }
}