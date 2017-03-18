package com.wpf.domain.common;

public interface ListObserver<T> {

    void onItemFocused(T item);

    void onItemSelected(T item);
}