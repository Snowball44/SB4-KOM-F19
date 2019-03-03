package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;
import dk.sdu.mmmi.cbse.managers.GameKeys;

public class Bullet extends SpaceObject {
	
	private boolean up;
	private float maxSpeed;
	private float acceleration;
	private float deceleration;
        final private long startTime;
        private ShapeRenderer sr;
        private int timeLeft;
	public Bullet(Float x, Float y, float radians) {
                up=true;
		this.x = x;
		this.y = y;
                this.radians = radians;
		maxSpeed = 50;
		acceleration = 50;
		shapex = new float[4];
		shapey = new float[4];
                sr = new ShapeRenderer();
                startTime = System.nanoTime();
		timeLeft = 0;
	}
	public void setUp(boolean b) { up = b; }
	public void update(float dt) {
		draw(sr);
            setUp(true);
		// accelerating
		if(up) {
			dx += MathUtils.cos(radians) * acceleration * dt;
			dy += MathUtils.sin(radians) * acceleration * dt;
		}
		
		// deceleration
		float vec = (float) Math.sqrt(dx * dx + dy * dy);
		if(vec > 0) {
			dx -= (dx / vec) * deceleration * dt;
			dy -= (dy / vec) * deceleration * dt;
		}
		if(vec > maxSpeed) {
			dx = (dx / vec) * maxSpeed;
			dy = (dy / vec) * maxSpeed;
		}
		
		// set position
		x += dx * dt;
		y += dy * dt;
		
		
		// screen wrap
		wrap();
                final long nowTime = System.nanoTime();
                timeLeft = (int) ((nowTime-startTime) / 1000000000);
                System.out.println(startTime);
		
	}
	
	public void draw(ShapeRenderer sr) {
		sr.setColor(1, 0, 0, 0);
		sr.begin(ShapeType.Filled);
                sr.circle(x, y, 10);
		sr.end();
		
	}

    /**
     * @return the timeLeft
     */
    public int getTimeLeft() {
        return timeLeft;
    }
	
}
















