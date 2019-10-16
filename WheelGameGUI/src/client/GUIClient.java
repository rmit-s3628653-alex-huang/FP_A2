//Further Programming Assignment 2 by Alex Huang s3628653
package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackImpl;
import view.MainFrame;
import view.GameEngineCallbackGUI;

public class GUIClient {
	public static void main(String args[])
	{	
		final GameEngine gameEngine = new GameEngineImpl();
	    final MainFrame mainFrame = new MainFrame(gameEngine);
	   
	    gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	    gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(mainFrame));	       
	   }
}
