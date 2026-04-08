import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(10)

TestObject previous = new TestObject ('Previous')
previous.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[1]')
assert WebUI.getAttribute(previous, 'disabled') != null