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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://subsiditepatlpg.mypertamina.id/merchant/auth/login')

WebUI.setText(findTestObject('Object Repository/Login Page/input_EmailNo. Handphone_mantine-r0'), Email)

WebUI.setText(findTestObject('Object Repository/Login Page/input_PIN (6-digit)_mantine-r1'), Pin)

WebUI.submit(findTestObject('Object Repository/Login Page/button_Masuk'))

WebUI.setText(findTestObject('Object Repository/Main Page/NIK Pelanggan'), NIK)

WebUI.submit(findTestObject('Object Repository/Main Page/button_Cek'))

if (WebUI.verifyElementPresent(findTestObject('Main Page/2 Jenis Penggunaan/h3_Pelanggan memiliki 2 jenis pengguna'), 2, 
    FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Main Page/2 Jenis Penggunaan/span_Usaha Mikro'))

    WebUI.click(findTestObject('Main Page/2 Jenis Penggunaan/button_Lanjut Transaksi'))
}

if (WebUI.verifyElementPresent(findTestObject('Sale/Warning Melebihi Batas Wajar'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Sale/Icon Back'))

    WebUI.click(findTestObject('Main Page/span_Keluar Akun'))

    WebUI.click(findTestObject('Main Page/button_Keluar'))
} else {
    for (int r = 1; r <= 9; r++) {
        WebUI.click(findTestObject('Sale/Icon Plus'))
    }
    
    WebUI.click(findTestObject('Sale/button_Cek Pesanan'))

    WebUI.click(findTestObject('Sale/button_Proses Transaksi'))

    if (WebUI.verifyElementPresent(findTestObject('Sale/Melebihi Batas Kewajaran/h3_Melebihi Batas Kewajaran'), 2, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Sale/Melebihi Batas Kewajaran/button_Oke'))

        WebUI.click(findTestObject('Sale/Icon Back'))

        WebUI.click(findTestObject('Main Page/span_Keluar Akun'))

        WebUI.click(findTestObject('Main Page/button_Keluar'))
    } else {
        WebUI.click(findTestObject('Sale/Struk/Home'))

        WebUI.click(findTestObject('Main Page/span_Keluar Akun'))

        WebUI.click(findTestObject('Main Page/button_Keluar'))
    }
}

