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

    public String testDataCountryName(int i){
        String nameCountry[]={"Kyrgyzstan", "Kenya","Anguilla"};
        return nameCountry[i];
    }

    public  UiObject codeField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/codeField");
    }

    public String testDataCountryCode(int i){
        String code[]={"+996","+254","+1264"};
        return code[i];
    }

    public UiObject phoneField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/phoneField");
    }

    public UiObject startButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/start");
    }
}
