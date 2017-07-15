package com.buggyarts.ball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameClass extends Game {
	private SpriteBatch batch;
	private Viewport viewport;
	private OrthographicCamera camera;

	private Texture playerImageA;
	private Texture playerImageB;
	private Texture obstacleImage;
	private Texture groundImage;

	private Circle playerCircleA;
	private Circle playerCircleB;
	private Rectangle obstacleRect;
	private Array<Rectangle> obstacleArray;
	private long lastObstacleTime;
	private Vector3 touchPos;
	private int comp;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(450, 800, camera);

		playerCircleA = new Circle(0, 200, 50);
		playerCircleB = new Circle(0, 500, 50);

		playerImageA = new Texture("player1.png");
		playerImageB = new Texture("player2.png");
		obstacleImage = new Texture("obstacle.png");
		groundImage = new Texture("ground.png");
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

//		if(TimeUtils.millis() - lastObstacleTime >= comp){
//			genObstacle();
//		}
		batch.begin();

		batch.draw(groundImage, 0, 0, 450, 200);
		batch.draw(groundImage, 0, 400, 450, 100);
		batch.draw(playerImageA, playerCircleA.x, playerCircleA.y, 50,50);
		batch.draw(playerImageB, playerCircleB.x, playerCircleB.y, 50,50);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerImageA.dispose();
	}
}
