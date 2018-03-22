package com.example.test.uitestone.uitestOne.basicClasses.testConfig;


import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

public class Selector {
    public static UiObject ById(String id) {
        UiObject selector = new UiObject(new UiSelector()
                .resourceId(id));
        return selector;
    }
    public static UiObject ByClassName(String name){
        UiObject selector = new UiObject(new UiSelector().className(name));
        return selector;
    }
    public static UiObject ByIndex(int i){
        UiObject selector = new UiObject(new UiSelector().index(i));
        return selector;
    }
}
