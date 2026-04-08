import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/web-testing-playground/')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(10)

TestObject delete = new TestObject ('Delete')
delete.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr[1]/td[6]/button[2]')
WebUI.click(delete)
WebUI.delay(5)

List<WebElement> elemendelete = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//select[@name = 'dashboard-table']"), 10)
assert !elemendelete.any { it.getText().contains('User 1') }