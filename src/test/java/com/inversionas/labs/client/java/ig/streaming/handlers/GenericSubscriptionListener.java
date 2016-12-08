package com.inversionas.labs.client.java.ig.streaming.handlers;

import com.lightstreamer.client.ItemUpdate;
import com.lightstreamer.client.Subscription;
import com.lightstreamer.client.SubscriptionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by X11443AL on 24/11/2016.
 */
@Slf4j
public class GenericSubscriptionListener implements SubscriptionListener {
    @Override
    public void onClearSnapshot(String s, int i) {

    }

    @Override
    public void onCommandSecondLevelItemLostUpdates(int i, String s) {

    }

    @Override
    public void onCommandSecondLevelSubscriptionError(int i, String s, String s1) {

    }

    @Override
    public void onEndOfSnapshot(String s, int i) {

    }

    @Override
    public void onItemLostUpdates(String s, int i, int i1) {

    }

    @Override
    public void onItemUpdate(ItemUpdate itemUpdate) {

//        boolean isSnap = itemUpdate.isSnapshot();
        int itemIndex = itemUpdate.getItemPos() - 1; // item position is 1 based, so -1 to match the data array
        log.warn("Item: {}, Posición del Item: {}", itemUpdate.getItemName(), itemIndex);

//        List<String> items = Arrays.asList(((ListDescriptor) itemUpdate.getFields()).getOriginal());

        itemUpdate.getChangedFields().entrySet().stream()
                .forEach(e -> log.warn("    {} {}", e.getKey(), e.getValue()));
    }

    @Override
    public void onListenEnd(Subscription subscription) {

    }

    @Override
    public void onListenStart(Subscription subscription) {

    }

    @Override
    public void onSubscription() {

    }

    @Override
    public void onSubscriptionError(int i, String s) {
        log.error("Subscription error - i:{} s:{}");
    }

    @Override
    public void onUnsubscription() {

    }
}
