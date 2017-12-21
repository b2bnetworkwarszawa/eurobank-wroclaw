package test.java;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import main.java.KartaTurystyPage;
import main.java.SzczegolyKartyTurystyPage;

public class KupowanieKartyTurystyTest {
	
	private WebDriver webDriver;
	private KartaTurystyPage kartaTurysty;
	private SzczegolyKartyTurystyPage szczegolyKartyTurysty;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("http://kartaturysty.visitgdansk.com/");
		webDriver.manage().window().maximize();
		kartaTurysty = PageFactory.initElements(webDriver, KartaTurystyPage.class);
		
		szczegolyKartyTurysty = PageFactory.initElements(webDriver, SzczegolyKartyTurystyPage.class);
		szczegolyKartyTurysty.setDriver(webDriver);
	}
//	/html/body/div[1]/div[2]/div[2]
	//karta_turysty =kt
//	@Test
//	@Ignore
	public void kup_kt_normalne_i_sprawdz_czy_cena_jest_prawidlowa() {
		kartaTurysty.wcisnijPrzyciskZamow();
//		szczegolyKartyTurysty.wcisnijDodanieBiletuNormalnegoMezczyzna();
//		szczegolyKartyTurysty.uzupelnijPoleImienia();
		szczegolyKartyTurysty.uzupelnijFormularzOsobyKupujacej();
		
		assertEquals("kwoty nie sa zgodne",szczegolyKartyTurysty.kwotaPierwszegoBiletu(), szczegolyKartyTurysty.kwotaLacznaBiletow(),2);
	}
	
	@Test
	public void kup_kt_dla_kilku_osob_i_sprawdz_sumowanie() {
		kartaTurysty.wcisnijPrzyciskZamow(); 
		szczegolyKartyTurysty.przygotujFormularzDlaKilkuOsob();
		assertTrue(szczegolyKartyTurysty.sprawdz_czy_poprawne_sumowanie_platnosci());
	}
}
