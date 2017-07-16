package com.buggyarts.ball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
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

	private Rectangle playerRectangleA;
	private Rectangle playerRectangleB;
	private Rectangle obstacleRect;
	private Array<Rectangle> obstacleArray;
//	private Array<Rectangle> obstacleArrayB;
	private long lastObstacleTime;
	private long lastTime;
	private Vector3 touchPos;
	private int comp,compB;

//	Rectangle obstacle = new Rectangle();

	@Override
	public void create () {

		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(450, 800, camera);

		playerRectangleA = new Rectangle(50, 200, 50, 50);
		playerRectangleB = new Rectangle(50, 500, 50, 50);

		playerImageA = new Texture("player1.png");
		playerImageB = new Texture("player2.png");
		obstacleImage = new Texture("obstacle.png");
		groundImage = new Texture("ground.png");
		obstacleArray = new Array<Rectangle>();
//		obstacleArrayB = new Array<Rectangle>();

		genObstacleA();
//		genObstacleB();
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

		if(TimeUtils.millis() - lastObstacleTime >= comp){
			genObstacleA();
		}
//		if(TimeUtils.millis() - lastObstacleTime >= compB){
//			genObstacleB();
//		}
		batch.begin();

		batch.draw(groundImage, 0, 0, 450, 200);
		batch.draw(groundImage, 0, 400, 450, 100);
		batch.draw(playerImageA, playerRectangleA.x, playerRectangleA.y, 50,50);
		batch.draw(playerImageB, playerRectangleB.x, playerRectangleB.y, 50,50);

		for (int i = 0; i < obstacleArray.size; i++) {
			obstacleArray.get(i).x -= 100 * Gdx.graphics.getDeltaTime();
			batch.draw(obstacleImage, obstacleArray.get(i).x, obstacleArray.get(i).y, obstacleArray.get(i).width, obstacleArray.get(i).height);
//			if(obstacleArray.get(i).x < 0){
//				obstacleArray.removeIndex(i);
//			}
			if(obstacleArray.get(i).overlaps(playerRectangleA)){
//				System.out.println("sxaxs");
//				setScreen(new com.buggyarts.ball.screens.GameOver());
				for (int j = 0; ; j++) {

				}
			}
		}
//		for (int i = 0; i < obstacleArrayB.size; i++) {
//			obstacleArrayB.get(i).x -= 100 * Gdx.graphics.getDeltaTime();
//			batch.draw(obstacleImage, obstacleArrayB.get(i).x, obstacleArrayB.get(i).y, obstacleArrayB.get(i).width, obstacleArrayB.get(i).height);
//			if(obstacleArrayB.get(i).x < -25){
//				obstacleArrayB.removeIndex(i);
//			}
//			if(obstacleArrayB.get(i).overlaps(playerRectangleB)){
////				System.out.println("sxaxs");
////				setScreen(new com.buggyarts.ball.screens.GameOver());
//				for (int j = 0; ; j++) {
//
//				}
//			}
//		}

		batch.end();
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			jumpPlayerA();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			downPlayerA();
		}
//		if(Gdx.input.isKeyPressed(Input.Keys.W)){
//			jumpPlayerB();
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.S)){
//			downPlayerB();
//		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerImageA.dispose();
		playerImageB.dispose();
		obstacleImage.dispose();
	}

	private void jumpPlayerA(){
		for (int i = 0; ; i++) {
			playerRectangleA.y += 0.1f* Gdx.graphics.getDeltaTime();
			if(playerRectangleA.y >= 340){
				break;
			}
		}
	}

	private void downPlayerA(){
		for (int i = 0; ; i++) {
			playerRectangleA.y -= 0.1f* Gdx.graphics.getDeltaTime();
			if(playerRectangleA.y <= 200){
				break;
			}
		}
	}



	private void genObstacleA(){
		Rectangle obstacle = new Rectangle();
		obstacle.x = 450;
		obstacle.y = 200;
		obstacle.width = 25;
		obstacle.height = 115;
		obstacleArray.add(obstacle);
		lastObstacleTime = TimeUtils.millis();
		comp = MathUtils.random(2000, 6000);
	}
//	private void genObstacleB(){
//		Rectangle obstacle = new Rectangle();
//		obstacle.x = 450;
//		obstacle.y = 500;
//		obstacle.width = 25;
//		obstacle.height = 115;
//		obstacleArrayB.add(obstacle);
//		lastObstacleTime = TimeUtils.millis();
//		comp = MathUtils.random(2000, 6000);
//	}
}
