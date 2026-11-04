package test.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Tube {
    Texture tubeTexture;
    int x, y;
    public Tube(int x, int y) {
        this.x = x;
        this.y = y;
        tubeTexture = new Texture("tube.png");
    }

    void draw(Batch batch) {
        batch.draw(tubeTexture, x, y, 100, 574);
    }

    void move(){
        x -= 5;
    }

    void dispose() {
            tubeTexture.dispose();
    }
}
