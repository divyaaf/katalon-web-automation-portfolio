import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject uiElement = new TestObject ('UI Element') 
uiElement.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[4]')
WebUI.click(uiElement)
WebUI.delay(3)

TestObject openModal = new TestObject('Open Modal')
openModal.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/button')
WebUI.click(openModal)
WebUI.delay(2)

TestObject popUp = new TestObject('Pop Up')
WebUI.waitForElementVisible(popUp.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/div/div'), 2, FailureHandling.STOP_ON_FAILURE)

TestObject cancel = new TestObject('Cancel')
cancel.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/div/div/div/button[1]')
WebUI.waitForElementClickable(cancel, 3)
WebUI.click(cancel)
WebUI.delay(3)

