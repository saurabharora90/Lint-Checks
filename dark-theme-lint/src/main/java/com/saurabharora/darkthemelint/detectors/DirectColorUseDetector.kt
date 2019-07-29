package com.saurabharora.darkthemelint.detectors

import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.saurabharora.darkthemelint.issues.DirectColorUseIssue
import org.w3c.dom.Attr

private const val BACKGROUND = "background"
private const val FOREGROUND = "foreground"
private const val SRC = "src"
private const val TEXT_COLOR = "textColor"
private const val TINT = "tint"

//Vector Drawables.
private const val FILL_COLOR = "fillColor"
private const val STROKE_COLOR = "strokeColor"
private const val COLOR = "color"


class DirectColorUseDetector : ResourceXmlDetector() {

    override fun getApplicableAttributes(): Collection<String>? {
        return listOf(BACKGROUND, FOREGROUND, SRC, TEXT_COLOR, TINT, FILL_COLOR, STROKE_COLOR, COLOR)
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
