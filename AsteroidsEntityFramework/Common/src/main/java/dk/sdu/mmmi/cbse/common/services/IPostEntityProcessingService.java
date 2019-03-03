package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Preconditon is that an object to run this process method on must be running.
 * Postcondition is that the code and method has been run and exited correctly. 
 * 
 */
public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
