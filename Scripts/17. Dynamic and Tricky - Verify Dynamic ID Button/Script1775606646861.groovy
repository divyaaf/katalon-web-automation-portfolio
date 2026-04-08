import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dynamicTricky = new TestObject ('Dynamic Tricky')
dynamicTricky.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[5]')
WebUI.click(dynamicTricky)
WebUI.delay(3)

TestObject dynamicButton = new TestObject ('Dynamic Button')
dynamicButton.addProperty('xpath', ConditionType.EQUALS, "//*[starts-with(@id, 'btn-submit-')]")
WebUI.click(dynamicButton)
WebUI.delay(2)
WebUI.waitForAlert(3)
String idPertama = WebUI.getAlertText()
WebUI.acceptAlert()

WebUI.refresh()
WebUI.click(dynamicButton)
WebUI.delay(2)
WebUI.waitForAlert(2)
String idKedua = WebUI.getAlertText()
WebUI.acceptAlert()

assert idPertama != idKedua