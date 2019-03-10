/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.collisiondetection;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.enemy.Enemy;
import dk.sdu.mmmi.cbse.playersystem.Player;
import java.util.ArrayList;

/**
 *
 * @author Kim Christensen
 */
public class AsteroidCollision implements IPostEntityProcessingService  {

    @Override
    public void process(GameData gameData, World world) {
        ArrayList<Entity> asteroidList = new ArrayList<>();
        ArrayList<Entity> otherEntities = new ArrayList<>();
        asteroidList.addAll(world.getEntities(Asteroid.class));
        otherEntities.addAll(world.getEntities(Player.class));
        otherEntities.addAll(world.getEntities(Enemy.class));
        otherEntities.addAll(world.getEntities(Bullet.class));
        
        for (Entity entity : asteroidList) {
            Asteroid asteroid = (Asteroid) entity;
            for(Entity foreignEntity : otherEntities){
                this.checkCollision(world, asteroid, foreignEntity);
            }
        }
    }

    private void checkCollision(World world, Asteroid asteroid, Entity foreignEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
