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
 * A wrapper class for a float preference.
 */
public class FloatPreference extends BasePreference {

    protected final float mDefaultValue;

    public static final float DEFAULT_VALUE_VALUE = 0f;

    /**
     * FloatPreference.
     *
     * @param preferences pref.
     * @param key key.
     */
    public FloatPreference(final Preferences preferences, final String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * Float.
     *
     * @param preferences pref.
     *
     * @param key key.
     *
     * @param defaultValue defaultval.
     */
    public FloatPreference(final Preferences preferences, final String key, float defaultValue) {
        super(preferences, key);
        mDefaultValue = defaultValue;
    }

    /**
     * Returns the stored {@code float} value if it exists
     * or the default value.
     */
    public float get() {
        return mPreferences.getFloat(mKey, mDefaultValue);
    }

    /**
     * value.
     *
     * @param value val.
     */
    public void set(float value) {
        mPreferences.putFloat(mKey, value).flush();
    }
}
