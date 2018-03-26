package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class SettingsActivity {

    public UiObject logoutButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/settings_exit");
    }
    public UiObject confirmationButtonOK() throws UiObjectNotFoundException{
        return Selector.ById("android:id/button1");
    }

}
