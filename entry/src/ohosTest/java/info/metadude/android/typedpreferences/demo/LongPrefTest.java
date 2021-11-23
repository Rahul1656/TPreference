/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.metadude.android.typedpreferences.demo;

import info.metadude.android.typedpreferences.*;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.agp.render.render3d.BuildConfig;
import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.preferences.Preferences;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongPrefTest {

    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";

    private LongPreference mpreference5;
    private static final long MTESTVALUE5= 23L;
    private static final long MDEFAULTVALUE5 = 42L;

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference5= new LongPreference(preferences, PREFERENCES_KEY, MDEFAULTVALUE5);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }
    @Test
    public void testPreferenceToBeInitialized6(){
        Assert.assertNotNull(mpreference5);
    }

    @Test
    public void testPreferenceToBeSet6(){
        mpreference5.set(MTESTVALUE5);
        Assert.assertTrue(mpreference5.isSet());
    }

    @Test
    public void testPreferenceToEqualValue6(){
        mpreference5.set(MTESTVALUE5);
        final long value = mpreference5.get();
        Assert.assertEquals(MTESTVALUE5,value);
    }
    @Test
    public void testPreferenceNotToEqualValue6(){
        mpreference5.set(77L);
        final long value = mpreference5.get();
        Assert.assertNotEquals(MTESTVALUE5,value);
    }
    @Test
    public void testPreferenceToBeUnset6(){
        mpreference5.set(MTESTVALUE5);
        mpreference5.delete();
        final long value = mpreference5.get();
        Assert.assertNotEquals(MTESTVALUE5,value);
    }
}