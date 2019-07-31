package com.saurabharora.darkthemelint.detectors

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.Context
import com.android.tools.lint.detector.api.Location
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.saurabharora.darkthemelint.issues.MissingNightColorIssue
import org.w3c.dom.Element

private const val COLOR = "color"


class MissingNightColorDetector : ResourceXmlDetector() {

    private val nightModeColors = mutableListOf<String>()
    private val regularColors = mutableMapOf<String, Location>()

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.VALUES
    }

    override fun getApplicableElements(): Collection<String>? {
        return listOf(COLOR)
    }

    override fun afterCheckEachProject(context: Context) {
        regularColors.forEach { (color, location) ->
            if (!nightModeColors.contains(color))
                context.report(
                    MissingNightColorIssue.ISSUE,
                    location,
                    MissingNightColorIssue.EXPLANATION
                )
        }
    }

    override fun visitElement(context: XmlContext, element: Element) {
        if (context.getFolderConfiguration()!!.isDefault)
            regularColors[element.getAttribute("name")] = context.getLocation(element)
        else if (context.getFolderConfiguration()!!.nightModeQualifier.isValid)
            nightModeColors.add(element.getAttribute("name"))
    }
}
