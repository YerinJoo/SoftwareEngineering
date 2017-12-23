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
			
			System.out.print("메모 내용을 입력ㄱ : ");
			source=sc.nextLine();
			
			char input[] = new char[source.length()];
			source.getChars(0, source.length(), input, 0);
			FileWriter fw = new FileWriter(realtitle);
			fw.write(input);
			fw.close();
			System.out.print(title + " 파일이 생성되었습니다\n\n");

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
		      System.out.println("파일 또는 디렉토리를 성공적으로 지웠습니다: " + title + "\n\n");
			

		    } else {
		      System.err.println("파일 또는 디렉토리 지우기 실패: " + title);
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
						System.out.print("수정할 메모 내용을 입력ㄱ : ");
						source=sc.nextLine();
						char input[] = new char[source.length()];
						source.getChars(0, source.length(), input, 0);
						FileWriter fw = new FileWriter(realtitle);
						fw.write(input);
						fw.close();
						System.out.print(title + "파일이 수정되었습니다\n\n");
						break;
					}
					else{
						System.out.println("일치하는 파일이 없습니다.");
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
			
			System.out.println("< 현재 파일 목록 >");
			if(fileList.length > 0){				
				for(int j=0; j < fileList.length; j++){
					System.out.println(fileList[j]);
				}
			}
			

			System.out.print("열고 싶은 메모 파일명: ");
		    title = sc.next();
		    
		    String realtitle=title+".txt";
			String source = "";
			FileReader fr = new FileReader(realtitle);
			
			System.out.print("\n파일명 : " + realtitle + "\n메모 내용 : ");
			
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
				System.out.println("\n한 줄의 메모를 저장할 수 있는 메모장입니다. 메모 파일은 txt 파일로 저장됩니다. ");
				System.out.print("1.메모추가\n2.메모삭제\n3.메모수정\n4.메모보기\n5.메인 메뉴로 돌아가기\n");
				sel = sc.nextInt();
	
				switch(sel){
				case 1:
					System.out.print("추가할 파일명: ");
					title = sc.next();
					ddd.createMemo(title);
					break;
					
				case 2:
					System.out.print("지울 파일명: ");
				    title = sc.next();
					ddd.deleteMemo(title);
					break;
					
				case 3:
					System.out.print("수정할 파일명: ");
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
				
				System.out.print("[계산기 메뉴]\n1. 사칙연산 2. 단위변환\n원하시는 기능을 선택하세요>> ");
				int ch = scan.nextInt();
				if(ch==1) {
					double op1, op2;
					String opt;
					while(true){
					System.out.println("[사칙연산 메뉴]");
					System.out.print("숫자1>> ");
					op1 = scan.nextDouble();
					System.out.print("*, /, -, + >> ");
					opt = scan.next();
					System.out.print("숫자2>> ");
					op2 = scan.nextDouble();
					System.out.println("결과값: " + calc(op1, op2, opt));
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
					System.out.println("[단위변환 메뉴]");
					System.out.println("1. inch->cm 2. cm->inch 3. lb->kg 4. kg->lb");
					System.out.println("5. F->C 6. C->F 7. 이전 메뉴로 돌아가기 8. 종료하기");
					System.out.print("원하시는 기능을 선택하세요>> ");
					conv = scan.nextInt();
					switch(conv){
					case 1:
						System.out.print("inch>> ");
						inch = scan.nextDouble();
						System.out.println("결과값: " + 2.54*inch + "cm");
						break;
					case 2:
						System.out.print("cm>> ");
						cm = scan.nextDouble();
						System.out.println("결과값: " + 0.39*cm + "inch");
						break;
					case 3:
						System.out.print("lb>> ");
						lb = scan.nextDouble();
						System.out.println("결과값: " + 0.45*lb + "kg");
						break;
					case 4:
						System.out.print("kg>> ");
						kg = scan.nextDouble();
						System.out.println("결과값: " + 2.2*kg + "lb");
						break;
					case 5:
						System.out.print("F>> ");
						F = scan.nextDouble();
						System.out.println("결과값: " + (F-32)*5/9 + "C");
						break;
					case 6:
						System.out.print("C>> ");
						C = scan.nextDouble();
						System.out.println("결과값: " + (9*C/5)+32 + "F");
						break;
					case 7:
						menu();
						break;
					case 8:
						System.out.println("프로그램을 종료합니다");
						System.exit(0);
					}
				}
			}	
		}
public static void main(String args[]) throws IOException{
	public static void main(String args[]) throws IOException{
				Scanner scanner = new Scanner(System.in);

				SimpleProgram SP = new SimpleProgram();
				SimpleProgram.Calculator ca = new SimpleProgram.Calculator();
				
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
}
