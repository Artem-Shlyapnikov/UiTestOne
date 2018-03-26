package com.example.test.uitestone.uitestOne.instrumentationClasses.commands;


import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.ProfileActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.RegistrationActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SettingsActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SplashScreenActivity;

import static com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.StartMainActivity.mDevice;

public class Scripts {
    private SplashScreenActivity splashScreenActivity = new SplashScreenActivity();
    private LoginActivity loginActivity = new LoginActivity();
    private RegistrationActivity registrationActivity = new RegistrationActivity();
    private SettingsActivity settingsActivity = new SettingsActivity();
    private ProfileActivity profileActivity = new ProfileActivity();

    public void openLoginActivity()throws UiObjectNotFoundException{
        splashScreenActivity.startButton().clickAndWaitForNewWindow();
    }

    public void openCountryActivity() throws UiObjectNotFoundException{
        splashScreenActivity.startButton().clickAndWaitForNewWindow();
        loginActivity.countryButton().clickAndWaitForNewWindow();
    }

    public void openSmsCodeActivity()throws UiObjectNotFoundException{
        splashScreenActivity.startButton().clickAndWaitForNewWindow();
        loginActivity.phoneField().setText("703032941");
        loginActivity.startButton().clickAndWaitForNewWindow();
    }

    public void openRegistrationActivity()throws UiObjectNotFoundException{
        splashScreenActivity.startButton().clickAndWaitForNewWindow();
        loginActivity.phoneField().setText("552903503");
        loginActivity.startButton().clickAndWaitForNewWindow();
        mDevice.pressBack();
    }
    public void login() throws UiObjectNotFoundException{
        splashScreenActivity.startButton().clickAndWaitForNewWindow();
        loginActivity.phoneField().setText("552903503");
        loginActivity.startButton().clickAndWaitForNewWindow();
        registrationActivity.doneButton().clickAndWaitForNewWindow();
    }
    public void logout() throws UiObjectNotFoundException{
        profileActivity.navigationProfileButton().clickAndWaitForNewWindow();
        profileActivity.settingsButton().clickAndWaitForNewWindow();
        settingsActivity.logoutButton().clickAndWaitForNewWindow();
        settingsActivity.confirmationButtonOK().clickAndWaitForNewWindow();
    }
}
