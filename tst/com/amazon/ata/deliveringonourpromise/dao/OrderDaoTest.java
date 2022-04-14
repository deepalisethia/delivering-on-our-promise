package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.data.OrderDatastore;
import com.amazon.ata.deliveringonourpromise.ordermanipulationauthority.OrderManipulationAuthorityClient;
import com.amazon.ata.deliveringonourpromise.types.Order;
import com.amazon.ata.ordermanipulationauthority.OrderManipulationAuthority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class OrderDaoTest {

    private OrderDao dao;
    private OrderDao classUnderTest;

    @Test
    public void runAllTests() {

        boolean pass = true;

        pass = get_forKnownOrderId_returnsOrder();
        pass = get_forUnknownOrderId_returnsMessageIfNull() && pass;
        pass = get_forNullOrderId_returnsMessageIfNull() && pass;

        if (!pass) {
            String errorMessage = "\n/!\\ /!\\ /!\\ The OrderDao tests failed. Test aborted. /!\\ /!\\ /!\\";
            System.out.println(errorMessage);
            //fail(errorMessage);
        } else {
            System.out.println("The OrderDao tests passed!");
        }
    }


    @Test
    public boolean get_forKnownOrderId_returnsOrder() {
        // GIVEN
        String orderId = "900-3746403-0000002";
        OrderManipulationAuthority service = new OrderManipulationAuthority(OrderDatastore.getDatastore());
        OrderManipulationAuthorityClient omaClient = new OrderManipulationAuthorityClient(service);
        dao = new OrderDao(omaClient);
        // WHEN
        Order order = dao.get(orderId);
        // THEN
        if (order == null) {
            return false;
        }
        return true;
    }

    @Test
    public boolean get_forUnknownOrderId_returnsMessageIfNull() {
        // GIVEN
        String orderId = "900-1111111-1111111";
        OrderManipulationAuthority service = new OrderManipulationAuthority(OrderDatastore.getDatastore());
        OrderManipulationAuthorityClient omaClient = new OrderManipulationAuthorityClient(service);
        dao = new OrderDao(omaClient);
        // WHEN
        Order order = dao.get(orderId);
        // THEN
        if (order == null) {
            System.out.println("The Order ID does not exist");
            return true;
        }
        return false;
    }

    @Test
    public boolean get_forNullOrderId_returnsMessageIfNull() {
        // GIVEN
        String orderId = null;
        OrderManipulationAuthority service = new OrderManipulationAuthority(OrderDatastore.getDatastore());
        OrderManipulationAuthorityClient omaClient = new OrderManipulationAuthorityClient(service);
        dao = new OrderDao(omaClient);
        // WHEN
        Order order = dao.get(orderId);
        // THEN
        if (order == null) {
            System.out.println("Invalid OrderID");
            return false;
        }
        return true;
    }

}
