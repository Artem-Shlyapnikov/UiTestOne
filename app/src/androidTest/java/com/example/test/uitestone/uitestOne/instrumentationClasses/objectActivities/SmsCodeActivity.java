package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;


import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class SmsCodeActivity {

    public UiObject description() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/description");
    }
    public UiObject codeSmsField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/codeSms");
    }
    public UiObject startButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/next");
    }
    public UiObject sendSmsCode() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/sendSmsCode");
    }

}
