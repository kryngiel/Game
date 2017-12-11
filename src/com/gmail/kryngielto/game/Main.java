package com.gmail.kryngielto.game; /**
 * Created by Marcin on 11-Dec-17.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.kryngielto.game.map.GameMap;
import com.gmail.kryngielto.game.renderers.GameMapRenderer;
import com.gmail.kryngielto.game.utils.Size;

public class Main extends Game {

    private GameMap gameMap;
    private SpriteBatch batch;

    public void create() {;
        gameMap = GameMap.newRandomMap(new Size(12,8));
        batch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        new GameMapRenderer().renderGameMap(batch, gameMap);
        batch.end();
    }

    public static void main (String[] args)
    {
        Main myProgram = new Main();
        LwjglApplication launcher = new LwjglApplication(myProgram);
    }
}