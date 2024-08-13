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

// Open Browser and Navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://subsiditepatlpg.mypertamina.id/merchant/auth/login')

// Log in
WebUI.setText(findTestObject('Object Repository/Login Page/input_Email'), Email)
WebUI.setText(findTestObject('Object Repository/Login Page/input_PIN'), Pin)
WebUI.submit(findTestObject('Object Repository/Login Page/button_Masuk'))

// Cek apakah login gagal
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Login Page/Gagal Login/h3_Gagal masuk Akun'), 2, FailureHandling.OPTIONAL)) {
    // Tunggu selama 2 menit (120 detik)
    WebUI.delay(120)
    
    // Klik tombol "Mengerti" untuk menutup pesan gagal login
    WebUI.click(findTestObject('Object Repository/Login Page/Gagal Login/button mengerti'))
    
    // Coba login lagi
    WebUI.submit(findTestObject('Object Repository/Login Page/button_Masuk'))
}

// NIK Check
WebUI.setText(findTestObject('Object Repository/Main Page/NIK Pelanggan'), NIK)
WebUI.submit(findTestObject('Object Repository/Main Page/button_Cek'))

// NIK Check
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Main Page/NIK Belum Terdaftar/h4_NIK belum terdaftar'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Main Page/NIK Belum Terdaftar/button_kembali'))
} else {
    // If NIK is registered, proceed with the following actions

    // Handle "2 Jenis Penggunaan" scenario
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Main Page/2 Jenis Penggunaan/h3_Pelanggan memiliki 2 jenis pengguna'), 2, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Object Repository/Main Page/2 Jenis Penggunaan/span_Usaha Mikro'))
        WebUI.click(findTestObject('Object Repository/Main Page/2 Jenis Penggunaan/button_Lanjut Transaksi'))
    }

    // Handle "Melebihi Batas Kewajaran" scenario
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/Sale/span_Tidak dapat transaksi karena telah melebihi batas kewajaran pembelian LPG 3 kg bulan ini'), 2, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Object Repository/Sale/Icon Back'))
        WebUI.callTestCase(findTestCase('MyPertamina/TC - Keluar'), [:], FailureHandling.STOP_ON_FAILURE)
    } else {
        // Verifikasi apakah salah satu dari kedua elemen hadir
        boolean isUserTypePresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Sale/Jenis Pengguna/span_Rumah TanggaOn Demand'), 2, FailureHandling.OPTIONAL) ||
                                    WebUI.verifyElementPresent(findTestObject('Object Repository/Sale/Jenis Pengguna/span_Rumah TanggaP3KE'), 2, FailureHandling.OPTIONAL)
        
        if (isUserTypePresent) {
            // Add products jika salah satu elemen ditemukan
            for (int r = 1; r <= 1; r++) {
                WebUI.click(findTestObject('Object Repository/Sale/Icon Plus'))
            }
        } else {
            // Jika tidak ada elemen yang ditemukan, tetap melakukan aksi klik 2 kali
            for (int r = 1; r <= 4; r++) {
                WebUI.click(findTestObject('Object Repository/Sale/Icon Plus'))
            }
        }

        WebUI.click(findTestObject('Object Repository/Sale/button_Cek Pesanan'))

        // Handle exceeding limits scenario
        if (WebUI.verifyElementPresent(findTestObject('Object Repository/Sale/Melebihi Batas Kewajaran/h3_Melebihi Batas Kewajaran (Nomor KK yang sama)'), 2, FailureHandling.OPTIONAL)) {
            WebUI.click(findTestObject('Object Repository/Sale/Melebihi Batas Kewajaran/button_Oke'))
            WebUI.click(findTestObject('Object Repository/Sale/Icon Back'))
            WebUI.callTestCase(findTestCase('MyPertamina/TC - Keluar'), [:], FailureHandling.STOP_ON_FAILURE)
        } else {
            // Proceed with transaction
            WebUI.click(findTestObject('Object Repository/Sale/button_Proses Transaksi'))
            WebUI.click(findTestObject('Object Repository/Sale/Struk/a_Ke Beranda'))
            WebUI.callTestCase(findTestCase('MyPertamina/TC - Keluar'), [:], FailureHandling.STOP_ON_FAILURE)
        }
    }
}

// Close Browser
WebUI.closeBrowser()
