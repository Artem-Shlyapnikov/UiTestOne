package com.example.test.uitestone.uitestOne.instrumentationClasses.commands;


import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SplashScreenActivity;

public class Scripts {
    private SplashScreenActivity splashScreenObject = new SplashScreenActivity();
    private LoginActivity loginObject = new LoginActivity();

    public void openLoginActivity()throws UiObjectNotFoundException{
        splashScreenObject.startButton().clickAndWaitForNewWindow();
    }

    public void openCountryActivity() throws UiObjectNotFoundException{
        splashScreenObject.startButton().clickAndWaitForNewWindow();
        loginObject.countryButton().clickAndWaitForNewWindow();
    }

    public void openSmsCodeActivity()throws UiObjectNotFoundException{
        splashScreenObject.startButton().clickAndWaitForNewWindow();
        loginObject.phoneField().setText("703032941");
        loginObject.startButton().clickAndWaitForNewWindow();
    }
}
