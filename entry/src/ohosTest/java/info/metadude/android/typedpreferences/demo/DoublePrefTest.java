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

public class DoublePrefTest {

    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";
    private static final String APP_RATER = "apprater";


    private DoublePreference mpreference2;
    private static final double MTESTVALUE2 = 23.23d;
    private static final double MDEFAULTVALUE2 = 42.42f;
    private static final float MDELTA2 = 0f;

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference2 = new DoublePreference(preferences, PREFERENCES_KEY,MDEFAULTVALUE2 );
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceToBeInitialized4(){
        Assert.assertNotNull(mpreference2);
    }


    @Test
    public void testPreferenceToBeSet4(){
        mpreference2.set(MTESTVALUE2);
        Assert.assertTrue(mpreference2.isSet());
    }


    @Test
    public void testPreferenceToEqualValue4(){
        mpreference2.set(MTESTVALUE2);
        final double value = mpreference2.get();
        Assert.assertEquals(value, MTESTVALUE2, MDELTA2);
    }

    @Test
    public void testPreferenceNotToEqualValue4(){
        mpreference2.set(66.66d);
        Assert.assertNotEquals(MTESTVALUE2,mpreference2.get());
    }

    @Test
    public void testPreferenceToBeUnset4(){
        mpreference2.set(MTESTVALUE2);
        mpreference2.delete();
        Assert.assertNotEquals(MTESTVALUE2,mpreference2.get());
    }
}