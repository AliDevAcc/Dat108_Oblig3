package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hjelpeklasse.Deltager;
import hjelpeklasse.Validator;
public class Tested {
	private Deltager d;
	private Validator v;
	private List<Deltager> s;
	
	@BeforeEach
	public void setup() {
		d = new Deltager("","","","","","");
		v = new Validator();
	}
	
	@Test
	public void testPassord() {
		

		d.setHashpassord("sm");
		assertFalse(v.isValidPass(d.getHashpassord()));
		
		
		d.setHashpassord("Hallo");
		assertTrue(v.isValidPass(d.getHashpassord()));
		
	}
	
	
	@Test
	public void testEtternavn() {
		
		d.setFornavn("hei sann");
		assertTrue(v.isValidFName(d.getFornavn()));
		
		d.setFornavn("HeiHei");
		assertTrue(v.isValidFName(d.getFornavn()));
		
		d.setFornavn("A");
		assertFalse(v.isValidFName(d.getFornavn()));
		
		
	}
	
	@Test
	public void testFornavn() {
		
		d.setFornavn("hei sann");
		assertTrue(v.isValidFName(d.getFornavn()));
		
		d.setFornavn("HeiHei");
		assertTrue(v.isValidFName(d.getFornavn()));
		
		d.setFornavn("A");
		assertFalse(v.isValidFName(d.getFornavn()));
		
	}
	
	
	@Test
	void testNr() {
		
		d.setMobilnr("1234567");
		assertFalse(v.isValidNr(s,(d.getMobilnr())));
		d.setMobilnr("123456789"); 
		assertFalse(v.isValidNr(s,(d.getMobilnr())));
		d.setMobilnr("12345678"); 
		assertTrue(v.isValidNr(s,(d.getMobilnr())));
		
		d.setMobilnr("123aaa78");
		assertFalse(v.isValidNr(s,(d.getMobilnr())));
			
		
	}
}
