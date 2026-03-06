import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open Url
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com')
WebUI.maximizeWindow()

// Input username and password
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/txt_Username'), username)

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/txt_Password'), password)


// Click btn_Login
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/btn_Login'))


// Check conditions
if(expectedResult == "Login Success") {
	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Page_OrangeHRM/h6_Dashboard'),
		10
	)
	
	WebUI.comment('Login success with: ' + username)
	
} else if(expectedResult == "Invalid credentials") {
	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Page_OrangeHRM/lbl_Error'),
		10
	)
	
	WebUI.comment('Login fail like expected result: ' + username)
} else if(expectedResult == "Username cannot be empty") {
	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Page_OrangeHRM/lbl_ErrorUsername'),
		10
	)
	
	WebUI.comment('Login fail like expected result: ' + username)
	
} else if(expectedResult == "Password cannot be empty") {
	WebUI.verifyElementPresent(
		findTestObject('Object Repository/Page_OrangeHRM/lbl_ErrorPassword'),
		10
	)
	
	WebUI.comment('Login fail like expected result: ' + username)
	
}

// Close Broswer
WebUI.closeBrowser()




