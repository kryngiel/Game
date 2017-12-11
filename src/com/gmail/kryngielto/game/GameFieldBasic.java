package com.gmail.kryngielto.game;

import com.badlogic.gdx.graphics.Texture;
import com.gmail.kryngielto.game.files.TexturesMap;

/**
 * Created by Marcin on 11-Dec-17.
 */
public class GameFieldBasic implements GameField {

    private Texture texture;

    public GameFieldBasic(String textureImageName) {
        texture = TexturesMap.getTexture(textureImageName);
    }

    @Override
    public Texture getTexture() {
        return texture;
    }
}
