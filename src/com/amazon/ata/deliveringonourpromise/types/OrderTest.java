package com.amazon.ata.deliveringonourpromise.types;
import com.amazon.ata.ordermanipulationauthority.OrderCondition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//  * * orderId: the unique identifier for this order
// * * customerId: the identifier for the customer who placed the order
// * * marketplaceId: the identifier corresponding to the marketplace the order was placed in
// * * condition: the current state of the Order (e.g. PENDING, CLOSED). See {@link OrderCondition}.
// * * customerOrderItemList: the list of items and their quantities in this order
// * * shipOption: which shipping option the customer selected for this order
// * * orderDate: the timestamp of when the order was placed


public class OrderTest {
    @Test
    public void isOrderIdValid_returns () {
        //GIVEN
        Order testOrder;

        testOrder = Order.builder().withOrderId("invalid").build();

            assertNull(testOrder);
    }


}
