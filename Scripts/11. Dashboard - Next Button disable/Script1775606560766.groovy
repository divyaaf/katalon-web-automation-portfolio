import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(5)

TestObject page1 = new TestObject ('Page1')
page1.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[2]')
for (int i = 1; i <= 3; i++) {
    WebUI.click(page1)
    WebUI.delay(2)
}

TestObject nextDisable = new TestObject ('Next Disable')
nextDisable.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[2]')
assert WebUI.getAttribute(nextDisable, 'disabled')!=null