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
				Thread.sleep(1000);//쓰레드는 1초마다 진행된다. 1000을 100으로 낮추면 속도가 빨라지낟.
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
            if(startAngle == 360) {//채워진 원일때 종료
            	startAngle = -1;
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    			Calendar cal = Calendar.getInstance();
    			System.out.println("중지시간" + sdf.format(cal.getTime())); 
    			break;
            }else if(stop == -1){//쓰레드를 중지시켰을때 종료
            	startAngle = 0;
            	repaint();
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    			Calendar cal = Calendar.getInstance();
    			System.out.println("중지시간" + sdf.format(cal.getTime()));  
    			
            	break;
            }else {
            	startAngle += 24;//360/15 이건 커스텀하기 나름!
            	repaint();
            }
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillArc(100, 100, 200, 200, 90, startAngle);
	}


}
