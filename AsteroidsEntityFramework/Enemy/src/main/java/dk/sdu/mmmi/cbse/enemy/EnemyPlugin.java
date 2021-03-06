/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.enemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

/**
 *
 * @author Kim Christensen
 */
public class EnemyPlugin implements IGamePluginService {
    
    private Entity enemy;
    
    public EnemyPlugin(){
    }
    
    @Override
    public void start(GameData gameData, World world){
        //Add enemies to the world
        enemy = createEnemySpaceShip(gameData);
        world.addEntity(enemy);
    }
    
    private Entity createEnemySpaceShip(GameData gamedata){
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = 50;
        float y = 50;
        float radians = 3.1415f / 2;
        Entity enemyShip = new Enemy();
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(10,50));
        return enemyShip;
    }
    
    @Override
    public void stop(GameData gameData, World world){
        world.removeEntity(enemy);
    }
}
