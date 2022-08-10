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
		
		JButton btn2 = new JButton("����1");
		btn2.setBounds(30, 200, 122, 30);
		btn2.addActionListener(event ->{
			timerBar.stopT=false;//�׸�Thread ����
			timerNum.stopT=false;//�ؽ�Ʈ Thread�� ����
		});
		
		//�̷����ϸ� true�ϱ� �ٽ� �����ؾ��Ұ� ������ �� ������?
		JButton btn3 = new JButton("����2");
		btn3.setBounds(30, 240, 122, 30);
		btn3.addActionListener(event ->{
			timerBar.stopT=true;//�׸�Thread ����
			timerNum.stopT=true;//�ؽ�Ʈ Thread�� ����
		});
		
		panel.add(btn3);
		panel.add(btn2);
		panel.add(btn1);
		panel.add(timerBar);
		panel.add(timerNum);
		add(panel);//���������� �׸��� �ؽ�Ʈ�� �׷��ֱ�
		
		setTitle("Ÿ�̸�");
		setSize(470, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
