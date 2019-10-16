//Further Programming Assignment 1 by Alex Huang s3628653
package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows wheel spinning output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void nextSlot(Slot slot, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	   logger.log(Level.FINE,  "Next slot: " + slot.toString());
   }

   @Override
   public void result(Slot result, GameEngine engine)
   {
      // final results logged at Level.INFO
      engine.calculateResult(result);
      logger.log(Level.INFO, String.format("RESULT: " + result.toString() + "\n"));
      logger.log(Level.INFO, "FINAL PLAYER POINT BALANCES");
      
      String scoreList = "";
      for (Player player: engine.getAllPlayers()) {
    	  scoreList += "\n" + player.toString();
    	  player.resetBet();
      }
      
      logger.log(Level.INFO, scoreList);
   }
}
