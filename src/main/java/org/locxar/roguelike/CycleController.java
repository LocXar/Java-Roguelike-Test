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
package org.locxar.roguelike;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.swing.SwingUtilities;

import org.locxar.roguelike.actors.Npc;
import org.locxar.roguelike.actors.Player;
import org.locxar.roguelike.core.MagicNumbers;
import org.locxar.roguelike.gui.MainFrame;
import org.locxar.roguelike.map.Location;
import org.locxar.roguelike.map.Mapper;
import org.locxar.roguelike.turn.Turn;
import org.locxar.roguelike.util.map.MapGenerator;

/**
 * The Class BootCycle.
 *
 * @author LocXar
 */
public class CycleController
{

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CycleController.class);

    /** The window. */
    // The window handle
    private long window;

    /** The title. */
    private String title = "Test Title...";

    /** The width. */
    private int width = MagicNumbers.THOUSANDTWENTYFOUR.getNumber();

    /** The height. */
    private int height = MagicNumbers.SEVENHUNDREDSIXTYEIGHT.getNumber();

    /** The turn. */
    private Turn turn = new Turn();

    /** The player. */
    // Create new Player object
    private Player player = new Player();

    /** The npc. */
    // Create new Npc object
    private Npc npc = new Npc();

    /** The map. */
    private Mapper map = new Mapper();

    /** The mg. */
    private MapGenerator mg = new MapGenerator();

    /** The newturn. */
    private boolean newTurn = true;

    /** The start turn. */
    private boolean startTurn;

    /**
     * Instantiates a new boot cycle.
     */
    public CycleController()
    {
	this.startTurn = true;
    }

    /**
     * Write 2 file.
     *
     * @param m
     *            the map
     */
    private static void write2File(final Map<Location, Character> m)
    {
	String fileLocation = "target/debug/map";
	String fileName = "/map.save";
	Path pathToFile = Paths.get(fileLocation);
	pathToFile = pathToFile.toAbsolutePath();
	LOGGER.info("filePath + fileName: " + pathToFile.toString() + fileName);

	FileOutputStream outFileStream = null;
	pathToFile.toFile().mkdirs();

	try
	{
	    outFileStream = new FileOutputStream(pathToFile.toString() + fileName);

	} catch (FileNotFoundException e)
	{ // EXCEPTION Auto-generated catch block
	    LOGGER.error("Can't create outFileStream:\n", e);
	}

	try
	{
	    int c;
	    for (int i = 0; i < MagicNumbers.TWOHUNDREDFIFTYSIX.getNumber(); i++) // Zeilen
	    {
		for (int j = 0; j < MagicNumbers.TWOHUNDREDFIFTYSIX.getNumber(); j++) // Spalten
		{
		    LOGGER.info("I: " + i + "\n" + "J: " + j);
		    // LOGGER.info("HashMap value: " + m.get(new Location(i, j)).hashCode());
		    c = m.get(new Location(i, j)).hashCode();
		    // System.out.println(c);
		    outFileStream.write(c);
		}
		outFileStream.write('\n');
	    }
	    outFileStream.close();
	} catch (IOException e)
	{
	    // EXCEPTION Auto-generated catch block
	    LOGGER.error("Can't write outFileStream:\n", e);
	    e.printStackTrace();
	}
	System.out.println("end of writeFile()");
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args)
    {
	CycleController cc = new CycleController();
	cc.coreGameLoop();

	/*
	 * SwingUtilities.invokeLater(new Runnable() {
	 * 
	 * @Override public void run() { MainFrame mf = new MainFrame();
	 * mf.createAndShowGUI(); } });
	 */
    }

    /**
     * Run.
     */
    private void coreGameLoop()
    {

	try
	{
	    init();
	    loop();
	    gameOver();

	} finally
	{
	    System.exit(1);
	}
    }

    /**
     * Inits the.
     */
    private void init()
    {
	this.map.setMap(this.mg.generateTestMap(this.map.getMap()));

	int i = 0;
	for (Character c : this.map.getMap().values())
	{
	    i++;
	    System.out.println(i + ": " + c);
	}

	// System.out.println(this.map.getLocation(this.map.getMap(),
	// this.map.getMap().get(key)).charValue());
	write2File(this.map.getMap());

    }

    /**
     * Loop.
     */
    private void loop()
    {
	while (!isGameOver())
	{
	    System.out.println("[EVENT] New Turn");
	    System.out.println("[STAT] actionPoints: " + this.player.getActionPoints());

	    // Deactivate start of a new Turn until the turn is over.
	    this.setNewTurn(false);
	    this.turn.turnListener(this.turn, this.getPlayer(), this.getNpc());
	    this.startTurn = this.turn.isStartTurn();

	    // Allow a new Turn.
	    this.setNewTurn(true);
	}
    }

    /**
     * Checks if is game over.
     *
     * @return true, if is game over
     */
    private boolean isGameOver()
    {
	// TODO Auto-generated method stub
	if (this.getPlayer().getHealthPoints() <= 0)
	{
	    return true;
	}
	return false;
    }

    /**
     * Game over.
     */
    private void gameOver()
    {
	// TODO Auto-generated method stub
    }

    /**
     * Gets the turn.
     *
     * @return the turn
     */
    public final Turn getTurn()
    {
	return turn;
    }

    /**
     * Sets the turn.
     *
     * @param t
     *            the new turn
     */
    public final void setTurn(final Turn t)
    {
	this.turn = t;
    }

    /**
     * Gets the newturn.
     *
     * @return the newturn
     */
    public final boolean getNewTurn()
    {
	return newTurn;
    }

    /**
     * Sets the newturn.
     *
     * @param b
     *            the new newturn
     */
    private void setNewTurn(final boolean b)
    {
	this.newTurn = b;
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    private Player getPlayer()
    {
	return player;
    }

    /**
     * Sets the player.
     *
     * @param p
     *            the new player
     */
    public final void setPlayer(final Player p)
    {
	this.player = p;
    }

    /**
     * Gets the npc.
     *
     * @return the npc
     */
    private Npc getNpc()
    {
	return npc;
    }

    /**
     * Sets the npc.
     *
     * @param n
     *            the new npc
     */
    public final void setNpc(final Npc n)
    {
	this.npc = n;
    }
}
