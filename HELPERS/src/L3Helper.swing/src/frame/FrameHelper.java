package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FrameHelper {
	private int width, height;
	private boolean reverseYAndCenter;

	public FrameHelper(int width, int height) {
		this(width, height, false);
	}
	public FrameHelper(int width, int height, boolean reverseY) {
		super();
		this.width = width;
		this.height = height;
		this.reverseYAndCenter = reverseY;
	}

	public void animate(IAnimation animation, int everyMs) {
		ComponentHelper helper = new ComponentHelper(this);
		helper.add(new AnimatedPaintable(animation));
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				helper.repaint();
			}
		}, everyMs, everyMs);
		drawInFrame(helper);
	}
	public void draw(Paintable ...paintables) {
		ComponentHelper helper = new ComponentHelper(this);
		for (Paintable p : paintables)
			helper.add(p);
		drawInFrame(helper);
	}

	public void drawInFrame(JComponent c) {
		JFrame frame = new JFrame("test");
		c.setPreferredSize(new Dimension(width, height));

		frame.getContentPane().add(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void canvas(Graphics g) {
		if (! reverseYAndCenter) return;
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(width >> 1, height >> 1);		
		g2d.scale(1, -1);
		g.setColor(Color.red);
		g.drawLine(-5, 0, 5, 0);
		g.drawLine(0, -5, 0, 5);
		printCenterX(g, "(0,0)", 0, 0);
		g.setColor(Color.black);
	}

	public static void printCenterX(Graphics g, String message, int x, int y) {
		print(g, message, x - g.getFontMetrics().stringWidth(message)/2, y - g.getFontMetrics().getAscent());
	}

	public static void print(Graphics g, String message, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(1, -1);
		g.drawString(message, x, -y);
		g2d.scale(1, -1);
	}
}
