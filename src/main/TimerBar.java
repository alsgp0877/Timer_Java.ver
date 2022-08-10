package main;

import java.awt.Color;

import javax.swing.JLabel;

public class TimerBar extends JLabel implements Runnable{
	int width = 450, height = 50;
	int x = 10, y = 50;
	Color color = new Color(255, 0, 0);
	
	int second;
	
	boolean stopT = true;//종료플래그

	public TimerBar(int second) {
		setBackground(color);
		setOpaque(true);
		setBounds(x, y, width, height);
		
		this.second = second;
	}

	@Override
	public void run() {
		while (stopT) {
			
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
				//System.out.println("종료");
				break;
			}
		}
	}

}
