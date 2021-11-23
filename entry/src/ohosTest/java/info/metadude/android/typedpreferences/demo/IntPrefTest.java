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

public class IntPrefTest {

    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";


    private IntPreference mpreference4;
    private static final int MTESTVALUE4 = 42;
    private static final int MDEFAULTVALUE4 = 23;
    private static final int MDELTA4= 0;

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference4 = new IntPreference(preferences, PREFERENCES_KEY, MDEFAULTVALUE4);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceToBeInitialized2(){
        Assert.assertNotNull(mpreference4);
    }



    @Test
    public void testPreferenceToBeSet2(){
        mpreference4.set(MTESTVALUE4);
        Assert.assertTrue(mpreference4.isSet());
    }


    @Test
    public void testPreferenceToEqualValue2(){
        mpreference4.set(MTESTVALUE4);
        final int value = mpreference4.get();
        Assert.assertEquals(MTESTVALUE4,value);
    }

    @Test
    public void testPreferenceNotToEqualValue2(){
        mpreference4.set(55);
        Assert.assertNotEquals(mpreference4.get(), MTESTVALUE4, MDELTA4);
    }

    @Test
    public void testPreferenceToBeUnset2(){
        mpreference4.set(MTESTVALUE4);
        mpreference4.delete();
        Assert.assertNotEquals(mpreference4.get(), MTESTVALUE4, MDELTA4);
    }
}