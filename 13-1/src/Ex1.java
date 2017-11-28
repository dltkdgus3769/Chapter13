import java.util.Scanner;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 아무키 입력
		scanner.close();		
		Thread th = new Thread(new CountingThread());	
		th.start();
	}
}
class CountingThread implements Runnable {
	@Override
	public void run() { //스레드 실행 
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++) // 1~10 출력
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}