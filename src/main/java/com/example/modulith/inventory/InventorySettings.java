package com.example.modulith.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example.inventory")
record InventorySettings(int stockThreshold) {

    public int stockThreshold() {
        return stockThreshold;
    }
}
