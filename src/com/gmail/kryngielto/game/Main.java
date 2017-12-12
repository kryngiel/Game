package com.gmail.kryngielto.game; /**
 * Created by Marcin on 11-Dec-17.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.kryngielto.game.files.TexturesMap;
import com.gmail.kryngielto.game.map.GameMap;
import com.gmail.kryngielto.game.renderers.GameMapRenderer;
import com.gmail.kryngielto.game.utils.Constants;

public class Main extends Game {

    private GameMap gameMap;
    private SpriteBatch batch;
    private Texture heroTexture;
    private float heroPositionX = 0;
    private float heroPositionY = 0;
    private float heroSpeed = 3;

    @Override
    public void create() {;
        gameMap = GameMap.newRandomMap(Constants.GAME_WINDOW_SIZE);
        heroTexture = TexturesMap.getTexture("hero");
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        updateImput();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        new GameMapRenderer().renderGameMap(batch, gameMap);
        batch.draw(heroTexture, heroPositionX, heroPositionY);
        batch.end();
    }

    private void updateImput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            heroPositionX-=heroSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            heroPositionX+=heroSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            heroPositionY+=heroSpeed;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            heroPositionY-=heroSpeed;
    }

    public static void main (String[] args)
    {
        Main myProgram = new Main();
        LwjglApplication launcher = new LwjglApplication(myProgram);
    }
}