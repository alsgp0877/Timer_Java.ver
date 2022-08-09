package main;

import javax.swing.JButton;
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
		timerNum = new TimerNum(second);
		
		threadBar = new Thread(timerBar);
		threadNum = new Thread(timerNum);
		
		JButton btn1 = new JButton("시작");
		btn1.setBounds(30, 170, 122, 30);
		btn1.addActionListener(event ->{
			threadBar.start();//그림을 Thread에 넣고 시작
			threadNum.start();//텍스트를 Thread에 넣고 시작
		});
		
		JButton btn2 = new JButton("종료");
		btn2.setBounds(30, 200, 122, 30);
		btn2.addActionListener(event ->{
			threadBar.interrupt();//그림Thread 종료
			threadNum.interrupt();//텍스트 Thread에 종료
		});
		
		
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerBar);
		panel.add(timerNum);
		add(panel);//최종적으로 그림과 텍스트를 그려넣기
		
		setTitle("타이머");
		setSize(470, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
