import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject complexForms = new TestObject()
complexForms.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[6]')
WebUI.click(complexForms)
WebUI.delay(3)

TestObject file = new TestObject ()
file.addProperty('xpath', ConditionType.EQUALS, "//input[@type='file']")
WebUI.uploadFile(file, 'C:/Users/Divya/Downloads/pic/Cuplikan layar 2026-04-08 004648.png')
WebUI.waitForElementPresent(file, 3)