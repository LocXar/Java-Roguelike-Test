/*
 * Copyright (c) 2016 LocXar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
    
    /** The Constant slf4jLogger. */
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Turn.class);
    
    /** The type. */
    private Type TYPE = null;

    /** The start turn. */
    private boolean startTurn;

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
    * @param player the player
    * @param npc the npc
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
     *
     * @param player the player
     * @param npc the npc
     */
    private void playerTurn(Player player, Npc npc)
    {
	// TODO Auto-generated method stub
	slf4jLogger.info("This is the PlayerTurn!");
	while (player.getActionPoints() > 0.0)
	{
	    System.out.println("Actionpoints over 10: " + player.getActionPoints());
	    player.setActionPoints(player.getActionPoints() - 1);
	}
	
	if(player.getActionPoints() == 0)
	{
	    GameOver go = new GameOver(player, npc);
	    this.setStartTurn(go.isStartTurn());
	}
	
	this.setTYPE(Type.NPC);
    }

    /**
     * Npc turn.
     *
     * @param player the player
     * @param npc the npc
     */
    private void npcTurn(Player player, Npc npc)
    {
	// TODO Auto-generated method stub
	slf4jLogger.info("This is the NpcTurn!");
	this.setTYPE(Type.PLAYER);
    }

    /**
     * Checks if is start turn.
     *
     * @return true, if is start turn
     */
    public boolean isStartTurn()
    {
	return startTurn;
    }

    /**
     * Sets the start turn.
     *
     * @param startTurn the new start turn
     */
    public void setStartTurn(boolean startTurn)
    {
	this.startTurn = startTurn;
    }

}
