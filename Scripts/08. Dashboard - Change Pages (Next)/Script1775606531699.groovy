import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(5)

TestObject pageText = new TestObject('Page Text')
pageText.addProperty('xpath', ConditionType.EQUALS, "//span[contains(text(),'Page')]")

String before = WebUI.getText(pageText)

TestObject next = new TestObject ('Next')
next.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[2]')
WebUI.click(next)
WebUI.delay(5)

String after = WebUI.getText(pageText)

assert before != after
assert after.contains('Page 2')