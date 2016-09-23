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
package org.locxar.roguelike.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Enum Type.
 *
 * @author LocXar
 */
public enum TypeTile
{

    /** The player. */
    DIRT('.'),
    /** The npc. */
   DIRTWALL('#');

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeTile.class);

    /** The type. */
    private int type;

    /**
     * Instantiates a new type.
     *
     * @param x
     *            the x
     */
    TypeTile(final char x)
    {
	boolean walkable;
	char tile;

        switch (x)
        {
        	case '.':
        	    walkable = true;
        	    tile = x;
        	    break;
        	case '#':
        	    walkable = false;
        	    tile  = x;
        	    break;
        	default:
        	    walkable = false;
        	    tile = '#';
        	    break;
        }
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType()
    {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param t the new type
     */
    public void setType(final int t)
    {
        this.type = t;
    }

    /**
     * Gets the type id.
     *
     * @return the type id
     */
    public int getTypeId()
    {
        LOGGER.info("getTypeTileId started");
        return this.type;
    }
}
