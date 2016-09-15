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
package org.locxar.roguelike.actors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Actor.
 *
 * @author LocXar
 */
public abstract class Actor
{
    /** The Constant slf4jLogger. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** The health points. */
    private double healthPoints;

    /** The mana points. */
    private double manaPoints;

    /** The action points. */
    private double actionPoints;

    /** The name. */
    private String name;

    /**
     * Instantiates a new actor.
     */
    public Actor()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the logger
     */
    public final Logger getLogger()
    {
        return logger;
    }

    /**
     * Gets the health points.
     *
     * @return the health points
     */
    public final double getHealthPoints()
    {
    return healthPoints;
    }

    /**
     * Sets the health points.
     *
     * @param hP the new health points
     */
    public final void setHealthPoints(final double hP)
    {
    this.healthPoints = hP;
    }

    /**
     * Gets the mana points.
     *
     * @return the mana points
     */
    public final double getManaPoints()
    {
    return manaPoints;
    }

    /**
     * Sets the mana points.
     *
     * @param mP the new mana points
     */
    public final void setManaPoints(final double mP)
    {
    this.manaPoints = mP;
    }

    /**
     * Gets the action points.
     *
     * @return the action points
     */
    public final double getActionPoints()
    {
    return actionPoints;
    }

    /**
     * Sets the action points.
     *
     * @param aP the new action points
     */
    public final void setActionPoints(final double aP)
    {
    this.actionPoints = aP;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName()
    {
    return name;
    }

    /**
     * Sets the name.
     *
     * @param n the new name
     */
    public final void setName(final String n)
    {
    this.name = n;
    }
}
