package dev.saurabharora.darkthemelint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import dev.saurabharora.darkthemelint.issues.DirectColorDrawableUseIssue
import dev.saurabharora.darkthemelint.issues.DirectColorUseIssue
import dev.saurabharora.darkthemelint.issues.MissingNightColorIssue

@Suppress("UnstableApiUsage")
class DarkThemeLintRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            DirectColorUseIssue.ISSUE, DirectColorDrawableUseIssue.ISSUE,
            MissingNightColorIssue.ISSUE
        )

    override val api: Int
        get() = CURRENT_API

    override val vendor: Vendor
        get() = Vendor(
            vendorName = "Saurabh Arora",
            identifier = "com.saurabharora.darkthemelint",
            feedbackUrl = "https://github.com/saurabharora90/Lint-Checks/issues"
        )
}