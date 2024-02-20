package com.example.modulith.order;

import lombok.Getter;

import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;
import com.example.modulith.order.Order.OrderIdentifier;

public class Order implements AggregateRoot<Order, OrderIdentifier> {

    private @Getter OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());

    public static record OrderIdentifier(UUID id) implements Identifier {}
}
