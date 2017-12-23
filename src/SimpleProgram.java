import java.util.*;

public class SimpleProgram {
	Scanner scan = new Scanner(System.in);
	class Calculator {
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
	}//class Caculator closed
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		System.out.println("심플 프로그램입니다. 1.메모장 2.계산기 3.가계부 4.종료");
		System.out.print("원하시는 작업을 선택하세요 >> ");
		while(true){
			int ans = scanner.nextInt();
			if(ans==4) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			
			SimpleProgram sp = new SimpleProgram();
			SimpleProgram.Calculator ca = sp.new Calculator();
			
			switch(ans){
			case 1: //memo manager
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
