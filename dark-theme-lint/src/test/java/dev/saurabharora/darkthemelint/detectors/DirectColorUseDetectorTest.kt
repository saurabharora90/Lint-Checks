package dev.saurabharora.darkthemelint.detectors

import dev.saurabharora.darkthemelint.detectors.utils.executeLintTest
import dev.saurabharora.darkthemelint.detectors.utils.layoutXMLFile
import dev.saurabharora.darkthemelint.issues.DirectColorUseIssue
import org.junit.Test


@Suppress("UnstableApiUsage")
class DirectColorUseDetectorTest {

    @Test
    fun `direct color in tint attribute in a layout file should be flagged by lint`() {
        layoutXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

                <com.google.android.material.floatingactionbutton.FloatingActionButton
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="bottom|end"
                    android:layout_margin="@dimen/fab_margin"
                    android:tint="#ABABAB"
                    app:srcCompat="@android:drawable/ic_dialog_email" />

            </androidx.coordinatorlayout.widget.CoordinatorLayout>
            
        """.trimIndent()
        )
            .executeLintTest(DirectColorUseIssue.ISSUE) //Force the issue to be checked so that only warnings related to this issue are listed. This allows us to skip the skip the expected string block in tests for ease
            .expectWarningCount(1)
    }

    @Test
    fun `reference to a color attribute in tint attribute in a layout file should not be flagged by lint`() {
        layoutXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

                <com.google.android.material.floatingactionbutton.FloatingActionButton
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="bottom|end"
                    android:layout_margin="@dimen/fab_margin"
                    android:tint="@color/primary"
                    app:srcCompat="@android:drawable/ic_dialog_email" />

            </androidx.coordinatorlayout.widget.CoordinatorLayout>
            
        """.trimIndent()
        )
            .executeLintTest(DirectColorUseIssue.ISSUE)
            .expectWarningCount(0)
    }

    @Test
    fun `direct color in background attribute in a layout file should be flagged by lint`() {
        layoutXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

                <com.google.android.material.floatingactionbutton.FloatingActionButton
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="bottom|end"
                    android:layout_margin="@dimen/fab_margin"
                    android:background="#ABABAB"
                    app:srcCompat="@android:drawable/ic_dialog_email" />

            </androidx.coordinatorlayout.widget.CoordinatorLayout>
            
        """.trimIndent()
        )
            .executeLintTest(DirectColorUseIssue.ISSUE)
            .expectWarningCount(1)
    }

    @Test
    fun `direct color in foreground attribute in a layout file should be flagged by lint`() {
        layoutXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

                <com.google.android.material.floatingactionbutton.FloatingActionButton
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="bottom|end"
                    android:layout_margin="@dimen/fab_margin"
                    android:foreground="#ABABAB"
                    app:srcCompat="@android:drawable/ic_dialog_email" />

            </androidx.coordinatorlayout.widget.CoordinatorLayout>
            
        """.trimIndent()
        )
            .executeLintTest(DirectColorUseIssue.ISSUE)
            .expectWarningCount(1)
    }

    @Test
    fun `direct color in text color attribute in a layout file should be flagged by lint`() {
        layoutXMLFile(
            """
            <?xml version="1.0" encoding="utf-8"?>
            <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                tools:context=".MainActivity">

                <TextView
                    android:id="@+id/fab"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="bottom|end"
                    android:layout_margin="@dimen/fab_margin"
                    android:textColor="#ABABAB"
                    android:test="Hello World" />

            </androidx.coordinatorlayout.widget.CoordinatorLayout>
            
        """.trimIndent()
        )
            .executeLintTest(DirectColorUseIssue.ISSUE)
            .expectWarningCount(1)
    }
}