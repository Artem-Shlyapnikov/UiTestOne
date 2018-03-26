package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class ProfileActivity {

    public UiObject navigationProfileButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/navigation_profile");
    }

    public UiObject settingsButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/settings");
    }
}
