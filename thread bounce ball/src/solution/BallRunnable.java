package solution;

import javax.swing.JPanel;

public class  BallRunnable implements Runnable{
	public BallRunnable(Ball aBall, JPanel ballPanel, int delay) {
		ball = aBall;
		this.ballPanel = ballPanel;
		this.delay = delay;
	}
	public void run() {
		threadDelay.set(delay);
		try {
			for(int i=1; i<=STEPS; i++) {
				ball.move(ballPanel.getBounds());
				ballPanel.paint(ballPanel.getGraphics());
				Thread.sleep(threadDelay.get().longValue());
			}
		}catch (InterruptedException e) {}
	}
	private Ball ball;
	private JPanel ballPanel;
	private static final int STEPS = 1000; 
	private int delay;
	private ThreadLocal<Integer> threadDelay = new ThreadLocal<Integer>();
}