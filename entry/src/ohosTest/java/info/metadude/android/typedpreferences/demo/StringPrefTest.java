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

public class StringPrefTest {
    private static final String PREFERENCES_KEY = BuildConfig.APPLICATION_ID+".TEST_KEY_STRING";

    private StringPreference mpreference7;
    private static final String MTESTVALUE7 = "Hello World";
    private static final String MDEFAULTVALUE7 = "Empty";
    private static final String APP_RATER = "apprater";

    @Before
    public void setUp()  {
        Preferences preferences;
        DatabaseHelper databaseHelper;
        Context context;
        context = AbilityDelegatorRegistry.getAbilityDelegator().getAppContext();
        databaseHelper=new DatabaseHelper(context);
        preferences=databaseHelper.getPreferences(APP_RATER);
        mpreference7 = new StringPreference(preferences, PREFERENCES_KEY, MDEFAULTVALUE7);//String
    }

    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("info.metadude.android.typedpreferences.demo", actualBundleName);
    }

    @Test
    public void testPreferenceToBeInitialized()
    {
        Assert.assertNotNull(mpreference7);
    }

    @Test
    public void testPreferenceToBeSet() {
        mpreference7.set(MTESTVALUE7);
        Assert.assertTrue(mpreference7.isSet());
    }

    @Test
    public void testPreferenceToEqualDefaultValueBeforeBeingSet() {
        Assert.assertNotEquals(MTESTVALUE7,mpreference7.get());
    }

    @Test
    public void testPreferenceToEqualValue() {
        mpreference7.set(MTESTVALUE7);
        Assert.assertEquals(MTESTVALUE7,mpreference7.get());
    }

    @Test
    public void testPreferenceNotToEqualValue() {
        mpreference7.set("Something else");
        Assert.assertNotEquals(MTESTVALUE7,mpreference7.get());
    }

    @Test
    public void testPreferenceToBeUnset(){
        mpreference7.set(MTESTVALUE7);
        mpreference7.delete();
        Assert.assertNotEquals(MTESTVALUE7,mpreference7.get());
    }
}