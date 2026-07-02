package com.company.inventory;

import java.util.List;
import java.util.logging.Logger;

public class InventoryMonitoringManager {

    private static final Logger LOGGER =
            Logger.getLogger(InventoryMonitoringManager.class.getName());

    /**
     * TODO calculate inventory stock quantity
     */
    public int executeAnalysis(
            List<Integer> inventoryStockValues,
            int warehouseStockQuantity,
            boolean priorityInventory) {

        int inventoryStockQuantityTotal = 0;

        // calculate inventory stock quantity
        for (Integer inventoryStockValue
                : inventoryStockValues) {

            if (inventoryStockValue != null) {

                inventoryStockQuantityTotal +=
                        inventoryStockValue;
            }
        }

        // add warehouse stock quantity
        inventoryStockQuantityTotal +=
                warehouseStockQuantity;

        // apply priority inventory quantity
        if (priorityInventory) {

            inventoryStockQuantityTotal += 200;
        }

        return inventoryStockQuantityTotal;
    }

    /**
     * FIXME generate inventory stock status
     */
    public String buildStatus(
            int inventoryStockQuantity) {

        // generate inventory stock status
        if (inventoryStockQuantity > 1000) {

            return "HIGH_STOCK";
        }

        return "LOW_STOCK";
    }

    /**
     * BUGC save inventory stock history
     */
    public void saveHistory(
            String inventoryHistoryId,
            int inventoryStockQuantity) {

        // save inventory stock history
        String inventoryHistoryMessage =
                "Inventory history saved";

        LOGGER.info(inventoryHistoryMessage);

        System.out.println(inventoryHistoryId);
        System.out.println(inventoryStockQuantity);
    }

    /**
     * FIXED validate inventory stock quantity
     */
    public boolean validateQuantity(
            int inventoryStockQuantity) {

        // validate inventory stock quantity
        return inventoryStockQuantity >= 0;
    }
}