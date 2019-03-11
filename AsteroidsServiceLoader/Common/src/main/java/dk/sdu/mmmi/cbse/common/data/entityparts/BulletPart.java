/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kim Christensen
 */
public class BulletPart implements EntityPart {

    boolean shoot;
    boolean canShoot = false;
    List<Entity> bulletList = new ArrayList<>();
    
    public void setShouldShoot(Boolean shoot){
        this.shoot = shoot;
    }
    
    public List<Entity> getBulletList(){
        return bulletList;
    }
    
    public Boolean shouldShoot(){
        return shoot;
    }
    @Override
    public void process(GameData gameData, Entity entity) {
    }
    
}
