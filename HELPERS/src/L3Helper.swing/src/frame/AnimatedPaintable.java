package frame;

import java.awt.Graphics;

class AnimatedPaintable implements Paintable {
	private IAnimation animation;
	private int currentStep = 0;

	AnimatedPaintable(IAnimation animation) {
		super();
		this.animation = animation;
	}

	@Override
	final public void paint(Graphics g) {
		animation.step(g, currentStep);
		currentStep++; 
	}
}
