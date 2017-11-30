import java.util.Scanner;
import java.util.*;

public class AccountBook {

	public static void main(String[] args) {
		AccountBook2 account = new AccountBook2();
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while(num!=4) {
		System.out.print("[MENU]\n3.가계부\n4.종료\n->");
		num = scan.nextInt();
		switch(num) {
		case 3 :
			account.AccountMenu();
			break;
		case 4 :
			System.out.print("시스템을 종료합니다.");
			break;
		}
		}
	}

}
