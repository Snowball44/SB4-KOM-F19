/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IBullet;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.ArrayList;

/**
 *
 * @author Kim
 */
public class BulletPlugin implements IGamePluginService, IBullet {
    
    public BulletPlugin() {
        
    }
    @Override
    public void start(GameData gameData, World world) {
        //Nothing
    }
    @Override
    public Entity createBullet(PositionPart positionPartPlayer){
        Bullet bullet = new Bullet();
        float deacceleration = 0;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 0;
        float radians = positionPartPlayer.getRadians();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(positionPartPlayer.getX(), positionPartPlayer.getY(), positionPartPlayer.getRadians()));
        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {
        ArrayList<Entity> allBulletsInWorld = new ArrayList<>();
        allBulletsInWorld.addAll(world.getEntities(Bullet.class));
        for (Entity entity : allBulletsInWorld) {
            world.removeEntity(entity);
        }
    }
}