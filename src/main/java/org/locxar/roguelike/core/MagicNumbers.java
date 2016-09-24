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

// TODO: Auto-generated Javadoc
/**
 * The Enum MagicNumbers.
 *
 * @author LocXar
 */
public enum MagicNumbers
{

    /** The ten. */
    TEN(10),

    /** The seventeen. */
    SEVENTEEN(17),

    /** The thirtyone. */
    THIRTYONE(31),

    /** The twohundredfiftysix. */
    TWOHUNDREDFIFTYSIX(256),

    /** The sevenhundredsixtyeight. */
    SEVENHUNDREDSIXTYEIGHT(768),

    /** The thousand. */
    THOUSAND(1000),

    /** The thousandtwentyfour. */
    THOUSANDTWENTYFOUR(1024);

    /** The number. */
    private int number;

    /**
     * Instantiates a new magic numbers.
     *
     * @param id the id
     */
    MagicNumbers(final int id)
    {
        // TODO Auto-generated constructor stub
        this.number = id;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public final int getNumber()
    {
        return this.number;
    }

}
