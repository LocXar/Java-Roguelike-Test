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
package org.locxar.roguelike.util.map;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.locxar.roguelike.map.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class MapGenerator.
 *
 * @author LocXar
 */
public class MapGenerator
{
    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(MapGenerator.class);

    /**
     * Instantiates a new map generator.
     */
    public MapGenerator()
    {
        // TODO Auto-generated constructor stub
        LOGGER.info("MapGenerator Object created");
    }

    /**
     * Generate test map.
     *
     * @param map
     *            the map
     * @return the map
     */
    public final Map<Location, Character> generateTestMap(final Map<Location, Character> map)
    {
        int counter = 0;
        for (int i = 0; i <= 256; i++) // Zeilen
        {
            for (int j = 0; j <= 256; j++) // Spalten
            {
                counter++;
                Location loc = new Location(i, j);
                if (i == 0 || i == 256 || j == 0 || j == 256)
                {
                    map.put(loc, new Character('+'));
                } else
                {
                    map.put(loc, new Character('-'));
                }
            }
        }
        System.out.println("Durchläufe: " + counter);
        return map;
    }
}
