import java.io.IOException;
import java.math.BigDecimal;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



public class Account {

	private int accountId;
	private int transactionId;
	private User user;
	private String currency;
	private int balance;
	private int receiptId;
	public User getUser() {
		return user;
	}
	

	public void setUser(User user) {
		this.user = user;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getReceiptId() {
		return receiptId;
		
	}
	public void withdraw(int value) {
		if (value > this.balance) {
			
		} else if(value%10 != 0) {
			throw new ArithmeticException();
		}		
		else {
			this.balance = balance - value;
		}	
	}
	public String deposit(int value, boolean receipt) throws IOException {
		this.balance += value;
		if(receipt) {
			this.generateReceipt(value, this.balance);
		}
		return "Your balance is: " + this.balance;
	}
	
	@SuppressWarnings("deprecation")
	public void generateReceipt(int value, int balance) throws IOException {		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );
		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;
		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		contentStream.moveTextPositionByAmount( 100, 700 );
		contentStream.drawString( "Succesfully deposit founds " + value + " your current balance: " + this.balance);
		contentStream.endText();
		// Make sure that the content stream is closed:
		contentStream.close();
		receiptId += 1;
		// Save the results and ensure that the document is properly closed:
		document.save( "receipt"+receiptId+".pdf");		
		document.close();		
		}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	}

