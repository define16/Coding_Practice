package etc;
import java.util.Scanner;

// 3개월
// 기본 문법은 1달안에 끝내야함 - 자료형, String, 조건문, 반복문, 배열  -> try-catch-finally, 제네릭, 자료구조 사용법, 외부라이브러리 사용법 (초급개발자)
// Spring 웹, 안드로이드  || 서버개발자가 될것인가 
// 프론트엔드(수명이 짧음), 백엔드(웹 서버) (김) -> 시스템 개발자 or 데이터사이언티스트, 데이터베이스관리자 dba, 
// linux, java, network, os, 자료구조 및 알고리즘 -> 초급개발자 -> 실무경험 + 개발경험(메모리관리, 이슈해결능력, 알고리즘, 컴퓨터 지식) -> 중급개발자(부족)
public class example1 {
	// 메인 메소드 - 필수! 프로그램의 시작점 딱 한개가 잇어야한다. 1개의 클래스에 최대 1개까지!
	public static void main(String args[]) {
		// 클래스명
		Scanner cmd = new Scanner(System.in); // 콘솔창으로 부터 값을 입력 받을 수 있게 하는 객체
		int cmd_num = 0;
		// q와 Q의 아스키코드는 113, 81이다.
		while (cmd_num != 81 && cmd_num != 113) {
			System.out.println("===========================================");
			System.out.println("보고 싶은 예제의 출력값의 번호를 입력해라");
			System.out.println("1: if문 (조건문)");
			System.out.println("2: switch문 (조건문)");
			System.out.println("3: for문 (반복문)");
			System.out.println("4: while문 (반복문)");
			System.out.println("q: 종료");
			System.out.println("===========================================");
			System.out.print("숫자 입력 : ");
			String tmp = cmd.nextLine().trim(); // 문자열을 입력하면 받아주는 메소드
			// int cmd_num = cmd.nextInt();
			// try-catch 는 예외처리하는 기법이다. 아직 신경쓰지말것
			try {
				cmd_num = Integer.parseInt(tmp);
				// ㄴㅇㄹㄴㅇㄹㄴㅇㄹ() - 메소드임
				switch (cmd_num) {
				case 1:
					ex_if(cmd); // if 문 예시
					System.out.println("예제 종료");
					break; // 스톱!
				case 2:
					ex_switch(cmd); // switch 문 예시
					System.out.println("예제 종료");
					break;
				case 3:
					ex_for(cmd); // for 문 예시
					System.out.println("예제 종료");
					break;
				case 4:
					ex_while(cmd); // while 문 예시
					System.out.println("예제 종료");
					break;
				default:
					System.err.println("[내가 정한 숫자 문자 이외에 입력하지마라]");
				}
			} catch (NumberFormatException e) {
				if (tmp.length() < 2) {
					cmd_num = tmp.charAt(0);
					if ((cmd_num != 81 && cmd_num != 113) == true) {
						System.err.println("숫자 넣으라고 새꺄");
					}
				}
			}
		}

		System.out.println("[수고했다. 찌익]");
	}

	// 한 메소드에는 하나의 기능만 존재한다.
	public static void ex_if(Scanner cmd) throws NumberFormatException {
		// if문 예시
		int a = 0;
		if (a == 0) {
			System.out.println("i의 값은 0이다.");
		}
		System.out.print("숫자 입력 : ");
		String tmp = cmd.nextLine().trim();
		a = Integer.parseInt(tmp);
		System.out.println("------ 출력 결과 ------");
		if (a == 0) {
			System.out.println("a의 값은 0이다.");
		} else if (a > 100) {
			System.out.println("100보다 큰수를 넣었군 100보다 작은 수로 넣어봐");
		} else {
			System.out.println("a에 " + a + " 값을 넣었군");
		}
		System.out.println("----------------------");

	}

	public static void ex_switch(Scanner cmd) throws NumberFormatException {
		System.out.println("0 입력시 \"0번 로직 시작\", 1 입력시 \"1번 로직 시작\", 그 이외의 숫자 입력시 \"다음 로직은 없어\" 를 출력");
		System.out.print("숫자 입력 : ");
		String tmp = cmd.nextLine().trim();
		int b = Integer.parseInt(tmp);

		System.out.println("------ 출력 결과 ------");
		// switch 문 예시
		switch (b) {
		case 0:
			System.out.println("0번 로직 시작");
			break;
		case 1:
			System.out.println("1번 로직 시작");
			break;
		default:
			System.out.println("다음 로직은 없어");
			break;
		}
		System.out.println("----------------------");

	}

	public static void ex_for(Scanner cmd) throws NumberFormatException {
		int c = 0;
		int sum = 0;
		String meg = "";
		System.out.println("입력한 숫자만큼 더한 후 출력");
		System.out.print("숫자 입력 : ");
		String tmp = cmd.nextLine().trim();
		c = Integer.parseInt(tmp);

		System.out.println("------ 출력 결과 ------");
		for (int i = 1; i <= c; i++) {
			sum += i;
			if (i != c)
				meg += String.valueOf(i) + " + ";
			else
				meg += String.valueOf(i) + " = ";
		}
		System.out.println(meg + sum);
		System.out.println("----------------------");
	}

	public static void ex_while(Scanner cmd) throws NumberFormatException {
		int d = 0;
		System.out.println("입력한 초 뒤에 예제 종료");
		System.out.print("숫자 입력 : ");
		String tmp = cmd.nextLine().trim();
		d = Integer.parseInt(tmp);
		System.out.println("------ 출력 결과 ------");
		try {
			int t = 0;
			while (t < d) {
				t++;
				Thread.sleep(1000); // 1000 -> 1 초
				System.out.println(t + "초 경과");
			}
			System.out.println("----------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
