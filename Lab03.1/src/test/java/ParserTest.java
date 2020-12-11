import static org.junit.Assert.*;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	Parser parser;
	@Before
	public void setUp() {
		parser = new Parser();	
	}
	
	@After
	public void tearDown() {
		parser = null;
	}
	
	
	@Test
	public void test_new_parser() {
		assertNotNull(parser);		
	}
	
	@Test
	public void test_parser_create_currencies_object() {
		Currencies curr = parser.parseCurrencies();
		assertNotNull(curr);		
	}
	
	@Test
	public void test_parser_create_currencies_object_array() {
		Currency[] curr = parser.parseCurrencies().currency;
		assertNotNull(curr);		
	}
	
	@Test
	public void test_parser_currencies_to_string() {
		Currencies curr = parser.parseCurrencies();
		String result = curr.toString();
		System.out.println(result);
		assertEquals("Currencies{currencies=[Currency{id='curr0001', targetCurrency='EUR', "
				+ "rate='4.42'}, Currency{id='curr0002', targetCurrency='GBP', rate='4.89'}, "
				+ "Currency{id='curr0003', targetCurrency='CHF', rate='4.11'}, Currency{id='curr0001', "
				+ "targetCurrency='USD', rate='3.65'}]}" + 
				"",result);
	}




}
