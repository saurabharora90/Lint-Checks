package dev.saurabharora.darkthemelint.detectors

import com.android.tools.lint.checks.infrastructure.TestFiles
import dev.saurabharora.darkthemelint.detectors.utils.executeLintTest
import dev.saurabharora.darkthemelint.detectors.utils.valuesXMLFile
import dev.saurabharora.darkthemelint.issues.MissingNightColorIssue
import org.junit.Test


@Suppress("UnstableApiUsage")
class MissingNightColorDetectorTest {

    @Test
    fun `if there is a missing color in the night variant, then it should be flagged`() {
        val regularColorsFile = valuesXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <color name="colorPrimary">#008577</color>
                <color name="colorPrimaryDark">#00574B</color>
                <color name="colorAccent">#D81B60</color>
            </resources>
            
        """.trimIndent()
        )

        val nightColorsFiles = TestFiles.xml(
            "res/values-night/test_values.xml",
            """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <color name="colorPrimary">#008577</color>
                <color name="colorPrimaryDark">#00574B</color>
            </resources>
            
        """.trimIndent()
        )

        executeLintTest(MissingNightColorIssue.ISSUE, listOf(regularColorsFile, nightColorsFiles))
            .expectWarningCount(1)
    }

    @Test
    fun `if there is an extra color in the night variant, then it will be ignored as the check is not designed to catch this`() {
        val regularColorsFile = valuesXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <color name="colorPrimary">#008577</color>
                <color name="colorPrimaryDark">#00574B</color>
                <color name="colorAccent">#D81B60</color>
            </resources>
            
        """.trimIndent()
        )

        val nightColorsFiles = TestFiles.xml(
            "res/values-night/test_values.xml",
            """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <color name="colorPrimary">#008577</color>
                <color name="colorPrimaryDark">#00574B</color>
                <color name="colorAccent">#D81B60</color>
                <color name="colorExtra">#00574B</color>
            </resources>
            
        """.trimIndent()
        )

        executeLintTest(MissingNightColorIssue.ISSUE, listOf(regularColorsFile, nightColorsFiles))
            .expectWarningCount(0)
    }
}