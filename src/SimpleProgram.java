import java.io.*;
import java.util.*;



public class SimpleProgram {
	
	
	class Memo {
		// //////////////�� �� �� �� ///////////////////////////////
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
			
			System.out.print("������ �޸� ������ �Է¤� : ");
			
			source=sc.nextLine();
			//���ϸ� ��ġ���� �߰��ʿ�
			char input[] = new char[source.length()];
			source.getChars(0, source.length(), input, 0);
			FileWriter fw = new FileWriter(realtitle);
			fw.write(input);
			fw.close();
			System.out.print(title + "������ �����Ǿ����ϴ�\n\n");
			
		}
		
		void openMemo(String title) throws IOException{
			Scanner sc = new Scanner(System.in);
			String realtitle=title+".txt";
			String source = "";
			//�ϼ��ƴԿϼ��ƴԿϼ��ƴ�
			FileReader fr = new FileReader(realtitle);
			int i;
			
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
				
				//�޸� ����߰� �ʿ�!
	
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
					System.out.print("���� ���� �޸� ���ϸ�: ");
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