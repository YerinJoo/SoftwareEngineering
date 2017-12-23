import java.io.*;
import org.junit.*;
import  org.junit.Assert.*; 
import java.util.*;

public class SimpleProgram {
	static class Memo {
		void createMemo(String title) throws IOException{
			Scanner sc = new Scanner(System.in);
			String source = "";
			String realtitle=title+".txt";
			
			System.out.print("�޸� ������ �Է¤� : ");
			source=sc.nextLine();
			
			char input[] = new char[source.length()];
			source.getChars(0, source.length(), input, 0);
			FileWriter fw = new FileWriter(realtitle);
			fw.write(input);
			fw.close();
			System.out.print(title + " ������ �����Ǿ����ϴ�\n\n");

		}
		
		Boolean isExistMemo(String title){
			File path = new File("C:\\Users\\ggg\\workspace\\swe1");
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
		
		void deleteMemo(String title){
		    Scanner scan = new Scanner(System.in);
		    String realtitle=title+".txt";
			
		    File f = new File(realtitle);
	
		    if (f.delete()) {
		      System.out.println("���� �Ǵ� ���丮�� ���������� �������ϴ�: " + title + "\n\n");
			

		    } else {
		      System.err.println("���� �Ǵ� ���丮 ����� ����: " + title);
		    }
		}
		
		void updateMemo(String title) throws IOException{
			Scanner sc = new Scanner(System.in);
			String realtitle=title+".txt";
			String source = "";
			
			File path = new File("C:\\Users\\ggg\\workspace\\swe1");
			final String ext = ".txt";
			
			String fileList[] = path.list(new FilenameFilter(){
				public boolean accept(File dir, String name){
					
					return name.endsWith(ext);
				}
			});
			
			
			if(fileList.length > 0){				
				for(int j=0; j < fileList.length; j++){
					if(realtitle.equals(fileList[j])){
						System.out.print("������ �޸� ������ �Է¤� : ");
						source=sc.nextLine();
						char input[] = new char[source.length()];
						source.getChars(0, source.length(), input, 0);
						FileWriter fw = new FileWriter(realtitle);
						fw.write(input);
						fw.close();
						System.out.print(title + "������ �����Ǿ����ϴ�\n\n");
						break;
					}
					else{
						System.out.println("��ġ�ϴ� ������ �����ϴ�.");
						break;
					}
						
				}
			}
		}
		
		void openMemo() throws IOException{
			Scanner sc = new Scanner(System.in);
			String title="";
			
			int i;
			
			File path = new File("C:\\Users\\ggg\\workspace\\swe1");
			final String ext = ".txt";
			
			String fileList[] = path.list(new FilenameFilter(){
				public boolean accept(File dir, String name){
					
					return name.endsWith(ext);
				}
			});
			
			System.out.println("< ���� ���� ��� >");
			if(fileList.length > 0){				
				for(int j=0; j < fileList.length; j++){
					System.out.println(fileList[j]);
				}
			}
			

			System.out.print("���� ���� �޸� ���ϸ�: ");
		    title = sc.next();
		    
		    String realtitle=title+".txt";
			String source = "";
			FileReader fr = new FileReader(realtitle);
			
			System.out.print("\n���ϸ� : " + realtitle + "\n�޸� ���� : ");
			
			while((i=fr.read()) != -1)
				System.out.print((char)i);
			
			System.out.println("\n");
			
			fr.close();	
		}	
	}
	
		void memomenu() throws IOException{
			Scanner sc = new Scanner(System.in);
		
			int sel=0;
			String title="";
			Memo ddd = new Memo();
			
			do{
				System.out.println("\n�� ���� �޸� ������ �� �ִ� �޸����Դϴ�. �޸� ������ txt ���Ϸ� ����˴ϴ�. ");
				System.out.print("1.�޸��߰�\n2.�޸����\n3.�޸����\n4.�޸𺸱�\n5.���� �޴��� ���ư���\n");
				sel = sc.nextInt();
	
				switch(sel){
				case 1:
					System.out.print("�߰��� ���ϸ�: ");
					title = sc.next();
					ddd.createMemo(title);
					break;
					
				case 2:
					System.out.print("���� ���ϸ�: ");
				    title = sc.next();
					ddd.deleteMemo(title);
					break;
					
				case 3:
					System.out.print("������ ���ϸ�: ");
				    title = sc.next();
					ddd.updateMemo(title);
					break;
					
				case 4:	
					
					ddd.openMemo();
					break;
					
				case 5:
					
				//	System.exit(0);
					break;
				}
			}while(sel != 5);
			
		} // class Memo end
		
		
		static class Calculator {
			Scanner scan = new Scanner(System.in);
			void menu() {
				
				System.out.print("[���� �޴�]\n1. ��Ģ���� 2. ������ȯ\n���Ͻô� ����� �����ϼ���>> ");
				int ch = scan.nextInt();
				if(ch==1) {
					double op1, op2;
					String opt;
					while(true){
					System.out.println("[��Ģ���� �޴�]");
					System.out.print("����1>> ");
					op1 = scan.nextDouble();
					System.out.print("*, /, -, + >> ");
					opt = scan.next();
					System.out.print("����2>> ");
					op2 = scan.nextDouble();
					System.out.println("�����: " + calc(op1, op2, opt));
					}
				}
				if(ch==2) {unit();}
			}
			
			double calc(double op1, double op2, String opt) {
				double result=0;
				
				if(opt.equals("*"))
					result = op1 * op2;
				else if(opt.equals("/"))
					result = op1 / op2;
				else if(opt.equals("-"))
					result = op1 - op2;
				else if(opt.equals("+"))
					result = op1 + op2;
				
				return result;
			}
			
			void unit() {
				double inch, cm, lb, kg, F, C;
				int conv;
				while(true) {
					System.out.println("[������ȯ �޴�]");
					System.out.println("1. inch->cm 2. cm->inch 3. lb->kg 4. kg->lb");
					System.out.println("5. F->C 6. C->F 7. ���� �޴��� ���ư��� 8. �����ϱ�");
					System.out.print("���Ͻô� ����� �����ϼ���>> ");
					conv = scan.nextInt();
					switch(conv){
					case 1:
						System.out.print("inch>> ");
						inch = scan.nextDouble();
						System.out.println("�����: " + 2.54*inch + "cm");
						break;
					case 2:
						System.out.print("cm>> ");
						cm = scan.nextDouble();
						System.out.println("�����: " + 0.39*cm + "inch");
						break;
					case 3:
						System.out.print("lb>> ");
						lb = scan.nextDouble();
						System.out.println("�����: " + 0.45*lb + "kg");
						break;
					case 4:
						System.out.print("kg>> ");
						kg = scan.nextDouble();
						System.out.println("�����: " + 2.2*kg + "lb");
						break;
					case 5:
						System.out.print("F>> ");
						F = scan.nextDouble();
						System.out.println("�����: " + (F-32)*5/9 + "C");
						break;
					case 6:
						System.out.print("C>> ");
						C = scan.nextDouble();
						System.out.println("�����: " + (9*C/5)+32 + "F");
						break;
					case 7:
						menu();
						break;
					case 8:
						System.out.println("���α׷��� �����մϴ�");
						System.exit(0);
					}
				}
			}
<<<<<<< HEAD
			
			
		}
public static void main(String args[]) throws IOException{
=======
		}
	public static void main(String args[]) throws IOException{
>>>>>>> 604ed0401bdd4c32c0f8089658115a9f80896ca2
				Scanner scanner = new Scanner(System.in);

				SimpleProgram SP = new SimpleProgram();
				SimpleProgram.Calculator ca = new SimpleProgram.Calculator();
				
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
						SP.memomenu();
						break;
					case 2: //calculator
						ca.menu();
						break;
					case 3: //account book 
						break;
					}
				}
				scanner.close();
			}
<<<<<<< HEAD
}
=======
}
>>>>>>> 604ed0401bdd4c32c0f8089658115a9f80896ca2
