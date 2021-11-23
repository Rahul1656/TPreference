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

class BasePreference {

    protected final Preferences mPreferences;

    protected final String mKey;

    public BasePreference(final Preferences preferences, final String key) {
        mPreferences = preferences;
        mKey = key;
    }

    /**
     * Returns {@code true} if some value is stored for
     * this preference, otherwise {@code false}.
     */
    public boolean isSet() {
        return mPreferences.hasKey(mKey);
    }

    /**
     * Removes this preference setting asynchronously.
     */
    public void delete() {
        mPreferences.delete(mKey).flush();
    }
}
