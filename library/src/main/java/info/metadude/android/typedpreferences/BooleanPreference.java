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

package info.metadude.android.typedpreferences;

import ohos.data.preferences.Preferences;

/**
 * A wrapper class for a boolean preference.
 */
public class BooleanPreference extends BasePreference {

    protected final boolean mDefaultValue;

    public static final boolean DEFAULT_VALUE_VALUE = false;

    /**
     * BooleanPreference.
     *
     * @param preferences pref.
     * @param key key.
     */
    public BooleanPreference(final Preferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Boolean.
     *
     * @param preferences pref.
     *
     * @param key key.
     *
     * @param defaultValue defaultval.
     */
    public BooleanPreference(final Preferences preferences, final String key, boolean defaultValue) {
        super(preferences, key);
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code boolean} value if it exists
     * or the default value.
     */
    public boolean get() {
        return mPreferences.getBoolean(mKey, mDefaultValue);
    }

    /**
     * value.
     *
     * @param value val.
     */
    public void set(boolean value) {
        mPreferences.putBoolean(mKey, value).flush();
    }
}
