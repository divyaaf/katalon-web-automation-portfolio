import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject dashboard = new TestObject ('Dashboard')
dashboard.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[3]')
WebUI.click(dashboard)
WebUI.delay(10)

TestObject pageText = new TestObject('Page Text')
pageText.addProperty('xpath', ConditionType.EQUALS, "//span[contains(text(),'Page')]")

String beforeNext = WebUI.getText(pageText)

TestObject next = new TestObject ('Next')
next.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[2]')
WebUI.click(next)
WebUI.delay(5)

String afterNext = WebUI.getText(pageText)

assert beforeNext != afterNext


TestObject previousPage = new TestObject('Previous Page')
previousPage.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/span')

String beforePrevious = WebUI.getText(previousPage)

TestObject previous = new TestObject ('Previous')
previous.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/div[3]/button[1]')
WebUI.click(previous)
WebUI.delay(5)

String afterPrevious = WebUI.getText(previousPage)
assert beforePrevious != afterPrevious
