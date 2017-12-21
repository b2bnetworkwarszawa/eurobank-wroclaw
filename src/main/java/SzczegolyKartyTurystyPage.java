package main.java;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SzczegolyKartyTurystyPage {
	
	private WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	private static final String dodanieBiletuNormalnegoMezczyznaSciezka = "//*[@id=\"fLiczbaOsob\"]/div/div/div[1]/div[2]/div/div/div[1]";
	private static final String poleImieniaSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[1]/div[1]/div[1]/input";
	private static final String poleNazwiskoSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[1]/div[2]/div[1]/input";
	private static final String poleEmailSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[2]/div[1]/div[1]/input";
	private static final String poleEmailPotwierdzSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[2]/div[2]/div[1]/input";
	private static final String poleRokUrodzeniaSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[3]/div[1]/div[1]/input";
	private static final String poleKrajSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/div[3]/div[2]/div[1]/select";
	private static final String polePakietSciezka = "//*[@id=\"fFormularzOsob\"]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/select";
	private static final String poleKosztBiletuPierwszegoSciezka = "//*[@id=\"podsumowanie\"]/table/tbody/tr[1]/td[2]";
	private static final String poleKosztuLacznegoBiletowSciezka = "//*[@id=\"podsumowanie\"]/table/tbody/tr[2]/td[2]";
	private static final String poleImieDodatkowejOsobySciezka = "//*[@id=\"fFormularzOsob\"]/div[nr_dodat]/div[1]/div[1]/div[1]/div[1]/input";
	private static final String poleIloscMezczyznSciezka = "//*[@id=\"DOROSLY_FACET\"]";
	private static final String poleIloscKobietSciezka = "//*[@id=\"DOROSLA_KOBIETA\"]";
	private static final String poleIloscChlopcowSciezka = "//*[@id=\"DZIECKO_CHLOPIEC\"]";
	private static final String poleIloscDziewczynaSciezka = "//*[@id=\"DZIECKO_DZIEWCZYNKA\"]";
	private static final String tabelaPodsumowaniePlatnosciSciezka = "//*[@id=\"podsumowanie\"]/table";
	
	
	@FindBy(xpath=dodanieBiletuNormalnegoMezczyznaSciezka)
	private WebElement dodanieBiletuNormalnegoMezczyzna;
	
	@FindBy(xpath=poleImieniaSciezka)
	private WebElement poleImienia;
	
	@FindBy(xpath=poleNazwiskoSciezka)
	private WebElement poleNazwisko;
	
	@FindBy(xpath=poleEmailSciezka)
	private WebElement poleEmail;
	
	@FindBy(xpath=poleEmailPotwierdzSciezka)
	private WebElement poleEmailPotwierdz;
	
	@FindBy(xpath=poleRokUrodzeniaSciezka)
	private WebElement poleRokUrodzenia;
	
	@FindBy(xpath=poleKrajSciezka)
	private WebElement poleKraj;
	
	@FindBy(xpath=polePakietSciezka)
	private WebElement polePakiet;
	
	@FindBy(xpath=poleKosztBiletuPierwszegoSciezka)
	private WebElement poleKosztBiletuPierwszego;
	
	@FindBy(xpath=poleKosztuLacznegoBiletowSciezka)
	private WebElement poleKosztuLacznegoBiletow;
	
	@FindBy(xpath=poleIloscMezczyznSciezka)
	private WebElement poleIloscMezczyzn;
	
	@FindBy(xpath=poleIloscKobietSciezka)
	private WebElement poleIloscKobiet;
	
	@FindBy(xpath=poleIloscChlopcowSciezka)
	private WebElement poleIloscChlopcow;
	
	@FindBy(xpath=poleIloscDziewczynaSciezka)
	private WebElement poleIloscDziewczynek;
	
	@FindBy(xpath = tabelaPodsumowaniePlatnosciSciezka)
	private WebElement polePodsumowanieTabeli;
	
	public int iloscOsobDodatkowych() {
		int liczbaKobiet = 0;//Integer.parseInt(poleIloscKobiet.getAttribute("value"));
		int liczbaMezczyzn = Integer.parseInt(poleIloscMezczyzn.getAttribute("value"));;
		int iloscChlopcow = 0;// Integer.parseInt(poleIloscChlopcow.getAttribute("value"));
		int iloscDziewczynek = 0;//Integer.parseInt(poleIloscDziewczynek.getAttribute("value"));
		
		return liczbaKobiet+liczbaMezczyzn+iloscChlopcow+iloscDziewczynek-1;
	}
	
	
	
	public void wcisnijDodanieBiletuNormalnegoMezczyzna() {
		dodanieBiletuNormalnegoMezczyzna.click();
	}
	
	public void uzupelnijPoleImienia() {
		poleImienia.sendKeys("Andrzej");
	}
	
	public void uzupelnijPoleNazwisko() {
		poleNazwisko.sendKeys("Karwowski");
	}
	
	public void uzupelnijPoleEmail() {
		poleEmail.sendKeys("wkortas@gmail.com");
	}
	
	public void uzupelnijPolePotwierdzEmail() {
		poleEmailPotwierdz.sendKeys("wkortas@gmail.com");
	}
	
	public void uzupelnijPoleRokUrodzenia() {
		poleRokUrodzenia.sendKeys("1992");
	}
	
	public void uzupelnijKraj() {
		Select combo = new Select(poleKraj);
		combo.selectByIndex(1);
	}
	
	public void uzupelnijPakiet() {
		Select combo = new Select(polePakiet);
		combo.selectByIndex(2);
	}
	
	public double kwotaPierwszegoBiletu() {
		return wezCene(poleKosztBiletuPierwszego.getText());
	}
	
	public double kwotaLacznaBiletow() {
		return wezCene(poleKosztuLacznegoBiletow.getText());
	}
	
	public double wezCene(String kwotaNapis) {//43.00 PLN
		String kwotaBezPln = kwotaNapis.replace("PLN", "").trim();
//		String kwotaBezPln = kwotaNapis.substring(0, kwotaNapis.length()-4).trim();
		double kwota = Double.parseDouble(kwotaBezPln);
		System.out.println(kwota);
		return kwota;
	}
	
	public void uzupelnijFormularzOsobyKupujacej() {
		wcisnijDodanieBiletuNormalnegoMezczyzna();
		AjaxUtil.waitForAjax(driver);
		uzupelnijPoleImienia();
		uzupelnijPoleNazwisko();
		uzupelnijPoleEmail();
		uzupelnijPolePotwierdzEmail();
		uzupelnijPoleRokUrodzenia();
		uzupelnijKraj();
		uzupelnijPakiet();
		AjaxUtil.waitForAjax(driver);
	}
	
	public void przygotujFormularzDlaKilkuOsob() {
		uzupelnijFormularzOsobyKupujacej();
		AjaxUtil.waitForAjax(driver);
		wcisnijDodanieBiletuNormalnegoMezczyzna();
		AjaxUtil.waitForAjax(driver);
		wcisnijDodanieBiletuNormalnegoMezczyzna();
		AjaxUtil.waitForAjax(driver);
		int iloscOsobDodatkowychDlaKtorychKupujemyBilet = iloscOsobDodatkowych();
		System.out.println("ilosc dodatkowych osob "+iloscOsobDodatkowychDlaKtorychKupujemyBilet);
		uzupelnijSekcjeDodatkowychOsob(iloscOsobDodatkowychDlaKtorychKupujemyBilet);
	}
	
	public void uzupelnijDaneDodatkowejOsoby(String nrDiv, String imie) {
		//nr_dodatkowej_osoby
		//"//*[@id=\"fFormularzOsob\"]/div[4]/div[1]/div[1]/div[1]/div[1]/input";
		String mojaNazwaZmiennej = poleImieDodatkowejOsobySciezka.replace("nr_dodat", nrDiv);
		WebElement imieElement = driver.findElement(By.xpath(mojaNazwaZmiennej));
		imieElement.sendKeys(imie);
	}
	
	public void uzupelnijSekcjeDodatkowychOsob(int liczbaDodatkowychOsob) {
		for(int i =4;i<4+liczbaDodatkowychOsob;i++) {
			uzupelnijDaneDodatkowejOsoby(Integer.toString(i), "Janek "+i);
		}
	}
	
	public boolean sprawdz_czy_poprawne_sumowanie_platnosci() {
		boolean czySumaZgodna = false;
		double sumaPlatnosci = 0;
		List<WebElement> wiersze = polePodsumowanieTabeli.findElements(By.tagName("tr"));
		
		for(int i=0; i<wiersze.size()-1;i++) {
			WebElement kwota = wiersze.get(i).findElements(By.tagName("td")).get(1);
			System.out.println(kwota.getText());
			sumaPlatnosci =sumaPlatnosci+ wezCene(kwota.getText());
		}
		WebElement kwotaPodsumowania = wiersze.get(wiersze.size()-1).findElements(By.tagName("td")).get(1);
		if(sumaPlatnosci == wezCene(kwotaPodsumowania.getText())) {
			czySumaZgodna = true;
		}
		return czySumaZgodna;
		
		
	}

}
