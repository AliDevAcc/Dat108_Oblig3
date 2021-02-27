package hjelpeklasse;

import java.util.List;

public class Validator {
	
	public boolean isValidNr(List<Deltager> d,String s) {
		
		if (s == null) {
			return false;
		}
		if (s.length() != 8) {
			return false;
		}
		if (!containsOnlyDigits(s)) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidFName(String s) {
		if (s == null) {
			return false;
		}
		if(s.length()>20 || s.length()<2) {
			return false;
		}
		
		if(!s.matches("^[A-ZÆØÅa-zæøå -]+$")) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean isValidLName(String s) {
		if (s == "") {
			return false;
		}
		if(s.length()>20 || s.length()<2) {
			return false;
		}
		
		if(!s.matches("^[ÆØÅæøåA-Za-z-]+$")) {
			return false;
		}
		
		return true;
	}
	
	public boolean isValidPass(String s) {
		if(s.length()<4) {
			return false;
		}
		
		return true;
	}
	
	public boolean erLik(String s, String s0) {
		if(isValidPass(s) && s0.equals(s)) {
			return true;
		}
		
		return false;
	}

	private boolean containsOnlyDigits(String s) {
		boolean result = true;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean Unique(List<Deltager> Deltagerliste,String s) {
		boolean result=true;
		if (s.length() == 0) {
			return false;
		}
		String d_nr="";
		for(int i=0;i <Deltagerliste.size(); i++) {
			d_nr=Deltagerliste.get(i).getMobilnr();
			if (s.equals(d_nr)) {
				result=false;
			}
		}
		return result;
	}
	
	public boolean altGyldig(boolean a, boolean b, boolean c, boolean d) {
		
		if(a && b && c && d) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
}
