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
		});
		
		JButton btn2 = new JButton("����");
		btn2.setBounds(30, 200, 122, 30);
		btn2.addActionListener(event ->{
			threadBar.interrupt();//�׸�Thread ����
			threadNum.interrupt();//�ؽ�Ʈ Thread�� ����
		});
		
		
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerBar);
		panel.add(timerNum);
		add(panel);//���������� �׸��� �ؽ�Ʈ�� �׷��ֱ�
		
		setTitle("Ÿ�̸�");
		setSize(470, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
