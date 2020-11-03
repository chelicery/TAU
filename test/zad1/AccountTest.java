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
	public void testAccount() {
		assertNotNull(acc);		
	}
	@Test
	public void testWithdraw2() {
		acc.setBalance(200);
		acc.withdraw(50);
		int result = acc.getBalance();
		assertEquals(150, result);		
	}
	@Test
	public void testWithdraw3() {
		acc.setBalance(200);
		acc.withdraw(250);
		int result = acc.getBalance();
		//System.out.println("test1  " + acc.getBalance());
		assertEquals(200, result);		
	}
	
	
	
	
	

	
	
}
