package test.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tube {
    Texture tubeTexture, flippedTubeTexture;
    int x, y, d;
    public Tube(int x, int y) {
        this.x = x;
        this.y = y;
        tubeTexture = new Texture("tube.png");
        flippedTubeTexture = new Texture("tube_flipped.png");
        Random r = new Random();
        d = r.nextInt(250, 350);
    }

    void draw(Batch batch) {
        batch.draw(tubeTexture, x, y, 100, 574);
        int y2 = y + 574 + d;
        batch.draw(flippedTubeTexture, x, y2, 100, 574);
    }

    void move(){
        x -= 5;
        if (x < -100)
            x = 2400;

    }

    void dispose() {
            tubeTexture.dispose();
    }
}
