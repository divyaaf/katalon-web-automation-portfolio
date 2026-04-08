import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)

TestObject filter = new TestObject ('filter')
filter.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/thead/tr/th[1]')
WebUI.click(filter)
WebUI.delay(2)
WebUI.waitForElementVisible(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr/td'),10)
List<WebElement> elementssort = WebUI.findWebElements(
	new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[2]/table/tbody/tr/td[1]'),
	10
)
List<Integer> actualList = []

for (WebElement el : elementssort) {
	actualList.add(Integer.parseInt(el.getText().trim()))
}
List<Integer> expectedList = new ArrayList<>(actualList)
expectedList.sort(false)
assert actualList == expectedList