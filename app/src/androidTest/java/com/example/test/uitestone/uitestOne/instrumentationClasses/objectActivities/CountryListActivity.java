package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class CountryListActivity {

    public UiObject activity(){
        return Selector.ById("co.namba1:id/list");
    }

    public  UiObject nameCountry(int i) throws UiObjectNotFoundException {
        return Selector.ByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/name"));
    }

    public String correctNameCountry(int j){
        String [] name={"Afghanistan", "Uruguay"};
        return name[j];
    }

    public  UiObject codeCountry(int i) throws UiObjectNotFoundException {
        return Selector.ByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/code"));
    }
}
