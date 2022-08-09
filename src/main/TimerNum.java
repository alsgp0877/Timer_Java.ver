package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TimerNum extends JLabel implements Runnable{
	int width = 75, height = 75;
	int x = 200, y = 150;
	
	int second;

	public TimerNum(int second) {
		setOpaque(true);
		setBounds(x, y, width, height);
		setForeground(Color.BLUE);
		setText(second + "");
		setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 50));
		setHorizontalAlignment(JLabel.CENTER);
		
		this.second = second;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(1000);	// 1ÃÊ
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (second > 0) {
				second -= 1;		// 1ÃÊ¾¿ ÁÙ¾îµê
				setText(second + "");
			} else {
				//System.out.println("Á¾·á");
				break;
			}
		}
	}
}
