package com.saurabharora.darkthemelint.issues

import com.android.tools.lint.detector.api.*
import com.saurabharora.darkthemelint.detectors.MissingNightColorDetector

object MissingNightColorIssue {
    private const val ID = "MissingNightColor"
    private const val DESCRIPTION = "Night Color missing"
    const val EXPLANATION =
        "Night color value for this color resource seems to be missing. If your app supports dark theme, then you should add an equivalent color resource for it in the night values folder."
    private val CATEGORY = Category.CORRECTNESS
    private const val PRIORITY = 6
    private val SEVERITY = Severity.WARNING

    val ISSUE = Issue.create(
        ID,
        DESCRIPTION,
        EXPLANATION,
        CATEGORY,
        PRIORITY,
        SEVERITY,
        Implementation(
            MissingNightColorDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}
