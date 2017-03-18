package com.wpf.domain.common;

class ListManager<T> {

    private final T[] items;
    private ListObserver<T> observer;
    private int focusedItemIndex;

    ListManager(T[] items, ListObserver<T> observer) {
        this.items = items;
        this.observer = observer;
    }

    void setObserver(ListObserver<T> observer) {
        this.observer = observer;
    }

    void focusPreviousItem() {
        if (focusedItemIndex > 0) {
            focusedItemIndex--;
            if (observer != null) {
                observer.onItemFocused(focusedItem());
            }
        }
    }

    void focusNextItem() {
        if (focusedItemIndex < items.length - 1) {
            focusedItemIndex++;
            if (observer != null) {
                observer.onItemFocused(focusedItem());
            }
        }
    }

    void selectFocusedItem() {
        if (observer != null) {
            observer.onItemSelected(focusedItem());
        }
    }

    private T focusedItem() {
        return items[focusedItemIndex];
    }
}