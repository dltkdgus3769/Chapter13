import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Ex4 extends JFrame {
	JFrame f = this;
    JPanel p = new JPanel();
    runnable thread;
    Thread th;
        
    public Ex4() {
    	this.setTitle("test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new runnable();
        th = new Thread(thread);
        this.setLocation(100, 100);
        this.add(p);
        this.setVisible(true);
        this.setSize(300, 300); //프레임 사이즈 설정
        th.start();
   }
   class runnable implements Runnable {
	   public void run() {
		   while(true) { //프레임 진동
			   try {
				   f.setLocation(90, 100);
                   Thread.sleep(1); //1ms 재우기
                   f.setLocation(100, 100);
                   Thread.sleep(1);
                   f.setLocation(90, 90);
                   Thread.sleep(1);
                   f.setLocation(100, 90);
                   Thread.sleep(1);                 
			   }
               catch(InterruptedException e){return;}
		   }
	   }
   }
   public static void main(String[] args) {
	   // TODO Auto-generated method stub
		new Ex4();
   }
}


