import java.util.Scanner;
import java.io.*;

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

class MemoMenu{
	void menu() throws IOException{
		Scanner sc = new Scanner(System.in);
	
		int sel=0;
		String title="";
		Memo ddd = new Memo();
		
		do{
			System.out.println("\n�� ���� �޸� ������ �� �ִ� �޸����Դϴ�. �޸� ������ txt ���Ϸ� ����˴ϴ�. ");
			System.out.print("1.�޸��߰�\n2.�޸����\n3.�޸����\n4.�޸𺸱�\n5.���� �޴��� ���ư���\n");
			sel = sc.nextInt();
	
			//�޸����߰�����������

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
}