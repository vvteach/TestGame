package test.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class MovingBackground {
    Texture texture;
    int x;
    public MovingBackground() {
        this.x = 0;
        texture = new Texture("tube.png");
    }

    void draw(Batch batch) {
        batch.draw(texture, x, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        batch.draw(texture, x + MyGdxGame.SCR_WIDTH, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);

    }

    void move(){
        x -= 1;
        if (x < -MyGdxGame.SCR_WIDTH) {
            x = 0;
        }

    }



    void dispose() {
            texture.dispose();
    }
}
