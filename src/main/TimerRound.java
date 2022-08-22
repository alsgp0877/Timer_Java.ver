package main;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class TimerRound extends JLabel implements Runnable{
	int startAngle = 0;
	int stop = 0;
	
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			
			try { 
				Thread.sleep(1000);//������� 1�ʸ��� ����ȴ�. 1000�� 100���� ���߸� �ӵ��� ��������.
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
            if(startAngle == 360) {//ä���� ���϶� ����
            	startAngle = -1;
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    			Calendar cal = Calendar.getInstance();
    			System.out.println("�����ð�" + sdf.format(cal.getTime())); 
    			break;
            }else if(stop == -1){//�����带 ������������ ����
            	startAngle = 0;
            	repaint();
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    			Calendar cal = Calendar.getInstance();
    			System.out.println("�����ð�" + sdf.format(cal.getTime()));  
    			
            	break;
            }else {
            	startAngle += 24;//360/15 �̰� Ŀ�����ϱ� ����!
            	repaint();
            }
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillArc(100, 100, 200, 200, 90, startAngle);
	}


}
