import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class Filetest {

SimpleProgram sp = new SimpleProgram();
	
	AccountBook2 account = new AccountBook2();
	String title = "test";
	String title2 = "test2";
	
	@Test
	public void testCreate() throws IOException{
		account.CreateAccountBookText(title);
		assertTrue(account.isExistbook(title));
	}
	
	@Test
	public void testDelete() throws IOException{
		account.DeleteAccountBook(title);
		assertTrue(account.isExistbook(title));

	}

}
