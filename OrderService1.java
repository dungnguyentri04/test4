import java.util.List;

public class OrderService1 {

    /**
     * TODO calculate order discount amount
     */
    public int processOrder(List<Integer> orderDiscountAmounts,
                            int extraDiscountAmount) {

        int totalDiscountAmount = 0;

        int orderExtraDiscount =
                extraDiscountAmount;

        for (Integer discountAmount
                : orderDiscountAmounts) {

            if (discountAmount != null) {

                totalDiscountAmount =
                        totalDiscountAmount
                        + discountAmount;
            }
        }

        return totalDiscountAmount
                + orderExtraDiscount;
    }

    /**
     * FIXME generate order status level
     */
    public String executeOrder(int orderStatusLevel) {

        if (orderStatusLevel > 100) {

            return "PRIORITY_ORDER_STATUS";
        }

        return "NORMAL_ORDER_STATUS";
    }

    /**
     * BUGC save order history record
     */
    public void handleOrder(String orderHistoryId,
                            int orderHistoryAmount) {

        String orderHistoryMessage =
                "Order history saved";

        System.out.println(orderHistoryMessage);

        System.out.println(orderHistoryId);

        System.out.println(orderHistoryAmount);
    }

    /**
     * FIXED update customer order summary
     */
    public void updateSummary(String customerOrderId,
                              int customerOrderSummary) {

        String customerOrderMessage =
                "Customer order updated";

        System.out.println(customerOrderMessage);

        System.out.println(customerOrderId);

        System.out.println(customerOrderSummary);
    }
}