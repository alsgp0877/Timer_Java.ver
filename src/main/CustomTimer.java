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
		int second = 15;//�ð��� ���ϴ� �������� �����ϸ� �ɵ��ϴ�. ��ư���� �����ص��ǰ� ��..
		
		panel = new JPanel();
		panel.setLayout(null);
		
		timerNum = new TimerNum(second);
		timerRound = new TimerRound();
		add(timerRound);//�гο� �� �߰��ϱ�
		
		threadNum = new Thread(timerNum);
		threadRound = new Thread(timerRound);
		
		
		JButton btn1 = new JButton("����");
		btn1.setBounds(30, 20, 122, 30);
		btn1.addActionListener(event ->{
			threadNum.start();//�ؽ�Ʈ�� Thread�� �ְ� ����
			threadRound.start();//���� Thread�� �ְ� ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			System.out.println("���۽ð�" + sdf.format(cal.getTime())); 
	
		});
		
		JButton btn2 = new JButton("����");
		btn2.setBounds(240, 20, 122, 30);
		btn2.addActionListener(event ->{
	
			timerNum.second=0;
			timerNum.setText(0 + "");
			
			timerRound.stop = -1;
			timerRound.startAngle = 0;
			
			threadNum.interrupt();//�ؽ�Ʈ Thread ����
			threadRound.interrupt();//�� Thread ����
			
			
		});
		
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerNum);//�гο� �ؽ�Ʈ �߰��ϱ�
		
		setTitle("Ÿ�̸�");
		setSize(400, 450);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel);//���������� �׸��� �ؽ�Ʈ�� �׷��ֱ�
	}
	

}
