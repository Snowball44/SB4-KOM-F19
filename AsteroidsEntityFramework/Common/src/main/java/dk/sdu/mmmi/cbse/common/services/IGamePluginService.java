package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * 
     * Precondition for start method: The game must not already have a running instance before the start method is called. 
     * Postcondition for the start method: The game must now have a running instance of the plugin. That has been started and now is running the code defined in the start method by the implementing class.
     * Precondition for stop method: The specific plugin must already have a running instance ready to be stopped.
     * Postcondition for stop is that the stop method fir a specific plugin is ran. For instance to clean up entities. 
     */
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
