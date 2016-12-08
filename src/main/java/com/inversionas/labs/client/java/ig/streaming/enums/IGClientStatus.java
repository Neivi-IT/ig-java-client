package com.inversionas.labs.client.java.ig.streaming.enums;

public enum IGClientStatus {
    DISCONNECTED(1),
    STREAMING(2),
    POLLING(3), STALLED(4);

    private int value;

    IGClientStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
