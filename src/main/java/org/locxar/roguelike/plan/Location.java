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

import org.locxar.roguelike.core.MagicNumbers;

/**
 * The Class Location.
 *
 * @author LocXar
 */
public class Location
{
    /** The x. */
    private final int x;

    /** The y. */
    private final int y;

    /**
     * Instantiates a new location.
     *
     * @param a
     *            the x
     * @param b
     *            the y
     */
    public Location(final int a, final int b)
    {
        // TODO Auto-generated constructor stub
        this.x = a;
        this.y = b;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public final int getX()
    {
        return x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public final int getY()
    {
        return y;
    }

    @Override
    public final int hashCode()
    {
        int result = MagicNumbers.SEVENTEEN.getNumber();
        result = MagicNumbers.THIRTYONE.getNumber() * result + this.getX();
        result = MagicNumbers.THIRTYONE.getNumber() * result + this.getY();
        return result;
    }
}
