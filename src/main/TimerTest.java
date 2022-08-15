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

public class TimerTest extends JFrame{
	
	private JPanel panel;
	
	private TimerBar timerBar;
	private Thread threadBar;

	private TimerNum timerNum;
	private Thread threadNum;
	
	
	public TimerTest() {
		int second = 15;		// ��
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerBar = new TimerBar(second);
		timerNum = new TimerNum(second);
		
		
		threadBar = new Thread(timerBar);
		threadNum = new Thread(timerNum);
		
		JButton btn1 = new JButton("����");
		btn1.setBounds(30, 170, 122, 30);
		btn1.addActionListener(event ->{
			threadBar.start();//�׸��� Thread�� �ְ� ����
			threadNum.start();//�ؽ�Ʈ�� Thread�� �ְ� ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			System.out.println("���۽ð�" + sdf.format(cal.getTime())); 
	
		});
		
		JButton btn2 = new JButton("����");
		btn2.setBounds(30, 200, 122, 30);
		btn2.addActionListener(event ->{
	
			
			timerNum.second=0;
			timerNum.setText(0 + "");
			
			timerBar.width=0;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			System.out.println("�����ð�" + sdf.format(cal.getTime()));  
			
			threadBar.interrupt();
			threadNum.interrupt();
			
			
			
		});
		
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerBar);
		panel.add(timerNum);
		
		TimerRound timerRound = new TimerRound();
		panel.add(timerRound);
		
		
		setTitle("Ÿ�̸�");
		setSize(470, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);//���������� �׸��� �ؽ�Ʈ�� �׷��ֱ�
	}
	

}
