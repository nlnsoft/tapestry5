package org.apache.tapestry5.integration.app1

import org.apache.tapestry5.integration.TapestryCoreTestCase
import org.apache.tapestry5.test.TapestryTestConfiguration
import org.testng.annotations.Test

@TapestryTestConfiguration(webAppFolder = "src/test/app1")
class MiscTests extends TapestryCoreTestCase {

  @Test
  void operation_tracking_via_annotation() {
    openLinks "Operation Worker Demo", "throw exception"

    assertTitle "Application Exception"

    assertTextPresent "[Operation Description]"
  }
}
