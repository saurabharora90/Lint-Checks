package com.saurabharora.darkthemelint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.saurabharora.darkthemelint.issues.DirectColorUseIssue

class DarkThemeLintRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(DirectColorUseIssue.ISSUE)

    override val api: Int
        get() = CURRENT_API
}