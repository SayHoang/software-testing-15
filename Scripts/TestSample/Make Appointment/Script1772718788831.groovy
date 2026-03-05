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

// Login with Keywords
CustomKeywords.'sample.Login.LoginApplicationWithGlobalVariable'()

//Input facility from CSV
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_CURA Healthcare Service/select_Facility'), facility, false)

// Choose Healthcare Program
if (program == 'Medicaid') {
    WebUI.click(findTestObject('Page_CURA Healthcare Service/input_Medicaid'))
} else if (program == 'Medicare') {
    WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Medicare'))
} else {
    WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_None'))
}

// Input Visit Date & Comment
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/txt_VisitDate'), visit_date)
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/txt_Comment'), comment)


// Click btn
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/btn_BookAppointment'))


// Confirm result
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_AppointmentConfirmation'), 1)
WebUI.comment('Appointment booked: ' +facility + '-' + visit_date)

WebUI.closeBrowser()
