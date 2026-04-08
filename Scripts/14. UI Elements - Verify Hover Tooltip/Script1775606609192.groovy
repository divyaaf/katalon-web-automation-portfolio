import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/')

TestObject uiElement = new TestObject('UI Element')
uiElement.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[4]')
WebUI.click(uiElement)
WebUI.delay(3)

TestObject hover = new TestObject('Hover')
hover.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/section[2]/div')
WebUI.mouseOver(hover)

TestObject tooltipElement = new TestObject('Tooltip Element')
tooltipElement.addProperty('xpath', ConditionType.EQUALS, "//*[text()='This is hidden tooltip text!']")

WebUI.waitForElementVisible(tooltipElement, 3)

String tooltipTeks = WebUI.getText(tooltipElement)
WebUI.verifyMatch(tooltipTeks, 'This is hidden tooltip text!', false)