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
package org.locxar.roguelike.plan;

import static org.locxar.roguelike.core.MagicNumbers.*;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Mapper.
 *
 * @author LocXar
 */
public class Plan
{

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(Plan.class);

    /** The map. */
    private Map<Location, Character> map;

    /**
     * Instantiates a new mapper.
     */
    public Plan()
    {
        this.map = new HashMap<Location, Character>();
    }

    /**
     * Instantiates a new mapper.
     *
     * @param m
     *            the map
     */
    public Plan(final Map<Location, Character> m)
    {
        this.map = m;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public final Map<Location, Character> getMap()
    {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param m
     *            the map
     */
    public final void setMap(final Map<Location, Character> m)
    {
        this.map = m;
    }

    /**
     * Adds the location.
     *
     * @param m
     *            the m
     * @param loc
     *            the loc
     * @param s
     *            the s
     * @return the map
     */
    public final Map<Location, Character> addLocation(final Map<Location, Character> m, final Location loc,
            final Character s)
    {
        if (loc.getX() >= 0 && loc.getX() < TWOHUNDREDFIFTYSIX.getNumber() && loc.getY() >= 0
                && loc.getY() < TWOHUNDREDFIFTYSIX.getNumber())
        {
            if (map.containsKey(loc))
            {
                IllegalArgumentException e = new IllegalArgumentException();
                LOGGER.error("Mapper.addLocation(): Location found!", e);
                throw e;
            } else
            {
                m.put(loc, s);
            }
        }
        return m;
    }

    /**
     * Gets the location.
     *
     * @param m
     *            the m
     * @param loc
     *            the loc
     * @return the location
     */
    public final Character getLocation(final Map<Location, Character> m, final Location loc)
    {
        Character c = null;
        if (m.containsKey(loc))
        {
            c = m.get(loc);
        } else
        {
            NullPointerException e = new NullPointerException();
            LOGGER.error("Location not found!", e);
            throw e;
        }

        return c;
    }
}
