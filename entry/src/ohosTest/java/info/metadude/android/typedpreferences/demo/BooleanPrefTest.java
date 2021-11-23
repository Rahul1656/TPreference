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

public class BooleanPrefTest {

    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";

    private BooleanPreference mpreference1;
    private static final boolean MTESTVALUE1 = true;
    private static final boolean MDEFAULTVALUE1 = false;

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference1 = new BooleanPreference(preferences, PREFERENCES_KEY,MDEFAULTVALUE1 );
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceInitialized5(){
        Assert.assertNotNull(mpreference1);
    }
    

    @Test
    public void testPreferenceToBeSet5(){
        mpreference1.set(false);
        Assert.assertTrue(mpreference1.isSet());
    }


    @Test
    public void testPreferenceToEqualValue5(){
        mpreference1.set(MTESTVALUE1);
        Assert.assertTrue(mpreference1.get());
    }

    @Test
    public void testPreferenceNotToEqualValue5(){
        mpreference1.set(false);
        Assert.assertFalse(mpreference1.get());
    }

    @Test
    public void testPreferenceToBeUnset5(){
        mpreference1.set(MTESTVALUE1);
        mpreference1.delete();
        Assert.assertFalse(mpreference1.get());
    }
}