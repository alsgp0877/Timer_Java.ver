package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerTest extends JFrame{
	
	private JPanel panel;
	
	private TimerBar timerBar;
	private Thread threadBar;
	
	private TimerNum timerNum;
	private Thread threadNum;
	
	public TimerTest() {
		int second = 15;		// 초
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerBar = new TimerBar(second);
		threadBar = new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);
		
		timerNum = new TimerNum(second);
		threadNum = new Thread(timerNum);
		threadNum.start();
		panel.add(timerNum);
		
		add(panel);
		setTitle("타이머");
		setSize(470, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
