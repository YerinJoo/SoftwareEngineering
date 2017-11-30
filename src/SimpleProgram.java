import java.util.*;

public class SimpleProgram {

class Calculator {
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
