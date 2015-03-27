package com.coshx.springbok;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class UserTest {

    @Test
    public void UserNameTest() {
            User u = new User();

            u.setName("foo");

            Assert.assertEquals("foo", u.getName());
        }

    // Uncomment test below for testing failed builds
    //    @Test
    //    public void failingTest() {
    //        Assert.assertFalse(true);
    //    }
}
