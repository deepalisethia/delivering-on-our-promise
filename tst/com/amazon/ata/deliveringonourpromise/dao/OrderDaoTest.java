package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.data.OrderDatastore;
import com.amazon.ata.deliveringonourpromise.ordermanipulationauthority.OrderManipulationAuthorityClient;
import com.amazon.ata.deliveringonourpromise.types.Order;
import com.amazon.ata.ordermanipulationauthority.OrderManipulationAuthority;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDaoTest {

    private OrderDao dao;
    @BeforeEach
    private void createDao() {
        dao = App.getOrderDao();
    }

    @Test
    public void get_forKnownOrderId_returnsOrder() {
        // GIVEN
        String orderId = "900-3746403-0000002";
        // WHEN
        Order order = dao.get(orderId);
        // THEN
        assertNotNull(order);
    }

    @Test
    public void get_forUnknownOrderId_returnsOrder() {
        // GIVEN
        String orderId = "invalid";
        // WHEN
        Order order = dao.get(orderId);
        // THEN
        assertNull(order);
    }

//    @Test
//    public void get_forNullOrderId_returnsOrder() {
//        // GIVEN
//        String orderId = null;
//        OrderManipulationAuthority service = new OrderManipulationAuthority(OrderDatastore.getDatastore());
//        OrderManipulationAuthorityClient omaClient = new OrderManipulationAuthorityClient(service);
//        dao = new OrderDao(omaClient);
//        // WHEN
//        Order order = dao.get(orderId);
//        // THEN
//        if (order == null) {
//            Assertions.assertNull(order, "Null Order ID");
//        }
//
//    }
}
