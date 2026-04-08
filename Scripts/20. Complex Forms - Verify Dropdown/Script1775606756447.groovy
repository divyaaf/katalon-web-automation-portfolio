import org.openqa.selenium.Keys

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/web-testing-playground/')

TestObject complexForms = new TestObject ('Compex Forms')
complexForms.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[6]')
WebUI.click(complexForms)
WebUI.delay(3)

TestObject dropDownCountry = new TestObject ('Drop Down Country')
dropDownCountry.addProperty('xpath', ConditionType.EQUALS, '//*[@id="country"]')
WebUI.click(dropDownCountry)
WebUI.waitForElementVisible(dropDownCountry, 3)
List<String> expectedOptions = ['USA', 'Indonesia', 'UK']
boolean isPresentCountry = WebUI.verifyOptionsPresent(dropDownCountry, expectedOptions)
WebUI.sendKeys(dropDownCountry, 'USA')
WebUI.waitForElementVisible(dropDownCountry, 3)
WebUI.sendKeys(dropDownCountry, Keys.chord(Keys.ENTER))
WebUI.delay(3)

TestObject dropDownState = new TestObject (' Drop Down State')
dropDownState.addProperty('xpath', ConditionType.EQUALS, '//*[@id="state"]')
WebUI.waitForElementVisible(dropDownState, 3)
List<String> expectedOptions2 = ['California', 'Texas', 'NewYork']
boolean isPresentState = WebUI.verifyOptionsPresent(dropDownState, expectedOptions2)
WebUI.click(dropDownState)
WebUI.sendKeys(dropDownState, 'Texas')
WebUI.waitForElementVisible(dropDownState, 3)
WebUI.sendKeys(dropDownState, Keys.chord(Keys.ENTER))

TestObject dropDownCity = new TestObject('Drop Down City')
dropDownCity.addProperty('xpath', ConditionType.EQUALS, '//*[@id="city"]')
WebUI.click(dropDownCity)
WebUI.waitForElementVisible(dropDownCity, 3)
List<String> expectedOptions3 = ['Houston', 'Austin', 'Dallas']
boolean isPresentCity = WebUI.verifyOptionsPresent(dropDownCity, expectedOptions3)
WebUI.click(dropDownCity)
WebUI.sendKeys(dropDownCity, 'Dallas')
WebUI.waitForElementVisible(dropDownCity, 3)
WebUI.sendKeys(dropDownCity, Keys.chord(Keys.ENTER))
