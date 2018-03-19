package com.example.test.uitestone.uitestOne.basicClasses;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

public class LoginActivitySelectors {

    //Активити
    public static UiObject welcomePlaceHolderActivity(){
        return Selectors.selectorById("co.namba1:id/viewpager");
    }
    public static UiObject logInActivity(){
        return Selectors.selectorById("co.namba1:id/root");
    }


    //Объекты содержащие текстовое наполнение (Тайтлы, Описание
    public static UiObject titlePlaceHolder(){
        return Selectors.selectorById("co.namba1:id/title");
    }
    public static UiObject descriptionPlaceHolder(){
        return Selectors.selectorById("co.namba1:id/description");
    }


    //Объекты с которыми происходит взаимодействия (кнопки, формы)
    public static UiObject startButton(){
        return Selectors.selectorById("co.namba1:id/start");
    }

    public static UiObject countryButtonLoginActivity(){
        return Selectors.selectorById("co.namba1:id/countryButton");
    }

    public static UiObject countryListActivity(){
        return Selectors.selectorById("co.namba1:id/list");
    }

    public static UiObject nameCountry(int i) throws UiObjectNotFoundException {
        return Selectors.selectorByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/name"));
    }

    public static UiObject codeCountry(int i) throws UiObjectNotFoundException {
        return Selectors.selectorByClassName("android.widget.FrameLayout")
                .getChild(new UiSelector().index(i))
                .getChild(new UiSelector().resourceId("co.namba1:id/code"));
    }

    public static UiObject codeField() throws UiObjectNotFoundException{
        return Selectors.selectorById("co.namba1:id/codeField");
    }

    public static UiObject nameCountryInCountryList() throws UiObjectNotFoundException{
        return Selectors.selectorById("co.namba1:id/name");
    }
}