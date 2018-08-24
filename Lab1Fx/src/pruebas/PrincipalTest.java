package pruebas;
import modelo.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PrincipalTest {

	//Attributes 
	private Principal principal; 
	
	@Before
	public void before() {
		principal = new Principal();
	}
	
	@Test
	public void testVerificateIntegerDouble() {
		principal = new Principal();
		boolean isTrue= false;
		String code = "1";
	    boolean actually = principal.verificateIntegerDouble(code);
	  
		assertEquals(isTrue, actually);
	}
	
	@Test
	public void testCalculatePercent() {
		principal = new Principal();
		int number = 50;
		int percent = 50;
	    int hope = 25;
	    int actually = principal.calculatePercent(number, percent);
	    
	    assertEquals(hope, actually);
		
	}
	
	@Test
	public void testRandomInt() {
		principal = new Principal();
		int amount = 4;
		boolean repeated = true;
		int LowerIndex= 1;
		int HighIndex= 5;
		
		ArrayList<Integer> inter = principal.randomInt(amount, repeated, LowerIndex, HighIndex);
		for(int a: inter) {
			System.out.println(a);
		}
	}

}
