import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject dynamicTricky = new TestObject('Dynamic Tricky')
dynamicTricky.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[5]')
WebUI.click(dynamicTricky)
WebUI.delay(3)

TestObject delayedButton = new TestObject('Delayed Button') 
delayedButton.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[2]/button')
WebUI.click(delayedButton)
WebUI.waitForPageLoad(10)

TestObject success = new TestObject('Success')
success.addProperty('xpath', ConditionType.EQUALS, "//*[contains(text(), 'Process Completed')]")
WebUI.waitForElementVisible(success, 15)

String successNotif  = WebUI.getText(success)

assert successNotif.contains('Process Completed Successfully!')