package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.types.Order;
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

}
