package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.data.OrderDatastore;
import org.junit.jupiter.api.BeforeEach;

public class OrderFulfillmentServiceTest {
    private OrderFulfillmentServiceClient ofsClient;
    private String orderItemId;

    @BeforeEach
    private void setup() {
        // not mocking: use an actual client calling actual service
        ofsClient = App.getPromise();
        String orderId = "111-7497023-2960776";
        orderItemId = OrderDatastore.getDatastore()
                .getOrderData(orderId)
                .getCustomerOrderItemList()
                .get(0)
                .getCustomerOrderItemId();
    }
}
