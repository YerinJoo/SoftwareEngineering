import java.io.IOException;
import java.util.*;

public class SimpleProgram {
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		MemoMenu Memo = new MemoMenu();
		
		
		while(true){
			System.out.println("심플 프로그램입니다. 1.메모장 2.계산기 3.가계부 4.종료");
			System.out.print("원하시는 작업을 선택해주세요 >> ");
			
			int ans = scanner.nextInt();
			if(ans==4) {
				System.out.println("프로그램을 종료합니다.");
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