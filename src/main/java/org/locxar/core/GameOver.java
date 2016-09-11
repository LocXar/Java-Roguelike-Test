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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameOver.
 *
 * @author LocXar
 */
public class GameOver
{

    private static final Logger slf4jLogger = LoggerFactory.getLogger(GameOver.class);
    
    /** The player name. */
    // Player Stats
    private String PLAYER_NAME;
    
    /** The player healthpoints. */
    private double PLAYER_HEALTHPOINTS;
    
    /** The player manapoints. */
    private double PLAYER_MANAPOINTS;
    
    /** The player actionpoints. */
    private double PLAYER_ACTIONPOINTS;
    
    /** The npc name. */
    // Npc Stats
    private String NPC_NAME;
    
    /** The npc healthpoints. */
    private double NPC_HEALTHPOINTS;
    
    /** The npc manapoints. */
    private double NPC_MANAPOINTS;
    
    /** The npc actionpoints. */
    private double NPC_ACTIONPOINTS;
    
    /** The start turn. */
    private boolean startTurn;
    
    /**
     * Instantiates a new game over.
     *
     * @param player the player
     * @param npc the npc
     */
    public GameOver(Player player, Npc npc)
    {
	// TODO Auto-generated constructor stub
	// Initialize Player Stats
	this.PLAYER_NAME = player.getName();
	this.PLAYER_HEALTHPOINTS = player.getHealthPoints();
	this.PLAYER_MANAPOINTS = player.getManaPoints();
	this.PLAYER_ACTIONPOINTS = player.getActionPoints();
	
	// Initialize Player Stats
	this.NPC_NAME = npc.getName();
	this.NPC_HEALTHPOINTS = npc.getHealthPoints();
	this.NPC_MANAPOINTS = npc.getManaPoints();
	this.NPC_ACTIONPOINTS = npc.getActionPoints();
	
	this.run();
    }

    /**
     * Run.
     *
     * @return true, if successful
     */
    public boolean run()
    {
	System.out.println("Player.Name: " + this.PLAYER_NAME);
	System.out.println("Player.HealthPoints: " + this.PLAYER_HEALTHPOINTS);
	System.out.println("Player.ManaPoints: " + this.PLAYER_MANAPOINTS);
	System.out.println("Player.ActionPoints: " + this.PLAYER_ACTIONPOINTS);
	System.out.println("Npc.Name: " + this.NPC_NAME);
	System.out.println("Npc.HealthPoints: " + this.NPC_HEALTHPOINTS);
	System.out.println("Npc.ManaPoints: " + this.NPC_MANAPOINTS);
	System.out.println("Npc.ActionPoints: " + this.NPC_ACTIONPOINTS);
	
	boolean startTurn = false;
	return startTurn;
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
