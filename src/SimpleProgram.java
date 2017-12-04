import java.util.*;

public class SimpleProgram {
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
	    
	    public static void start(){
			Scanner scanner = new Scanner(System.in);
			String line;
			System.out.print("원하시는 작업을 선택하세요: 1. 사칙연산 2. 단위변환\n>> ");
			int ans = scanner.nextInt();
			if(ans==1) {
				System.out.print("식 입력: ");  
	            line = scanner.nextLine();
	            Calculator expn = new Calculator(line);  
	            System.out.println("결과 값: " + expn.Evaluate());
			}
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
	
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
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
