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

import ohos.data.preferences.Preferences;
import info.metadude.android.typedpreferences.StringPreference;

/**
 * PreferenceHelper.
 */
public class PreferenceHelper {

    private static final String PREF_KEY_USER_INPUT = "USER_INPUT";

    private final StringPreference mUserInputPreference;

    public PreferenceHelper(final Preferences mSharedPreferences) {
        mUserInputPreference = new StringPreference(
                mSharedPreferences, PREF_KEY_USER_INPUT);
    }

    public void storeUserInput(final String userInput) {
        mUserInputPreference.set(userInput);
    }


    public String restoreUserInput() {
        return mUserInputPreference.get();
    }

    public boolean storesUserInput() {
        return mUserInputPreference.isSet();
    }

}
