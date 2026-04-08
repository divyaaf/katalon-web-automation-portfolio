import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject dynamicTricky = new TestObject ('Dynamic Tricky')
dynamicTricky.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[5]')
WebUI.click(dynamicTricky)
WebUI.delay(1)

TestObject notif = new TestObject('Notif')
notif.addProperty('xpath', ConditionType.CONTAINS, "//*[contains(text(),'This notification')]")

WebUI.waitForElementVisible(notif, 5)