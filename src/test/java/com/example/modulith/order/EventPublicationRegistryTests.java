package com.example.modulith.order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.*;

@ApplicationModuleTest
@Import(EventPublicationRegistryTests.FailingAsyncTransactionalEventListener.class)
@DirtiesContext
@RequiredArgsConstructor
class EventPublicationRegistryTests {

    private final OrderManagement orders;
    private final EventPublicationRegistry registry;
    private final FailingAsyncTransactionalEventListener listener;

    @Test
    void leavesPublicationIncompleteForFailingListener(Scenario scenario) throws Exception {

        var order = new Order();

        scenario.stimulate(() -> orders.complete(order))
                .andWaitForStateChange(listener::getEx)
                .andVerify(__ -> {
                    assertThat(registry.findIncompletePublications()).hasSize(1);
                });
    }

    static class FailingAsyncTransactionalEventListener {

        @Getter Exception ex;

        @ApplicationModuleListener
        void foo(OrderCompleted event) {

            var exception = new IllegalStateException("¯\\_(ツ)_/¯");

            try {

                throw exception;

            } finally {
                this.ex = exception;
            }
        }
    }
}
