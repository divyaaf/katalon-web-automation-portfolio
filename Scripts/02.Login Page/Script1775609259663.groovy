import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://divyaaf.github.io/web-testing-playground')

TestObject email = new TestObject('Email')
email.addProperty('xpath', ConditionType.EQUALS, '//*[@id="email"]')
WebUI.setText(email, 'qa@test.com')

TestObject password = new TestObject ('Password')
password.addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]')
WebUI.setText(password, 'password123')

TestObject login = new TestObject ('Login')
login.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/form/button')
WebUI.click(login)