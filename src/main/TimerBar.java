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
	
	//boolean stopT = true;//종료플래그

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
				width -= 1;	// 너비가 1씩 줄어듦
				//System.out.println(width);
				setBounds(x, y, width, height);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println("중지시간" + sdf.format(cal.getTime()));  
				break;
			}
		}
	}

}
