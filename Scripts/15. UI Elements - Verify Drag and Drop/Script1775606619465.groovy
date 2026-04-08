import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper

WebUI.openBrowser('http://localhost:5173/')

TestObject uiElement = new TestObject('UI Element')
uiElement.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[4]')
WebUI.click(uiElement)
WebUI.delay(3)

TestObject drag1 = new TestObject('Drag')
drag1.addProperty('xpath', ConditionType.EQUALS, "//*[@data-testid='draggable-item-1']")


TestObject drop1 = new TestObject('Drop')
drop1.addProperty('xpath', ConditionType.EQUALS, "//*[@data-testid='dnd-column-done']")

WebDriver driver = DriverFactory.getWebDriver()
Actions action = new Actions(driver)

WebElement sourceElement = WebUiCommonHelper.findWebElement(drag1, 5)
WebElement targetElement = WebUiCommonHelper.findWebElement(drop1, 5)

action.clickAndHold(sourceElement)
      .pause(java.time.Duration.ofMillis(1000)) 
      .moveToElement(targetElement)
      .pause(java.time.Duration.ofMillis(1000)) 
      .release()
      .build()
      .perform()

WebUI.delay(2)

TestObject validasiPindah = new TestObject('Validasi Pindah')
validasiPindah.addProperty('xpath', ConditionType.EQUALS, "//div[@data-testid='dnd-column-done']//div[@data-testid='draggable-item-1']")
WebUI.verifyElementPresent(validasiPindah, 3)