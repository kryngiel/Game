package com.gmail.kryngielto.game.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.kryngielto.game.utils.Constants;
import com.gmail.kryngielto.game.map.GameMap;

/**
 * Created by Marcin on 11-Dec-17.
 */
public class GameMapRenderer {

    public GameMapRenderer() {}

    public void renderGameMap(SpriteBatch batch, GameMap gameMap) {
        for (int i = 0; i < gameMap.size().width; i++) {
            for (int j = 0; j < gameMap.size().height; j++) {
                batch.draw(gameMap.getGameField(i,j).getTexture(), i * Constants.FIELD_SIZE_PIXELS, j * Constants.FIELD_SIZE_PIXELS);
            }
        }
    }
}
