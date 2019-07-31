Lint Checks
=================

This repository holds Lint Checks that aren't a part of the standard Android toolkit but can still be helpful to developers.

Android lint system provides a lot of helpful checks but it’s not exhaustive. It’s difficult to build all checks as they can vary as per user needs. Hence, Lint provides an API, to allow users to build their own checks.

The custom lint checks are grouped under modules, to allow developers to only include the ones they need and not be weighed down by all of them.

If you want to contribute, feel free to send a PR. 

List of Modules:
-------

- [Dark Theme Lint](https://github.com/saurabharora90/Lint-Checks/tree/master/dark-theme-lint): Collection of Lint Checks to aid with development and maintenance of dark theme. More details [here](https://github.com/saurabharora90/Lint-Checks/tree/master/dark-theme-lint)

Disable Lint checks:
-------

If you only need a fraction of lint checks included inside a module and not all of them, you can disable them as follows:

- In your `build.gradle` file:

```
android {
   lintOptions {
        // Turns off checks for the issue IDs you specify.
        disable 'ContentDescription', 'ObsoleteLintCustomCheck'
    }
}
```
- If you are using a [lint config file](https://developer.android.com/studio/write/lint#pref):

```
<?xml version="1.0" encoding="UTF-8"?>
<lint>
    <issue id="ContentDescription" severity="ignore"/>
    <issue id="ObsoleteLintCustomCheck" severity="ignore"/>
</lint>
```

License
-------

    Copyright 2019 Saurabh Arora

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
