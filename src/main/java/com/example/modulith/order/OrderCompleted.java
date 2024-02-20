package com.example.modulith.order;
import org.jmolecules.event.types.DomainEvent;
import com.example.modulith.order.Order.OrderIdentifier;
public record OrderCompleted(OrderIdentifier orderId) implements DomainEvent {
}
