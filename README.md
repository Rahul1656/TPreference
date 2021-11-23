# Typed Preferences

This library for HMOS provides classes which allow to store
and retrieve settings from the preferences. There is an individual
class for each native type:

* [`BooleanPreference`][boolean-pref] for a `boolean` value
* [`DoublePreference`][double-pref] for a `double` value
* [`FloatPreference`][float-pref] for a `float` value
* [`IntPreference`][int-pref] for an `int` value
* [`LongPreference`][long-pref] for a `long` value
* [`ShortPreference`][short-pref] for a `short` value
* [`StringPreference`][string-pref] for a `String` value

Each class comes with two constructors - one of them allows to ommit
the default value.

All classes declare the same methods: `get()`, `isSet()`, `set()` and `delete()`.
Here are the method signatures as definied in the `StringPreference` class.

```java
public class StringPreference {
    public String get() {  }
    public boolean isSet() {  }
    public void set(String value) {  }
    public void delete() {  }
}
```

## Source

Inspired by https://github.com/johnjohndoe/TypedPreferences - version 1.0


## Dependency
1. For using apprater module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```groovy
    dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar', '*.har'])
    implementation project(path: ':library')
    testImplementation 'junit:junit:4.13'
    ohosTestImplementation 'com.huawei.ohos.testkit:runner:1.0.0.100'
}
```
2. For using apprater in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```groovy
	dependencies {
		implementation fileTree(dir: 'libs', include: ['*.har'])
		testImplementation 'junit:junit:4.13'
	}
```
## Usage

#### Include following code in your layout:
```xml
<?xml version="1.0" encoding="utf-8"?>
<DirectionalLayout
    xmlns:ohos="http://schemas.huawei.com/res/ohos"
    ohos:height="match_parent"
    ohos:width="match_parent"
    ohos:alignment="center"
    ohos:orientation="vertical">
</DirectionalLayout>
```

#### In code
```
super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

```

## License

    Copyright 2014-2021 Tobias Preuss

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.