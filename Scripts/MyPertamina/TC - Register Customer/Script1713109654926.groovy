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

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Login Page/input_Email'), Email)

WebUI.setText(findTestObject('Object Repository/Login Page/input_PIN'), Pin)

WebUI.submit(findTestObject('Object Repository/Login Page/button_Masuk'))

WebUI.click(findTestObject('Object Repository/Main Page/button_Daftarkan Pelanggan Baru'))

WebUI.setText(findTestObject('Object Repository/Registration/Verification NIK/input_NIK KTP'), NIK)

WebUI.click(findTestObject('Object Repository/Registration/Verification NIK/button_Cek'))

WebUI.click(findTestObject('Object Repository/Registration/Verification NIK/button_Daftarkan Pelanggan'))

WebUI.click(findTestObject('Registration/Select Customer Type/select_Jenis Pengguna'))

WebUI.sendKeys(findTestObject('Registration/Select Customer Type/select_Jenis Pengguna'), Keys.chord(Keys.DOWN, Keys.DOWN, 
        Keys.ENTER))

WebUI.click(findTestObject('Registration/Select Customer Type/button_Lanjutkan'))

WebUI.click(findTestObject('Registration/Term Condition/button_Saya telah membaca  menyetujui'))

WebUI.setText(findTestObject('Object Repository/Registration/input_Nama Lengkap Pelanggan'), Nama_Pelanggan, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Registration/input_Nama Lengkap Pelanggan'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/input_Jenis Usaha_mantine-r1t'), Jenis_Usaha, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Registration/input_Jenis Usaha_mantine-r1t'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/input_Provinsi_mantine-r1c'), Provinsi, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Registration/input_Provinsi_mantine-r1c'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/input_KotaKabupaten_mantine-r1e'), KotaKabupaten, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Registration/input_KotaKabupaten_mantine-r1e'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/input_Kecamatan_mantine-r1g'), Kecamatan, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Registration/input_Kecamatan_mantine-r1g'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/input_Kelurahan_mantine-r1i'), Kelurahan, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Registration/input_Kelurahan_mantine-r1i'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.setText(findTestObject('Registration/textarea_Alamat_alamat'), Alamat)

WebUI.click(findTestObject('Registration/span_Ambil Gambar'))

WebUI.click(findTestObject('Registration/button_Capture Ambil Gambar'))

WebUI.click(findTestObject('Registration/span_Ambil atau Unggah Foto Usaha'))

WebUI.uploadFile(findTestObject('Registration/div_Unggah File'), 'C:\\Users\\Teguh\\Downloads\\TOKO.jpg')

WebUI.check(findTestObject('Registration/Check_Alamat Usaha'))

WebUI.click(findTestObject('Registration/button_Lanjutkan'))

WebUI.click(findTestObject('Registration/button_Daftarkan Pelanggan'))

WebUI.click(findTestObject('Registration/Registration Success/button_Selesai'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.closeBrowser()

