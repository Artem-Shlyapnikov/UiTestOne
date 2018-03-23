package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class CountryListActivity {

    public UiObject countryList(){
        return Selector.ById("co.namba1:id/list");
    }

    public static UiObject nameCountry(int i) throws UiObjectNotFoundException {
        return Selector.ByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/name"));
    }

    public static UiObject codeCountry(int i) throws UiObjectNotFoundException {
        return Selector.ByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/code"));
    }
}
