/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.ArrayList;

/**
 *
 * @author Kim
 */
public class BulletPlugin implements IGamePluginService {
    
    public BulletPlugin() {
        
    }
    @Override
    public void start(GameData gameData, World world) {
        //Nothing
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