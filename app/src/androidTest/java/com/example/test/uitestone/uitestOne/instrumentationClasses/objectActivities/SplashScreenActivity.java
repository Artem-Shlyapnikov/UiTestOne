package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;


public class SplashScreenActivity {
    public UiObject activity(){
        return Selector.ById("co.namba1:id/viewpager");
    }

    public UiObject title() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/title");
    }

    public String correctTitle(int j) throws UiObjectNotFoundException {
         String [] title = {"Делись местоположением", "Находи друзей", "Наслаждайся общением"};
        return title[j];
    }
    public UiObject description(){
        return Selector.ById("co.namba1:id/description");
    }
    public String correctDescription(int i){
        String [] description = {"Подключи геолокацию для использования функции “Поблизости”.",
                "Функция “Поблизости” позволит найти собеседников поблизости.",
                "Отправляй сообщение собеседнику поблизости."};
        return description[i];
    }
    public UiObject startButton(){
        return Selector.ById("co.namba1:id/start");
    }
}
