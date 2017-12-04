import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountBook2 {

	void AccountMenu() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while(num!=5 || num!=6) {
			System.out.print("[�����]\n1.����� �߰�\n2.������Ʈ\n3.����\n4.�ҷ�����\n5.���ư���\n5.�޴��ε��ư���\n6.����\n->");
			num = scan.nextInt();
			switch(num) {
			case 1 :
				CreateAccountBook();
				break;
			case 2 :
				UpdateAccountBook();
				break;
			case 3 :
				DeleteAccountBook();
				break;
			case 4 :
				ShowAccountBook();
				break;
			case 5 :
				System.out.print("���θ޴��� ���ư��ϴ�.\n");
				break;
			case 6 :
				System.out.print("�ý����� �����մϴ�.");
				System.exit(0);
				break;
			}
		}
	}

	void CreateAccountBookText() {
		try {
			FileOutputStream output = new FileOutputStream("accountbook.txt");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void CreateAccountBook(){
		Scanner scan = new Scanner(System.in);
		try {
			FileWriter output = new FileWriter("accountbook.txt", true);
			System.out.print("�߰��� ������ �Է����ּ��� : ");
			String accountbook = scan.nextLine();
			String data = accountbook + "\r\n";
			output.write(data);
			output.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}
	void UpdateAccountBook(){
		System.out.print("test2");
		System.out.println();
	}
	void DeleteAccountBook(){
		System.out.print("test3");
		System.out.println();
	}
	void ShowAccountBook(){
		System.out.print("test4");
		System.out.println();
		try {
			BufferedReader output = new BufferedReader(new FileReader("accountbook.txt"));
			while(true) {
				String accountbook = output.readLine();
				if (accountbook == null) break;
				System.out.println(accountbook);
			}
			output.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
