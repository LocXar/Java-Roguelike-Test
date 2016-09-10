/**
 * 
 */
package org.locxar.core;

import org.locxar.exec.BootCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Turn.
 *
 * @author LocXar
 */
public class Turn
{
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Turn.class);
    
    /** The type. */
    private Type TYPE = null;

    /**
     * Instantiates a new turn.
     */
    public Turn()
    {

	// TODO Auto-generated constructor stub
	this.setTYPE(Type.PLAYER);
    }

    /**
     * Instantiates a new turn.
     *
     * @param type the type
     */
    public Turn(Type type)
    {
	// TODO Auto-generated constructor stub
	this.setTYPE(type);
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public Type getTYPE()
    {
	return TYPE;
    }

    /**
     * Sets the type.
     *
     * @param TYPE the new type
     */
    public void setTYPE(Type TYPE)
    {
	this.TYPE = TYPE;
    }

   /**
    * The turnListener check the actual <var>TYPE</var> Id and starts <code>playerTurn()</code> or <code>npcTurn()</code>.
    *
    * @param turn the actual turn from the BootCycle.
 * @param npc 
 * @param player 
    * @throws IllegalStateException If the actual <var>TYPE</var> is null or unknown.
    */
   public void turnListener(Turn turn, Player player, Npc npc)
   {
       
       
       switch (turn.TYPE.getTypeId())
       {
	   case 0:
	       playerTurn(player, npc);
	       break;
           
           case 1:
    	   	npcTurn(player, npc);
    	   	break;
           
           default:
               new IllegalStateException("Turn Type unknown.");
       }
   }

    /**
     * Player turn.
     * @param npc 
     * @param player 
     */
    private void playerTurn(Player player, Npc npc)
    {
	// TODO Auto-generated method stub
	slf4jLogger.info("This is the PlayerTurn!");
	while (player.getActionPoints() > 0.0)
	{
	    System.out.println("Actionpoints over 10: " + player.getActionPoints());
	}
	this.setTYPE(Type.NPC);
    }

    /**
     * Npc turn.
     * @param npc 
     * @param player 
     */
    private void npcTurn(Player player, Npc npc)
    {
	// TODO Auto-generated method stub
	slf4jLogger.info("This is the NpcTurn!");
	this.setTYPE(Type.PLAYER);
    }

}
