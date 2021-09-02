package frame;

import java.awt.Graphics;

public interface IAnimation {
	/** 
	 * Write a step
	 * @param g Graphics to which we paint
	 * @param i number of steps
	 * @return true if wants to be cancelled
	 */
	public boolean step(Graphics g, int i);
}
