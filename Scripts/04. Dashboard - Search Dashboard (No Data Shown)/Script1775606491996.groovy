import org.openqa.selenium.Keys

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)

//Search by ID
TestObject search = new TestObject ('Search')
search.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[1]/input')
WebUI.setText(search, '100')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
WebUI.delay(5)

//Search by Name
WebUI.setText(search, 'user234')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
WebUI.delay(5)

//Search by Email
WebUI.setText(search, 'user100@yahu.com')
WebUI.sendKeys(search, Keys.chord(Keys.ENTER))
