import java.io.IOException;
import java.util.*;

public class SimpleProgram {
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		MemoMenu Memo = new MemoMenu();
		
		
		while(true){
			System.out.println("���� ���α׷��Դϴ�. 1.�޸��� 2.���� 3.����� 4.����");
			System.out.print("���Ͻô� �۾��� �������ּ��� >> ");
			
			int ans = scanner.nextInt();
			if(ans==4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			switch(ans){
			case 1: //memo manager
				Memo.menu();
				break;
			case 2: //calculator
				break;
			case 3: //account book 
				break;
			}
		}
		scanner.close();
	}
}