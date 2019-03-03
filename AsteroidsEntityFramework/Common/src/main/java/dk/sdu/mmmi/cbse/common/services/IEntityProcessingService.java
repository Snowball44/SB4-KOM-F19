package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {
    /**
     * 
     * Precondition for the process method is that there is an entity to run the method on
     * Postcondition for the process method is that the specific entity has been processed according to the code.
     */
    void process(GameData gameData, World world);
}
