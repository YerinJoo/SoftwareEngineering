import java.util.*;

public class SimpleProgram {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ���α׷��Դϴ�. 1.�޸��� 2.���� 3.����� 4.����");
		System.out.print("���Ͻô� �۾��� �������ּ��� >> ");
		while(true){
			int ans = scanner.nextInt();
			if(ans==4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			switch(ans){
			case 1: //memo manager
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
