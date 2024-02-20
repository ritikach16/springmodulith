package com.example.modulith.order;
import com.example.modulith.order.internal.OrderInternal;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class OrderManagement {

    private final @NonNull ApplicationEventPublisher events;
    private final @NonNull OrderInternal dependency;

    @Transactional
    public void complete(Order order) {
        events.publishEvent(new OrderCompleted(order.getId()));
    }
}
