package com.example.test.uitestone.uitestOne.basicClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.example.test.uitestone.uitestOne.basicClasses.testConfig.Selector;

public class LoginActivity {

    //Активити
    public static UiObject welcomePlaceHolderActivity(){
        return Selector.ById("co.namba1:id/viewpager");
    }
    public static UiObject logInActivity(){
        return Selector.ById("co.namba1:id/root");
    }


    //Объекты содержащие текстовое наполнение (Тайтлы, Описание
    public static UiObject titlePlaceHolder(){
        return Selector.ById("co.namba1:id/title");
    }
    public static UiObject descriptionPlaceHolder(){
        return Selector.ById("co.namba1:id/description");
    }


    //Объекты с которыми происходит взаимодействия (кнопки, формы)
    public static UiObject startButton(){
        return Selector.ById("co.namba1:id/start");
    }

    public static UiObject countryButtonLoginActivity(){
        return Selector.ById("co.namba1:id/countryButton");
    }

    public static UiObject countryListActivity(){
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

    public static UiObject codeField() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/codeField");
    }

    public static UiObject nameCountryInCountryList() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/name");
    }
}
