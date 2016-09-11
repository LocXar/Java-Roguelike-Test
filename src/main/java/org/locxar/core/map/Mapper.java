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
package org.locxar.core.map;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Mapper.
 *
 * @author LocXar
 */
public class Mapper
{
    
    /** The Constant slf4jLogger. */
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Mapper.class);
    
    /** The map. */
    Map<Location, Character> map;

    /**
     * Instantiates a new mapper.
     */
    public Mapper()
    {
	// TODO Auto-generated constructor stub
	this.map = new HashMap<Location, Character>();
    }

    /**
     * Instantiates a new mapper.
     *
     * @param map the map
     */
    public Mapper(Map<Location, Character> map)
    {
	this.map = map;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public Map<Location, Character> getMap()
    {
	return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map the map
     */
    public void setMap(Map<Location, Character> map)
    {
	this.map = map;
    }

    /**
     * Adds the location.
     *
     * @param loc the loc
     * @param s the s
     */
    public void addLocation(Location loc, Character s)
    {
	if (map.containsKey(loc))
	{
	    this.map.put(loc, s);
	} else
	{
	    slf4jLogger.info("Mapper.addLocation(): Location found!");
	}
    }
}
