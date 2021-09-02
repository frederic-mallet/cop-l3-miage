package frame;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;

public class ComponentHelper extends JComponent {
	private static final long serialVersionUID = 1320085066916331277L;
	private LinkedList<Paintable> paintable = new LinkedList<>();
	private FrameHelper helper;
	
	
	ComponentHelper(FrameHelper helper) {
		super();
		this.helper = helper;
	}
	
	public void add(Paintable p) {
		paintable.add(p);
	}
	@Override
	protected void paintComponent(Graphics g) {
		helper.canvas(g);
		for (Paintable p : paintable) p.paint(g);
	}
}
