package com.gmail.kryngielto.game.files;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 11-Dec-17.
 */
public class TexturesMap {

    private TexturesMap() {}

    private static final Map<String, Texture> map = new HashMap<>();


    public static Texture getTexture(String textureImageName) {
        Texture texture = map.get(textureImageName);
        if (texture == null) {
            texture = loadNewTexture(textureImageName);
        }
        return texture;
    }

    private static Texture loadNewTexture(String textureImageName) {
        FileHandle worldFile = Gdx.files.internal(FilesConstants.IMAGES_PATH + textureImageName + FilesConstants.IMAGES_EXTENSION);
        Texture texture = new Texture(worldFile);
        map.put(textureImageName, texture);
        return new Texture(worldFile);
    }
}
