package main2;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerTest2 extends JFrame{
	
	public static int count;
	private JPanel panel;
	
	
	public TimerTest2() {
		
		panel = new JPanel();
		panel.setLayout(null);
		
		count=0;
		
		Timer m = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if(count<5) {
					System.out.println("Apple");
					count++;
				}else {
					m.cancel();
				}
				
			}
		};
		
		JButton btn1 = new JButton("시작");
		btn1.setBounds(30, 170, 122, 30);
		btn1.addActionListener(event ->{
			m.schedule(task, 5000,2000);
		});
		
		JButton btn2 = new JButton("중지");
		btn2.setBounds(30, 200, 122, 30);
		btn2.addActionListener(event ->{
			m.cancel();
		});
		
		panel.add(btn2);
		panel.add(btn1);
		add(panel);//최종적으로 그림과 텍스트를 그려넣기
		
		setTitle("타이머");
		setSize(470, 600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
	}

}
