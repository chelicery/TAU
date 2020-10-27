package zad1;

import static org.junit.Assert.*;

import org.junit.*;


public class AccountTest {
	private Account acc;
	
	@Before
	public void setUp() {
		acc = new Account();
		
	}
	
	@After
	public void tearDown() {
		acc = null;
	}
	
	@Test
	public void testWithdraw1() {
		acc.setBalance(200);
		int result = acc.withdraw(50);
		//System.out.println("test1  " + acc.getBalance());
		assertEquals(150, result);		
	}
	
	
	
	
	

	
	
}
