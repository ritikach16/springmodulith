package com.example.modulith.inventory;

import com.example.modulith.order.OrderCompleted;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
class InventoryManagement {

    private static final Logger LOG = LoggerFactory.getLogger(InventoryManagement.class);

    private final InventoryInternal dependency;


    @ApplicationModuleListener
    void on(OrderCompleted event) throws InterruptedException {

        var orderId = event.orderId();

        LOG.info("Received order completion for {}.", orderId);

        // Simulate busy work
        Thread.sleep(1000);

        LOG.info("Finished order completion for {}.", orderId);
    }
}
