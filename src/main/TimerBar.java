package main;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class TimerBar extends JLabel implements Runnable{
	int width = 450, height = 50;
	int x = 10, y = 50;
	Color color = new Color(255, 0, 0);

	
	int second;
	
	//boolean stopT = true;//�����÷���

	public TimerBar(int second) {
		setBackground(color);
		setOpaque(true);
		setBounds(x, y, width, height);
	
		this.second = second;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			
			try { 
				Thread.sleep(1000 / 30); 
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			 
			if (getWidth() > 0) {
				width -= 1;	// �ʺ� 1�� �پ��
				//System.out.println(width);
				setBounds(x, y, width, height);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println("�����ð�" + sdf.format(cal.getTime()));  
				break;
			}
		}
	}

}
