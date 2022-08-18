package main;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class TimerRound extends JLabel implements Runnable{
	int startAngle = 0, arcAncle = 10;

	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillArc(220, 230, 200, 200, startAngle, arcAncle);
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			
			try { 
				Thread.sleep(1000); 
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			 
			if (arcAncle < 180) {
				arcAncle += 50;	// 너비가 1씩 줄어듦
			} else {
				break;
			}
		}
	}


}
