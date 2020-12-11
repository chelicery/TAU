import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Account acc1 = new Account();
		
		acc1.setBalance(500);
		try {
			acc1.deposit(200,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
