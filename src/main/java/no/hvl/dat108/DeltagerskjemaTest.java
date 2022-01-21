package no.hvl.dat108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeltagerskjemaTest {
	
	//RegEx vi vil teste.
	String validFornavn = "^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå -]{1,20}$";
	String validEtternavn = "^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå-]{1,20}$";
	String validMobil = "^[0-9]{8}$";
	String validPassord = "^[A-ZÆØÅa-zæøå\\d]{3,}$";

	@Test
	public void testValidFornavn() {
		 assertFalse("ole".matches(validFornavn));
		 assertFalse("ole1".matches(validFornavn));
		 assertFalse("ole%".matches(validFornavn));
		 assertFalse("O".matches(validFornavn));
		 assertFalse("Oleeeeeeeeeeeeeeeeeeeee".matches(validFornavn)); 
		 assertTrue("Ole".matches(validFornavn));
		 assertTrue("Ole petter".matches(validFornavn));
		 assertTrue("Svein-Jarle".matches(validFornavn));
	}

	@Test
	public void testValidEtternavn() {
		 assertFalse("nordmann".matches(validEtternavn));
		 assertFalse("nordmann1".matches(validEtternavn));
		 assertFalse("Nordmann%".matches(validEtternavn));
		 assertFalse("N".matches(validEtternavn));
		 assertFalse("Nordmanneeeeeeeeeeeeeen".matches(validEtternavn));
		 assertFalse("Nord Mann".matches(validEtternavn));
		 assertTrue("Nord-Mann".matches(validEtternavn));
		 assertTrue("Nordmann".matches(validEtternavn));
	}

	@Test
	public void testValidMobil() {
		 assertFalse("123456789".matches(validMobil));
		 assertFalse("a1234567".matches(validMobil));
		 assertFalse("1".matches(validMobil));
		 assertFalse("&1234567".matches(validMobil));
		 assertTrue("12345678".matches(validMobil));
	}

	@Test
	public void testValidPassord() {
		 assertFalse("12".matches(validPassord));
		 assertFalse("a1".matches(validPassord));
		 assertFalse("123!".matches(validPassord));
		 assertFalse("!%/!".matches(validPassord));
		 assertTrue("123A".matches(validPassord));
		 assertTrue("1234".matches(validPassord));
		 assertTrue("ABCD".matches(validPassord));
		 assertTrue("abCD12".matches(validPassord));
	}

}



 

