import java.util.Scanner;
import java.io.*;

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

class MemoMenu{
	void menu() throws IOException{
		Scanner sc = new Scanner(System.in);
	
		int sel=0;
		String title="";
		Memo ddd = new Memo();
		
		do{
			System.out.println("\n한 줄의 메모를 저장할 수 있는 메모장입니다. 메모 파일은 txt 파일로 저장됩니다. ");
			System.out.print("1.메모추가\n2.메모삭제\n3.메모수정\n4.메모보기\n5.메인 메뉴로 돌아가기\n");
			sel = sc.nextInt();
	
			//메모목록추가ㅏㅏㅏㅏㅏ

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
}