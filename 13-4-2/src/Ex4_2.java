import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex4_2 extends JFrame {
	private JLabel la = new JLabel("���� ���̺�"); //������Ʈ ����
	runnable thread;
	Thread th;
	Ex4_2() {
		this.setTitle("�����ϴ� ���̺� �����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thread = new runnable();
		th = new Thread(thread); //������ ��ü ����
		this.add(la);
		this.setVisible(true);
		this.setSize(500, 500);
		th.start(); //Ÿ�̸� ������ ���� ����
	}
	class runnable implements Runnable{
		public void run() {
			while(true) {
				try { //���̺� ����
					la.setLocation(20,10);
					Thread.sleep(1);
					la.setLocation(10,20);
					Thread.sleep(1);
					la.setLocation(10,10);
					Thread.sleep(1);
					la.setLocation(20,20);
					Thread.sleep(1);
				} 
				catch(InterruptedException e) {return;}
				}
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4_2();
	}

}
