package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomTimer extends JFrame{
	
	private JPanel panel;

	private TimerNum timerNum;
	private Thread threadNum;
	
	private TimerRound timerRound;
	private Thread threadRound;

	
	public CustomTimer() {
		int second = 15;//시간은 원하는 방향으로 설정하면 될듯하다. 버튼으로 설정해도되고 등..
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerNum = new TimerNum(second);
		timerRound = new TimerRound();
		add(timerRound);//패널에 원 추가하기
		
		threadNum = new Thread(timerNum);
		threadRound = new Thread(timerRound);
		
		
		JButton btn1 = new JButton("시작");
		btn1.setBounds(30, 20, 122, 30);
		btn1.addActionListener(event ->{
			threadNum.start();//텍스트를 Thread에 넣고 시작
			threadRound.start();//원을 Thread에 넣고 시작
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			System.out.println("시작시간" + sdf.format(cal.getTime())); 
	
		});
		
		JButton btn2 = new JButton("중지");
		btn2.setBounds(240, 20, 122, 30);
		btn2.addActionListener(event ->{
	
			timerNum.second=0;
			timerNum.setText(0 + "");
			
			timerRound.stop = -1;
			timerRound.startAngle = 0;
			
			threadNum.interrupt();//텍스트 Thread 중지
			threadRound.interrupt();//원 Thread 중지
			
			
		});
		
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerNum);//패널에 텍스트 추가하기
		
		setTitle("타이머");
		setSize(400, 450);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);//최종적으로 그림과 텍스트를 그려넣기
	}
	

}
