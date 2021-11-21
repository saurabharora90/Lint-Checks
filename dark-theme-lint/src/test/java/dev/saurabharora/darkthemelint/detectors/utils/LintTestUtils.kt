@file:Suppress("UnstableApiUsage")

package dev.saurabharora.darkthemelint.detectors.utils

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintResult
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.android.tools.lint.detector.api.Issue

fun layoutXMLFile(contents: String): TestFile {
    return TestFiles.xml("res/layout/activity.xml", contents)
}

fun drawableXMLFile(contents: String): TestFile {
    return TestFiles.xml("res/drawable/test_drawable.xml", contents)
}

fun valuesXMLFile(contents: String): TestFile {
    return TestFiles.xml("res/values/test_values.xml", contents)
}

fun TestFile.executeLintTest(
    issue: Issue
): TestLintResult {
    return executeLintTest(issue, listOf(this))
}

fun executeLintTest(
    issue: Issue,
    inputFiles: List<TestFile>
): TestLintResult {
    return lint()
        .files(*inputFiles.toTypedArray())
        .issues(issue)
        .run()
}