package com.example.test.uitestone.uitestOne.instrumentationClasses.commands;


import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.RegistrationActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SplashScreenActivity;

import static com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.StartMainActivity.mDevice;

public class Scripts {
    private SplashScreenActivity splashScreenObject = new SplashScreenActivity();
    private LoginActivity loginObject = new LoginActivity();
    private RegistrationActivity registrationObject = new RegistrationActivity();

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

    public void openRegistrationActivity()throws UiObjectNotFoundException{
        splashScreenObject.startButton().clickAndWaitForNewWindow();
        loginObject.phoneField().setText("552903503");
        loginObject.startButton().clickAndWaitForNewWindow();
        mDevice.pressBack();
    }
    public void login() throws UiObjectNotFoundException{
        splashScreenObject.startButton().clickAndWaitForNewWindow();
        loginObject.phoneField().setText("552903503");
        loginObject.startButton().clickAndWaitForNewWindow();
        registrationObject.doneButton().clickAndWaitForNewWindow();
    }
}
