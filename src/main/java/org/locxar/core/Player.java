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
 * The Class Player.
 *
 * @author LocXar
 */
public class Player extends Actor
{
    
    /** The Constant slf4jLogger. */
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Player.class);

    /** The health points. */
    private double healthPoints;
    
    /** The mana points. */
    private double manaPoints;
    
    /** The action points. */
    private double actionPoints;
    
    /** The name. */
    private String name;

    /**
     * Instantiates a new player.
     */
    public Player()
    {
	// TODO Auto-generated constructor stub
	this.setName("LocXar");
	this.setHealthPoints(1000);
	this.setManaPoints(1000);
	this.setActionPoints(10);
    }

    /**
     * Gets the health points.
     *
     * @return the health points
     */
    public double getHealthPoints()
    {
	return healthPoints;
    }

    /**
     * Sets the health points.
     *
     * @param healthPoints the new health points
     */
    public void setHealthPoints(double healthPoints)
    {
	this.healthPoints = healthPoints;
    }

    /**
     * Gets the mana points.
     *
     * @return the mana points
     */
    public double getManaPoints()
    {
	return manaPoints;
    }

    /**
     * Sets the mana points.
     *
     * @param manaPoints the new mana points
     */
    public void setManaPoints(double manaPoints)
    {
	this.manaPoints = manaPoints;
    }

    /**
     * Gets the action points.
     *
     * @return the action points
     */
    public double getActionPoints()
    {
	return actionPoints;
    }

    /**
     * Sets the action points.
     *
     * @param actionPoints the new action points
     */
    public void setActionPoints(double actionPoints)
    {
	this.actionPoints = actionPoints;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
	return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name)
    {
	this.name = name;
    }
}
