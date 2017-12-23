import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;

public class AccountBook2 {
	
	String title = "accountbook.txt";
	String title2 = "re_accountbook.txt";

	void AccountMenu() {
		System.out.println("..코딩중..");
		Scanner scan = new Scanner(System.in);
		int num = 0;
		while(num!=5 || num!=6) {
			System.out.print("[가계부]\n1.가계부 추가\n2.업데이트\n3.삭제\n4.불러오기\n5.돌아가기\n5.메뉴로돌아가기\n6.종료\n->");
			num = scan.nextInt();
			switch(num) {
			case 1 :
				CreateAccountBook();
				break;
			case 2 :
				UpdateAccountBook();
				break;
			case 3 :
				DeleteAccountBook(title2);
				break;
			case 4 :
				ShowAccountBook();
				break;
			case 5 :
				System.out.print("메인메뉴로 돌아갑니다.\n");
				break;
			case 6 :
				System.out.print("시스템을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	void CreateAccountBookText(String title) {
		try {
			FileOutputStream output = new FileOutputStream(title);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void CreateAccountBook(){
		Scanner scan = new Scanner(System.in);
		try {
			FileWriter output = new FileWriter("accountbook.txt", true);
			System.out.print("추가할 내용을 입력해주세요(이름 날짜 가격 순으로) : ");
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
		
		String line;
		String kword = null;
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("update할 것을 입력하세요: ");
			String a = scan.nextLine();
			System.out.print("update 내용을 입력하세요(물건 날짜 가격 순으로 입력): ");
			String b = scan.nextLine();
			
			BufferedReader br = new BufferedReader(new FileReader("accountbook.txt"));
			File file = new File("up_accountbook.txt");
			
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while((line=br.readLine())!=null) {
				if(!line.contains(a)) {
					bw.write(line);
					bw.write("\n");
				}
				else
					kword = a;
				bw.flush();
			}
			if(kword == null)
				System.out.println(a+" 과(와) 일치하는 것은 없습니다. 다시 입력해주세요.");
			
			FileInputStream fis = new FileInputStream("up_accountbook.txt");
			FileOutputStream fos = new FileOutputStream("accountbook.txt");
			   
			   int data = 0;
			   while((data=fis.read())!=-1) {
			    fos.write(data);
			   }
			   fis.close();
			   fos.close();

			FileWriter output = new FileWriter("accountbook.txt", true);
			String data2 = b+ "\r\n";
			output.write(data2);
			output.close();
			   
			bw.close();
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	void DeleteAccountBook(String title){
		
		String line;
		String kword = null;

		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 물건을 입력하세요 : ");
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
				System.out.println(del+" 과(와) 일치하는 것은 없습니다. 다시 입력해주세요.");
			
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

	public boolean isExistbook(String title) {
		File path = new File(".");
		final String ext = ".txt";
		
		String fileList[] = path.list(new FilenameFilter(){
			public boolean accept(File dir, String name){
				
				return name.endsWith(ext);
			}
		});
		
		File file = new File(path+"\\"+title+".txt");

		if(file.exists())
			return true;
		else
			return false;
	}

}
