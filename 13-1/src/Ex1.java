import java.util.Scanner;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); // �ƹ�Ű �Է�
		scanner.close();		
		Thread th = new Thread(new CountingThread());	
		th.start();
	}
}
class CountingThread implements Runnable {
	@Override
	public void run() { //������ ���� 
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++) // 1~10 ���
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}