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

public class FloatPrefTest {

    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";


    private FloatPreference mpreference3;
    private static final float MTESTVALUE3 = 23.23f;
    private static final float MDEFAULTVALUE3 = 42.42f;
    private static final float MDELTA3 = 0f;

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference3 = new FloatPreference(preferences, PREFERENCES_KEY, MDEFAULTVALUE3);
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceToBeInitialized3(){
        Assert.assertNotNull(mpreference3);
    }



    @Test
    public void testPreferenceToBeSet3(){
        mpreference3.set(MTESTVALUE3);
        Assert.assertTrue(mpreference3.isSet());
    }


    @Test
    public void testPreferenceToEqualValue3(){
        mpreference3.set(MTESTVALUE3);
        final float value = mpreference3.get();
        Assert.assertEquals(value, MTESTVALUE3, MDELTA3);
    }

    @Test
    public void testPreferenceNotToEqualValue3(){
        mpreference3.set(77.77f);
        final float value = mpreference3.get();
        Assert.assertNotEquals(value, MTESTVALUE3, MDELTA3);
    }

    @Test
    public void testPreferenceToBeUnset3(){
        mpreference3.set(MTESTVALUE3);
        mpreference3.delete();
        Assert.assertNotEquals(MTESTVALUE3,mpreference3.get());
    }
}