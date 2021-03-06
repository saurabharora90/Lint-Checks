package com.saurabharora.darkthemelint.detectors

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.saurabharora.darkthemelint.issues.DirectColorUseIssue
import org.w3c.dom.Attr

private const val BACKGROUND = "background"
private const val FOREGROUND = "foreground"
private const val SRC = "src"
private const val TEXT_COLOR = "textColor"
private const val TINT = "tint"

class DirectColorUseDetector : ResourceXmlDetector() {

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.LAYOUT
    }

    override fun getApplicableAttributes(): Collection<String>? {
        return listOf(BACKGROUND, FOREGROUND, SRC, TEXT_COLOR, TINT)
    }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        if(attribute.value.startsWith("#")) {
            context.report(
                DirectColorUseIssue.ISSUE,
                context.getLocation(attribute),
                DirectColorUseIssue.EXPLANATION)
        }
    }
}
