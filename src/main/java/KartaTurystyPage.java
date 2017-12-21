package main.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KartaTurystyPage {
	private static final String zamowPrzyciskSciezka = "//*[@id=\"responsive-menu\"]/li[9]/span/a";
	
	@FindBy(xpath=zamowPrzyciskSciezka)
	private WebElement zamowPrzycisk;
	
	public void wcisnijPrzyciskZamow() {
		zamowPrzycisk.click();
	}
	
	

}
