package com.gmail.kryngielto.game;

import com.gmail.kryngielto.game.utils.Size;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 11-Dec-17.
 */
public class GameMap {

    Map<Integer, Map<Integer, GameField>> map;

    private GameMap() {
    }

    public static GameMap newRandomMap(Size size) {
        GameMap gameMap = new GameMap();
        gameMap.map = new HashMap<>();
        for (int i = 0; i < size.width; i++) {
            gameMap.map.put(i, new HashMap<>());
            for (int j = 0; j < size.height; j++) {
                gameMap.map.get(i).put(j, randomGameField());
            }
        }
        return gameMap;
    }

    private static GameField randomGameField() {
        return new GameFieldBasic("grass");
    }

}
