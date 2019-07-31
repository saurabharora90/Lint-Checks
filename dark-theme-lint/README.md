[ ![Download](https://api.bintray.com/packages/saurabharora90/maven/dark-theme-lint/images/download.svg?version=1.0.0) ](https://bintray.com/saurabharora90/maven/dark-theme-lint/1.0.0/link)

Dark Theme Lint
=================

A collection of Lint Checks to aid with the development and maintenance of dark theme in your android apps.

This will warn when colors are hardcoded (eg: `android:textColor="#FFFFFF"`) in layout or drawable files. It will also warn about color resources that don’t have corresponding dark theme (`night` qualifier) variants.

Medium post: https://proandroiddev.com/making-android-lint-theme-aware-6285737b13bc

Usage
-------

- In your `build.gradle` file:

```
dependencies {
   lintChecks 'com.saurabharora.lint.checks:dark-theme-lint:1.0.0'
}
```

- Run lint on your app module as per usual. Eg:
  ```
  ./gradlew app:lintDebug
  ```
- If issues are found, they should appear in your lint reports:
  
  ![Lint Report](https://raw.githubusercontent.com/saurabharora90/Lint-Checks/master/dark-theme-lint/assets/dark-theme-lint-check-result.png)
