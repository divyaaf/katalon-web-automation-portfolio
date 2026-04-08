import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(10)

TestObject edit = new TestObject ('Edit')
edit.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr[1]/td[6]/button[1]')
WebUI.click(edit)
WebUI.waitForAlert(15)
String alertText = WebUI.getAlertText()
assert alertText.contains('Edit user')
WebUI.acceptAlert()