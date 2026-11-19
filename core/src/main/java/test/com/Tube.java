package test.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tube {
    public static final int HEIGHT = 574;
    public static final int WIDTH = 100;
    Texture tubeTexture, flippedTubeTexture;
    int x, y, gapHeight;
    boolean isPointReceived = false;
    public Tube(int x, int y) {
        this.x = x;
        this.y = y;
        tubeTexture = new Texture("tube.png");
        flippedTubeTexture = new Texture("tube_flipped.png");
        Random r = new Random();
        gapHeight = r.nextInt(250, 350);
    }

    public boolean isHit(Bird bird){
        int gapY = this.y + HEIGHT + gapHeight / 2;
        if ((bird.x + bird.width >= this.x && bird.x <= this.x + WIDTH &&
            bird.y <= this.y + HEIGHT) ||
           (bird.x + bird.width >= this.x && bird.x <= this.x + WIDTH &&
            bird.y + bird.height > this.y + HEIGHT + gapHeight))
            return true;
        return false;
    }

    void draw(Batch batch) {
        batch.draw(tubeTexture, x, y, WIDTH, HEIGHT);
        int y2 = y + HEIGHT + gapHeight;
        batch.draw(flippedTubeTexture, x, y2, WIDTH, HEIGHT);
    }

    void move(){
        x -= 5;
        if (x < -WIDTH) {
            x = 2400;
            isPointReceived = false;
        }

    }

    public boolean needAddPoint(Bird bird) {
        if (!isPointReceived && x + WIDTH <= bird.x){
            isPointReceived = true;
            return true;
        }
        return false;
    }

    void dispose() {
            tubeTexture.dispose();
    }
}
