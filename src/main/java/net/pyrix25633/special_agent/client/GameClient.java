package net.pyrix25633.special_agent.client;

import net.pyrix25633.special_agent.Main;
import net.pyrix25633.special_agent.component.Component;
import net.pyrix25633.special_agent.component.GUIComponent;
import net.pyrix25633.special_agent.gui.GUIHelper;
import net.pyrix25633.special_agent.gui.GameWindow;
import net.pyrix25633.special_agent.util.Vector;

import java.util.UUID;

public class GameClient {
    private final GameWindow window;
    private final GUIHelper helper;
    private final ConnectedClient connectedClient;
    public static final String version = "0.1.0";

    /**
     * Constructor
     */
    public GameClient() {
        connectedClient = Main.gameServer.connectClient();
        helper = new GUIHelper(connectedClient.getPosition());
        window = new GameWindow(helper);
    }

    /**
     * Method to get the <code>ConnectedClient</code>
     * @return The <code>ConnectedClient</code>
     */
    public ConnectedClient getConnectedClient() {
        return connectedClient;
    }

    /**
     * Method to move the <code>ConnectedClient</code>
     * @param vector The movement <code>Vector</code>
     */
    public void setMovement(Vector.Float vector) {
        connectedClient.setMovement(vector);
    }

    /**
     * Method to get the <code>GameWindow</code>
     * @return The <code>GameWindow</code>
     */
    public GameWindow getWindow() {
        return window;
    }

    /**
     * Method to repaint the <code>GameWindow</code>
     */
    public void repaint() {
        helper.calculateScale();
        window.repaint();
    }
}