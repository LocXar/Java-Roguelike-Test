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
package org.locxar.roguelike.gui;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.text.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Console.
 *
 * @author LocXar
 */
public class Console extends JTextArea
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1480381816224377786L;

    /**
     * Instantiates a new console.
     *
     * @param doc
     *            the doc
     * @param text
     *            the text
     * @param rows
     *            the rows
     * @param columns
     *            the columns
     */
    public Console(final Document doc, final String text, final int rows, final int columns)
    {
	// TODO Auto-generated constructor stub
	super(doc, text, rows, columns);
	setBackground(new Color(0, 0, 0));
	setForeground(new Color(255, 255, 255));
    }

}
