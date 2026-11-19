package test.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class ScreenGame implements Screen {

    MyGdxGame myGdxGame;
    Bird bird;
    Tube[] tubes;
    boolean lost;
    int gamePoints;
    PointCounter pointCounter;
    MovingBackground background;

    ScreenGame(MyGdxGame myGdxGame) {
        Random r = new Random();
        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 360, 1, 75, 60);
        tubes = new Tube[10];
        for (int i = 0; i < tubes.length; i++) {
            tubes[i] = new Tube(i * 250 + 500, -200 + r.nextInt(-300, 0));
        }

    }

    @Override
    public void show() {
        lost = false;
        gamePoints = 0;
        pointCounter = new PointCounter(100, 100);
        background = new MovingBackground();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            bird.onClick();
        }

        bird.fly();
        for(Tube tube: tubes){
            if (!lost) {
                tube.move();
            }
        }

        for (Tube tube: tubes){
            if (tube.needAddPoint(bird)){
                gamePoints += 10;
            }
            if (tube.isHit(bird))
                System.exit(0);
        }

        background.move();

        ScreenUtils.clear(0, 0, 1, 1);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();
        /////////////////// ОТРИСОВКА ///////////////////////////
        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube: tubes) {
            tube.draw(myGdxGame.batch);
        }
        pointCounter.draw(myGdxGame.batch, gamePoints);
        /////////////////////////////////////////////////////////
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
