package com.example.test.uitestone.uitestOne.testClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.basicClasses.ActivitiesApp;
import com.example.test.uitestone.uitestOne.basicClasses.StartMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)



public class LoginUiTest extends ActivitiesApp {

    @Before
    public void startMainActivity() {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();
    }

    @Test
    public void actionBarRootEnabledCheck() throws UiObjectNotFoundException {
        codeCountryField().clickAndWaitForNewWindow();
        assertTrue("Action bar root not enabled", actionBarRoot().isEnabled());
    }

    @Test
    public void chooseCountryInActionBar() throws UiObjectNotFoundException{

        for (int i=0; i<2; i++) {
            String country[] = {"Russia", "Kyrgyzstan"};
            String codeCountry[] = {"Россия (+7)","Кыргызстан (+996)"};
            codeCountryField().clickAndWaitForNewWindow();
            selectDialogListView(1-i).clickAndWaitForNewWindow();
            assertTrue("In field country not selected country "+country[i],
                    codeCountryField().getText().equals(codeCountry[i]));
        }
    }
}
