package com.example.test.uitestone.uitestOne.UiTestsClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import com.example.test.uitestone.uitestOne.instrumentationClasses.commands.Scripts;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.StartMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)


public class RegistrationUiTest {

    private Scripts script = new Scripts();

    @Before
    public void startMainActivity() throws InterruptedException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();
    }


}
