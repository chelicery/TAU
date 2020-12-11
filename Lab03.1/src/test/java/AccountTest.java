import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.*;
import org.junit.rules.TemporaryFolder;


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
	@Test
	public void testBalance()  {
		acc.setBalance(200);		
		int result = acc.getBalance();		
		assertEquals(200, result);		
	}
	@Test
	public void testDeposit1() throws IOException {
		acc.setBalance(200);
		acc.deposit(250,false);
		int result = acc.getBalance();		
		assertEquals(450, result);		
	}
	@Test
	public void testDeposit2() throws IOException {
		acc.setBalance(100);
		acc.deposit(150,true);
		int result = acc.getBalance();		
		assertEquals(250, result);		
	}
	@Test
	public void testDeposit3() throws IOException {		
		acc.deposit(150,true);
		int result = acc.getBalance();		
		assertEquals(150, result);		
	}
	
    @Test
    public void receiptIdTestFromDepositFunction() throws IOException{
    	int resultBefore = acc.getReceiptId();
    	assertEquals(0,resultBefore);
        acc.deposit(200, true);
        int result = acc.getReceiptId();
        assertEquals(1,result);
    }
	
    @Test
    public void receiptIdTestFromDepositFunctionWithoutReceipt() throws IOException{
    	int resultBefore = acc.getReceiptId();
    	assertEquals(0,resultBefore);
        acc.deposit(200, false);
        int result = acc.getReceiptId();
        assertEquals(0,result);
    }
    @Test
    public void receiptIdTest() throws IOException{
    	int resultBefore = acc.getReceiptId();
    	assertEquals(0,resultBefore);
        acc.generateReceipt(200, 500);
        int result = acc.getReceiptId();
        assertEquals(1,result);
    }

//	@Test	
//	 public void pdfTest() throws IOException{
//		PDDocument pdf = PDDocument.load(content);
//	    PDFTextStripper stripper = new PDFTextStripper();
//	    stripper.setAddMoreFormatting(true);
//	    stripper.setSortByPosition(true);
//	    stripper.setStartPage(0);
//	    stripper.setEndPage(pdf.getNumberOfPages());
//	    String plainText = stripper.getText(pdf);
//	    pdf.close();
//
//	    assertThat(plainText).isEqualTo(expected);
//    }
//    
    
    
	
	

	
	
}
