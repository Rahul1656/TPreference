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
 * A wrapper class to store and restore a double value in preferences.
 */
public class DoublePreference {

    protected LongPreference mLongPreference;

    public static final double DEFAULT_VALUE_VALUE = 0d;

    /**
     * DoublePref.
     *
     * @param preferences pref.
     * @param key key.
     */
    public DoublePreference(Preferences preferences, String key) {
        this(preferences, key, DEFAULT_VALUE_VALUE);
    }

    /**
     * DoublePref.
     *
     * @param preferences pref.
     *
     * @param key key.
     *
     * @param defaultValue defaultval.
     */
    public DoublePreference(Preferences preferences, String key, double defaultValue) {
        mLongPreference = new LongPreference(preferences, key, Double.doubleToLongBits(defaultValue));
    }

    /**
     * Returns the stored {@code double} value if it exists
     * or the default value.
     */
    public double get() {
        return Double.longBitsToDouble(mLongPreference.get());
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mLongPreference.isSet();
    }

    /**
     * value.
     *
     * @param value val.
     */
    public void set(double value) {
        mLongPreference.set(Double.doubleToLongBits(value));
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mLongPreference.delete();
    }
}
