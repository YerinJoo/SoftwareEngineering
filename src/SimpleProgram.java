import java.io.*;
import java.util.*;


public class SimpleProgram {
	
	class Memo {
		// //////////////완 성 아 님 ///////////////////////////////
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
			
			System.out.print("수정할 메모 내용을 입력ㄱ : ");
			
			source=sc.nextLine();
			//파일명 일치여부 추가필요
			char input[] = new char[source.length()];
			source.getChars(0, source.length(), input, 0);
			FileWriter fw = new FileWriter(realtitle);
			fw.write(input);
			fw.close();
			System.out.print(title + "파일이 수정되었습니다\n\n");
			
		}
		
		void openMemo(String title) throws IOException{
			Scanner sc = new Scanner(System.in);
			String realtitle=title+".txt";
			String source = "";
			//완성아님완성아님완성아님
			FileReader fr = new FileReader(realtitle);
			int i;
			
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
				
				//메모 목록추가 필요!
	
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
					System.out.print("열고 싶은 메모 파일명: ");
				    title = sc.next();
					ddd.openMemo(title);
					break;
					
				case 5:
					
				//	System.exit(0);
					break;
				}
			}while(sel != 5);
			
		}
		
	static class Calculator {
		StringTokenizer tokenizer;
		String token;
		
		public Calculator(String line) {
			tokenizer = new StringTokenizer(line);
			token = tokenizer.nextToken();
		}

		public double Evaluate() {  
	        return Expression();  
	    }  
	     
	    private double Primary() {  
	        double result;  
	        if(token.equals("")) {  
	            token = tokenizer.nextToken();  
	            result = Expression();  
	        }  
	        else result = Double.valueOf(token).doubleValue();
	        
	        token = tokenizer.nextToken();  
	        return result;  
	    }  
	     
	    private double Term() {  
	        double nextValue;  
	        double result;
	        result = Primary();  
	        while(token.equals("*")) {  
	            token = tokenizer.nextToken();  
	            nextValue = Primary();  
	            result *= nextValue;  
	        }  
	        while(token.equals("/")) {  
	            token = tokenizer.nextToken();  
	            nextValue = Primary();  
	            result /= nextValue;  
	        }    
	        return result; 
	    }  
	     
	    private double Expression() {  
	        double nextValue;  
	        double result;  
	        result = Term();  
	        while(token.equals("+")) {            
	            token = tokenizer.nextToken();  
	            nextValue = Term();  
	            result += nextValue;  
	        }  
	        while(token.equals("-")) {  
	            token = tokenizer.nextToken();  
	            nextValue = Term();  
	            result -= nextValue;  
	        }  
	        return result;  
	     }
	   
	}//class Calculator end
	
	class UnitConverter {
	    private String[] unitList = { "inch", "cm", "lb", "kg", "F", "C" };
	    private double[] rateList = { 1, 2.54, 0.39, 2.2, 0.45, 0, 0};//F-C
	    private HashMap<String, Double> Convert = new HashMap<String, Double>();

	    private String convert(String in1, String in2, String in3) {
	        double input = Double.valueOf(in1);
	        double unitValue, convertValue;
	        if(Convert.containsKey(in2) && Convert.containsKey(in3)){
	            unitValue = Convert.get(in2);
	            convertValue = Convert.get(in3);
	        }else{
	            return "No such unit in the registered list.";
	        }
	        return (int)(input / unitValue * convertValue) + " " + in3;
	    }
	}//class UnitConverter end
	
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);

		SimpleProgram SP = new SimpleProgram();
		
		System.out.println("심플 프로그램입니다. 1.메모장 2.계산기 3.가계부 4.종료");
		System.out.print("원하시는 작업을 선택해주세요 >> ");

		while(true){
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
				break;
			case 3: //account book 
				break;
			}
		}
		scanner.close();
	}
}