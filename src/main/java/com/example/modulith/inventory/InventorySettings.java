package com.example.modulith.inventory;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example.inventory")
record InventorySettings(int stockThreshold) {

    /**
     * Some Javadoc.
     *
     * @return
     */
    public int stockThreshold() {
        return stockThreshold;
    }
}
