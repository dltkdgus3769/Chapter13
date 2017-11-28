import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex2 extends JFrame {	
	public Ex2() {
		this.setTitle("���� 0.5�� �������� ������.");
		this.setContentPane(new DrawingPanel()); // DrawingPanel �г��� ����Ʈ������ ����Ѵ�. 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	// JPanel�� ��ӹ޴� �� �г� �ۼ�
	class DrawingPanel extends JPanel {
		DrawingThread th = new DrawingThread(this); // ������ ����		
		Rectangle r = new Rectangle(100,100,0,0);
		
		public DrawingPanel() {
			this.addMouseListener(new MyMouseListener());
//			th.start();
		}
		public void setObj(int x, int y) {
			r.x = x;
			r.y = y;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // ������ �׸� Ÿ���� ��� ������.
			g.setColor(Color.MAGENTA);
			g.drawOval(r.x, r.y, 50,50); // �����尡 ���� ������ Ÿ���� �׸���.
		}
		class MyMouseListener extends MouseAdapter {
			public void mousePressed(MouseEvent e) { 				
					th.start();				
			}
		}
	}
	class DrawingThread extends Thread {
		Object obj = new Object();
		DrawingPanel p;
		public DrawingThread(DrawingPanel p) {
			this.p = p;
		}
		public void run() {
			while(true) {
				int x = (int)(Math.random()*250); // �г��� ������ ���� ���� ����
				int y = (int)(Math.random()*250); // �г��� ���̺��� ���� ���� ����
					
				p.setObj(x,y); // �гο� �׸� Ÿ�� ���� ����
				p.repaint(); 
				try {
					Thread.sleep(400); // 400ms �� ���� ���� �ܴ�.
				}
				catch(InterruptedException e){return;}		
			}
		}
	}	
	public static void main(String [] args) {
		new Ex2();
	}
}