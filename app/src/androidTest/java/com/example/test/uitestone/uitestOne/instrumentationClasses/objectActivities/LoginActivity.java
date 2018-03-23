package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class LoginActivity {

    public UiObject licenseAgreement(){
        return Selector.ById("co.namba1:id/register_agreement");
    }
    public  UiObject countryButton(){
        return Selector.ById("co.namba1:id/countryButton");
    }


    public static UiObject codeField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/codeField");
    }

    public static UiObject nameCountryInCountryList() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/name");
    }
}
