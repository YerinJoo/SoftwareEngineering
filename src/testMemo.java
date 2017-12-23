
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;



public class testMemo{
	
	SimpleProgram sp = new SimpleProgram();
	
	SimpleProgram.Memo memo = new SimpleProgram.Memo();
	String title = "hello";
	
	@Test
	public void testCreate() throws IOException{
		memo.createMemo(title);
		
		assertTrue(memo.isExistMemo(title));
	}
	
	@Test
	public void testDelete() throws IOException{
		memo.deleteMemo(title);
		assertFalse(memo.isExistMemo(title));

	}
	
}