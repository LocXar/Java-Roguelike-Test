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

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameOver.class);

    /** The player name. */
    // Player Stats
    private String playerName;

    /** The player healthpoints. */
    private double playerHealthPoints;

    /** The player manapoints. */
    private double playerManaPoints;

    /** The player actionpoints. */
    private double playerActionPoints;

    /** The npc name. */
    // Npc Stats
    private String npcName;

    /** The npc healthpoints. */
    private double npcHealthPoints;

    /** The npc manapoints. */
    private double npcManaPoints;

    /** The npc actionpoints. */
    private double npcActionPoints;

    /** The start turn. */
    private boolean startTurn;

    /**
     * Instantiates a new game over.
     *
     * @param player the player
     * @param npc the npc
     */
    public GameOver(final Player player, final Npc npc)
    {
	// TODO Auto-generated constructor stub
	// Initialize Player Stats
	this.playerName = player.getName();
	this.playerHealthPoints = player.getHealthPoints();
	this.playerManaPoints = player.getManaPoints();
	this.playerActionPoints = player.getActionPoints();

	// Initialize Player Stats
	this.npcName = npc.getName();
	this.npcHealthPoints = npc.getHealthPoints();
	this.npcManaPoints = npc.getManaPoints();
	this.npcActionPoints = npc.getActionPoints();

	this.run();
    }

    /**
     * Run.
     *
     * @return true, if successful
     */
    public final boolean run()
    {
	System.out.println("Player.Name: " + this.playerName);
	System.out.println("Player.HealthPoints: " + this.playerHealthPoints);
	System.out.println("Player.ManaPoints: " + this.playerManaPoints);
	System.out.println("Player.ActionPoints: " + this.playerActionPoints);
	System.out.println("Npc.Name: " + this.npcName);
	System.out.println("Npc.HealthPoints: " + this.npcHealthPoints);
	System.out.println("Npc.ManaPoints: " + this.npcManaPoints);
	System.out.println("Npc.ActionPoints: " + this.npcActionPoints);

	boolean sT = false;
	return sT;
    }

    /**
     * Checks if is start turn.
     *
     * @return true, if is start turn
     */
    public final boolean isStartTurn()
    {
        return startTurn;
    }

    /**
     * Sets the start turn.
     *
     * @param sT the new start turn
     */
    public final void setStartTurn(final boolean sT)
    {
        this.startTurn = sT;
    }
}
