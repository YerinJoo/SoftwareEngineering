import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sun.rmi.runtime.Log;

public class AccountBook2 {

	void AccountMenu() {
		System.out.println("..�ڵ���..");
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
			System.out.print("�߰��� ������ �Է����ּ���(�̸� ��¥ ���� ������) : ");
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
		
		Scanner scan = new Scanner(System.in);
		System.out.print("update�� ���� �Է��ϼ���: ");
		String a = scan.nextLine();
		System.out.print("update�� ������ �Է��ϼ���: ");
		String b = scan.nextLine();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("accountbook.txt"));
		
			String kword = null;
			String eword = null;
			
			while((eword = in.readLine())!=null) {				
				if(eword.contains(a)) {	
					kword = eword;
			
				}
			}
		
		if(kword == null)
			System.out.println(a+" �� ��ġ�ϴ� ����δ� �����ϴ�.");
		else
			System.out.println(kword + " �׸��� ã�ҽ��ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	void DeleteAccountBook(){
		
		String line;
		String kword = null;

		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("������ ������ �Է��ϼ��� : ");
			String del = scan.nextLine();
			
			BufferedReader br = new BufferedReader(new FileReader("accountbook.txt"));
			File file = new File("re_accountbook.txt");
			
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while((line=br.readLine())!=null) {
				if(!line.contains(del)) {
					bw.write(line);
					bw.write("\n");
				}
				else
					kword = del;
				bw.flush();
			}
			if(kword == null)
				System.out.println(del+" ��(��) ��ġ�ϴ� ���� �����ϴ�. �ٽ� �Է����ּ���.");
			
			FileInputStream fis = new FileInputStream("re_accountbook.txt");
			FileOutputStream fos = new FileOutputStream("accountbook.txt");
			   
			   int data = 0;
			   while((data=fis.read())!=-1) {
			    fos.write(data);
			   }
			   fis.close();
			   fos.close();

			
			bw.close();
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

			
	}
	void ShowAccountBook(){
		try {
			BufferedReader output = new BufferedReader(new FileReader("accountbook.txt"));
			while(true) {
				String accountbook = output.readLine();
				if (accountbook == null) 
					break;
				System.out.println(accountbook);
			}
			output.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
