/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

/**
 *
 * @author Kim
 */
public class AsteroidPlugin implements IGamePluginService{
    
private Entity asteroid;
    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Entity createAsteroid(GameData gameData) {
        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 100;
        float rotationSpeed = 20;
        float x = 50;
        float y = 50;
        float radians = 3.1415f / 2;
        Entity asteroidEntity = new Asteroid();
        asteroidEntity.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroidEntity.add(new PositionPart(x, y, radians));
        return asteroidEntity;
    }
    
}
