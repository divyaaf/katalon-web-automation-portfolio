import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType. EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)

//Search by ID
TestObject search = new TestObject ('Search')
search.addProperty('xpath', ConditionType.EQUALS,'//*[@id="root"]/div/main/div/div/div[1]/input')
WebUI.setText(search, '14')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
WebUI.delay(2)
WebUI.waitForElementVisible(
    new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody'),
    10
)
List<WebElement> elementsId = WebUI.findWebElements(
    new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr/td[1]'),
	10
)
assert elementsId.any { it.getText() == '14' }
WebUI.delay(5)

// Search by Name
WebUI.setText(search, 'User 13')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
WebUI.delay(5)
WebUI.waitForElementVisible(
    new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody'),
    10
)
List<WebElement> elementsName = WebUI.findWebElements(
    new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr/td[2]'),
	10
)
assert elementsName.any { it.getText() == 'User 13' }
WebUI.delay(5)

//Search by Email 
WebUI.setText(search, 'user10@example.com')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
WebUI.waitForElementVisible(
	new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody'),
	10
)
List<WebElement> elementsEmail = WebUI.findWebElements(
	new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr/td[3]'),
	10
)
assert elementsEmail.any { it.getText() == 'user10@example.com' }


