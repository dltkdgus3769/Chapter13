import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex6 extends JFrame{
	public Ex6() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);	
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex6();
	}
}
class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) { //마우스이벤트
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();
			}
		});
	}
	
	class BubbleThread extends Thread {
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			//이미지 레이블 구현
			ImageIcon img = new ImageIcon("images/bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); // GamePanel에 add()
			repaint();
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX() ;
				int y = bubble.getY() - 5;
				if(y < 0) {
					remove(bubble);
					repaint();
					return; // 스레드 끝
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200); //200ms 재우기
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
