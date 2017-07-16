package com.buggyarts.ball.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.buggyarts.ball.*;

/**
 * Created by storm on 16-Jul-17.
 */

public class GameOver implements Screen {

//    private GameClass game;
    private Viewport viewport;
    private OrthographicCamera camera;

    public GameOver(){
//        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(450, 800, camera);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float a){

    }

    @Override
    public void show() {

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
    public void dispose(){

    }

}
