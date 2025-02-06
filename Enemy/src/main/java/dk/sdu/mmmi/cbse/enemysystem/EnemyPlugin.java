package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin(){

    }

    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {
        Entity enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-5, -5, 10, 0, -5, 5);
        Random random = new Random();
        enemyShip.setX(random.nextInt(gameData.getDisplayWidth()));
        enemyShip.setY(random.nextInt(gameData.getDisplayHeight()));
        enemyShip.setRadius(random.nextInt((15 - 5 + 1) + 5));
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
