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

package info.metadude.android.typedpreferences.demo.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.data.DatabaseHelper;
import ohos.data.preferences.Preferences;
import info.metadude.android.typedpreferences.demo.PreferenceHelper;
import info.metadude.android.typedpreferences.demo.ResourceTable;

/**
 * MainAbilitySlice.
 */
public class MainAbilitySlice extends AbilitySlice {
    private PreferenceHelper mPreferenceHelper;
    Text text;
    TextField textField;
    Button button;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        textField = (TextField) findComponentById(ResourceTable.Id_editText);
        text = (Text) findComponentById(ResourceTable.Id_textView);
        button = (Button) findComponentById(ResourceTable.Id_button);
        mPreferenceHelper = getPreferenceHelper();
        button.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                text.setText(textField.getText());
            }
        });

    }

    @Override
    public void onActive() {
        super.onActive();
        restorePreferences();
    }

    @Override
    protected void onInactive() {
        storePreferences();
        super.onInactive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    /** PreferenceHelper.
     *
     * @return mpreferenceHelper.
     *
     */
    public PreferenceHelper getPreferenceHelper() {
        if (mPreferenceHelper == null) {
            Preferences sharedPreferences =
                    new DatabaseHelper(this).getPreferences("pref_file");
            mPreferenceHelper = new PreferenceHelper(sharedPreferences);
        }
        return mPreferenceHelper;
    }

    private void storePreferences() {
        mPreferenceHelper.storeUserInput(textField.getText().toString());
    }

    private void restorePreferences() {
        if (mPreferenceHelper.storesUserInput()) {
            text.setText(mPreferenceHelper.restoreUserInput());
        }
    }

}
