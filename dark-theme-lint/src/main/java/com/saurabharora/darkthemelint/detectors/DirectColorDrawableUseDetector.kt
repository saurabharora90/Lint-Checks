package com.saurabharora.darkthemelint.detectors

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.saurabharora.darkthemelint.issues.DirectColorDrawableUseIssue
import org.w3c.dom.Attr

//Vector Drawables.
private const val FILL_COLOR = "fillColor"
private const val STROKE_COLOR = "strokeColor"
private const val COLOR = "color"
private const val TINT = "tint"

class DirectColorDrawableUseDetector : ResourceXmlDetector() {

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.DRAWABLE || folderType == ResourceFolderType.COLOR
    }

    override fun getApplicableAttributes(): Collection<String>? {
        return listOf(TINT, FILL_COLOR, STROKE_COLOR, COLOR)
    }

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        if(attribute.value.startsWith("#")) {
            context.report(
                DirectColorDrawableUseIssue.ISSUE,
                context.getLocation(attribute),
                DirectColorDrawableUseIssue.EXPLANATION)
        }
    }
}
