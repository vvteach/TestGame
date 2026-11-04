package test.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;
    Bird bird;
    Tube[] tubes;

    ScreenGame(MyGdxGame myGdxGame) {
        Random r = new Random();
        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 0, 10, 250, 200);
        tubes = new Tube[10];
        for (int i = 0; i < tubes.length; i++) {
            tubes[i] = new Tube(i * 250 + 50, -200 + r.nextInt(-300, 0));
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        for(Tube tube: tubes){
            tube.move();
        }

        ScreenUtils.clear(0, 0, 1, 1);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        bird.draw(myGdxGame.batch);
        for (Tube tube: tubes) {
            tube.draw(myGdxGame.batch);
        }
        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        bird.dispose();
    }
}
