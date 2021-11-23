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

public class ShortPrefTest {


    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";


    private ShortPreference mpreference6;
    private static final short MTESTVALUE6 = (short) 42;
    private static final short MDEFAULTVALUE6 = (short) 13;
    private static final short MDELTA6 = (short) 0;


    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference6= new ShortPreference(preferences, PREFERENCES_KEY, MDEFAULTVALUE6);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceToBeInitialized1()
    {
        Assert.assertNotNull(mpreference6);
    }

    @Test
    public void testPreferenceToBeSet1(){
        mpreference6.set(MTESTVALUE6);
        Assert.assertTrue(mpreference6.isSet());
    }


    @Test
    public void testPreferenceToEqualValue1(){
        mpreference6.set(MTESTVALUE6);
        final short value = mpreference6.get();
        Assert.assertEquals(MTESTVALUE6,value);
    }

    @Test
    public void testPreferenceNotToEqualValue1(){
        mpreference6.set((short) 55);
        Assert.assertNotEquals(mpreference6.get(), MTESTVALUE6, MDELTA6);
    }

    @Test
    public void testPreferenceToBeUnset1(){
        mpreference6.set(MTESTVALUE6);
        mpreference6.delete();
        Assert.assertNotEquals(mpreference6.get(), MTESTVALUE6, MDELTA6);
    }
}