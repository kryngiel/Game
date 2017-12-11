package com.gmail.kryngielto.game.map;

import com.gmail.kryngielto.game.utils.Size;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Marcin on 11-Dec-17.
 */
public class GameMap {

    Map<Integer, Map<Integer, GameField>> map;

    private final Size size;

    private GameMap(Size size) {
        this.size = size;
    }

    public static GameMap newRandomMap(Size size) {
        GameMap gameMap = new GameMap(size);
        gameMap.map = new HashMap<>();
        for (int i = 0; i < size.width; i++) {
            gameMap.map.put(i, new HashMap<>());
            for (int j = 0; j < size.height; j++) {
                gameMap.map.get(i).put(j, randomGameField());
            }
        }
        return gameMap;
    }

    public GameField getGameField(int x, int y) {
        return map.get(x).get(y);
    }

    public Size size() {
        return size;
    }

    private static GameField randomGameField() {
        Random random = new Random();
        if (20 < random.nextInt(100)) {
            return new GameFieldBasic("grass");
        }
        return new GameFieldBasic("dirt");
    }

}
