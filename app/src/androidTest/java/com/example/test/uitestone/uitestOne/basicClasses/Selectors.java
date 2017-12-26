package com.example.test.uitestone.uitestOne.basicClasses;


import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

public class Selectors {
    protected static UiObject selectorById(String id) {
        UiObject selector = new UiObject(new UiSelector()
                .resourceId(id));
        return selector;
    }
    protected static UiObject selectorByClassName(String name){
        UiObject selector = new UiObject(new UiSelector().className(name));
        return selector;
    }
    protected static UiObject selectorByIndex(int i){
        UiObject selector = new UiObject(new UiSelector().index(i));
        return selector;
    }
}
