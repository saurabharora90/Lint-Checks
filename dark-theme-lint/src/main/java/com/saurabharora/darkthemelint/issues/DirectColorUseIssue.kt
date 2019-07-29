package com.saurabharora.darkthemelint.issues

import com.android.tools.lint.detector.api.*
import com.saurabharora.darkthemelint.detectors.DirectColorUseDetector

object DirectColorUseIssue {
    private const val ID = "DirectColorUse"
    private const val DESCRIPTION = "Color used directly"
    const val EXPLANATION =
        "Avoid direct use of colors in XML files. This will cause issues with different theme (dark-theme?) support"
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
            DirectColorUseDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}
