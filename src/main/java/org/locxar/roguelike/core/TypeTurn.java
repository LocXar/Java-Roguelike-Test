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

/**
 * The Enum Type.
 *
 * @author LocXar
 */
public enum TypeTurn
{

    /** The player. */
    PLAYER(0),
    /** The npc. */
    NPC(1);

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeTurn.class);

    /** The type. */
    private int type;

    /**
     * Instantiates a new type.
     *
     * @param id
     *            the id
     */
    TypeTurn(final int id)
    {
        this.type = id;
    }

    /**
     * Gets the type id.
     *
     * @return the type id
     */
    public int getTypeId()
    {
        LOGGER.info("getTypeId started");
        return this.type;
    }
}
