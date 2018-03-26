package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;


import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class RegistrationActivity {

    public UiObject doneButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/menu_done");
    }

    public UiObject avatarButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/avatar");
    }
    public UiObject nameField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/name");
    }


}
