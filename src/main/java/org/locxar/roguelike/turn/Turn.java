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
package org.locxar.roguelike.turn;

import org.locxar.roguelike.actors.Npc;
import org.locxar.roguelike.actors.Player;
import org.locxar.roguelike.core.TypeTurn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Turn.
 *
 * @author LocXar
 */
public class Turn
{
    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Turn.class);

    /** The type. */
    private TypeTurn typeTurn = null;

    /** The start turn. */
    private boolean startTurn;

    /**
     * Instantiates a new turn.
     */
    public Turn()
    {
        // TODO Auto-generated constructor stub
        this.setTYPE(TypeTurn.PLAYER);
    }

    /**
     * Instantiates a new turn.
     *
     * @param a
     *            the type
     */
    public Turn(final TypeTurn a)
    {
        // TODO Auto-generated constructor stub
        this.setTYPE(a);
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public final TypeTurn getTYPE()
    {
        return typeTurn;
    }

    /**
     * Sets the type.
     *
     * @param a
     *            the new type
     */
    public final void setTYPE(final TypeTurn a)
    {
        this.typeTurn = a;
    }

    /**
     * The turnListener check the actual <code>TYPE</code> Id and starts
     * <code>playerTurn()</code> or <code>npcTurn()</code>.
     *
     * @param turn
     *            the actual turn from the BootCycle.
     * @param player
     *            the player
     * @param npc
     *            the npc
     * @throws IllegalStateException
     *             If the actual <code>TYPE</code> is null or unknown.
     */
    public final void turnListener(final Turn turn, final Player player, final Npc npc)
    {

        switch (turn.typeTurn.getTypeId())
        {
        case 0:
            playerTurn(player, npc);
            break;

        case 1:
            npcTurn(player, npc);
            break;

        default:
            IllegalStateException e = new IllegalStateException();
            LOGGER.error("Turn Type unknown.", e);
            throw e;
        }
    }

    /**
     * Player turn.
     *
     * @param player
     *            the player
     * @param npc
     *            the npc
     */
    private void playerTurn(final Player player, final Npc npc)
    {
        // TODO Auto-generated method stub
        LOGGER.info("This is the PlayerTurn!");
        while (player.getActionPoints() > 0 && player.getHealthPoints() > 0)
        {
            System.out.println("Actionpoints over 10: " + player.getActionPoints());
            player.setActionPoints(player.getActionPoints() - 1);
        }
        this.setTYPE(TypeTurn.NPC);
    }

    /**
     * Npc turn.
     *
     * @param player
     *            the player
     * @param npc
     *            the npc
     */
    private void npcTurn(final Player player, final Npc npc)
    {
        LOGGER.info("This is the NpcTurn!");
        while (npc.getActionPoints() > 0 && npc.getHealthPoints() > 0 && player.getHealthPoints() > 0)
        {
            // TODO Auto-generated method stub
            System.out.println("Actionpoints over 10: " + npc.getActionPoints());
            npc.setActionPoints(npc.getActionPoints() - 1);
        }
        this.setTYPE(TypeTurn.PLAYER);
    }

}
