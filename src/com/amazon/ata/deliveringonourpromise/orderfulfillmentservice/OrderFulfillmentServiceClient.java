package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.deliveringonourpromise.types.PromiseClient;
import com.amazon.ata.orderfulfillmentservice.OrderFulfillmentService;
import com.amazon.ata.orderfulfillmentservice.OrderPromise;

public class OrderFulfillmentServiceClient implements PromiseClient {
    private OrderFulfillmentService ofService;
    public OrderFulfillmentServiceClient(OrderFulfillmentService ofService) {
        this.ofService = ofService;
    }

    @Override
    public Promise getPromise(String customerOrderItemId) {
        OrderPromise getOrderPromise = ofService.getOrderPromise(customerOrderItemId);

        if (null == getOrderPromise) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(getOrderPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(getOrderPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(getOrderPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(getOrderPromise.getPromiseEffectiveDate())
                .withIsActive(getOrderPromise.isActive())
                .withPromiseProvidedBy(getOrderPromise.getPromiseProvidedBy())
                .withAsin(getOrderPromise.getAsin())
                .build();

    }


}
