import org.openqa.selenium.Keys
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:5173/web-testing-playground/')

TestObject register = new TestObject ('Register')
register.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/aside/nav/a[2]')
WebUI.click(register)

TestObject fullName = new TestObject('Full Name')
fullName.addProperty('xpath', ConditionType.EQUALS, '//*[@id="fullName"]')
WebUI.setText(fullName, 'Testing Automation')
WebUI.sendKeys(fullName, Keys.chord(Keys.ENTER))

TestObject emailAddress = new TestObject ('Email Address')
emailAddress.addProperty('xpath', ConditionType.EQUALS,'//*[@id="email"]')
WebUI.setText(emailAddress, 'qa@test.com')
WebUI.sendKeys(emailAddress, Keys.chord(Keys.ENTER))

TestObject password = new TestObject ('Password')
password.addProperty('xpath', ConditionType.EQUALS, '//*[@id="password"]')
WebUI.setText(password, 'password123')
WebUI.sendKeys(password, Keys.chord(Keys.ENTER))

TestObject confirmPassword = new TestObject ('Confirm Password')
confirmPassword.addProperty('xpath', ConditionType.EQUALS, '//*[@id="confirmPassword"]' )
WebUI.setText(confirmPassword, 'password123')
WebUI.sendKeys(confirmPassword, Keys.chord(Keys.ENTER))

TestObject agree = new TestObject ('Agree')
agree.addProperty('xpath', ConditionType.EQUALS, '//*[@id="termsAccepted"]')
WebUI.click(agree)

TestObject button = new TestObject ('Button')
button.addProperty('xpath', ConditionType.EQUALS, '//*[@id="root"]/div/main/div/div/form/button')
WebUI.click(button)