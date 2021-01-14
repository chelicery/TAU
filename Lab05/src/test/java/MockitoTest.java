import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.*;
import org.junit.Assert.*;
import org.mockito.Mock;

public class MockitoTest {
	Account  account;
	User user;
	@Before
	public void setUp() {
		account = mock(Account.class);
		user = mock(User.class);
	}
	
	@After
	public void tearDown() {
		account = null;
	}

	
	@Test
	public void test_mockito_Account_transactionId() {
		when(account.getTransactionId()).thenReturn(202221);
	int id = account.getTransactionId();
	assertEquals(id, 202221);
		
	}
	
	@Test
	public void test_mockito_Account_currency() {
		when(account.getCurrency()).thenReturn("EUR");
	String currency = account.getCurrency();
	assertEquals(currency, "EUR");
		
	}
	
	@Test
	public void test_mockito_Account_User() {
		User u = new User();
		when(account.getUser()).thenReturn(u);
	int id = account.getTransactionId();
	assertNotNull(u);
		
	}
	
	@Test
	public void test_mockito_User_userId() {
		when(user.getUserId()).thenReturn(289);
	int id = user.getUserId();
	assertEquals(id, 289);
		
	}
	
	@Test
	public void test_mockito_User_name() {
		when(user.getName()).thenReturn("Name");
	String name = user.getName();
	assertEquals(name, "Name");
		
	}
	
	@Test
	public void test_mockito_User_Account() {
		Account a = new Account();
		when(user.getAccount()).thenReturn(a);	
	assertNotNull(a);
		
	}


}

