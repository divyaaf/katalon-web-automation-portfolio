import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject uiElement = new TestObject ('UI Element')
uiElement.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[4]')
WebUI.click(uiElement)
WebUI.delay(5)

TestObject openModal = new TestObject ('Open Modal')
openModal.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/button')
WebUI.click(openModal)


TestObject popUp = new TestObject ('Pop Up')
WebUI.waitForElementVisible(popUp.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/div/div'), 6, FailureHandling.STOP_ON_FAILURE)

TestObject confirm = new TestObject('Confirm')
confirm.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[1]/div/div/div/button[2]')
WebUI.waitForElementClickable(confirm, 3)
WebUI.click(confirm)
WebUI.delay(5)
WebUI.waitForAlert(5)
String teksAlert = WebUI.getAlertText()
WebUI.verifyMatch(teksAlert, 'Action Confirmed!', false)
WebUI.acceptAlert()