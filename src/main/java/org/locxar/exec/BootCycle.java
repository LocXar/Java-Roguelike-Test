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
package org.locxar.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.locxar.core.Npc;
import org.locxar.core.Player;
import org.locxar.core.Turn;
import org.locxar.core.map.MapGenerator;
import org.locxar.core.map.Mapper;

/**
 * The Class BootCycle.
 *
 * @author LocXar
 */
public class BootCycle
{

    /** The Constant slf4jLogger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BootCycle.class);

    /** The window. */
    // The window handle
    private long display;

    /** The title. */
    private final String title = "Test Title...";

    /** The width. */
    private final int width = 1024;

    /** The height. */
    private final int height = 768;

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
    public BootCycle()
    {
	this.startTurn = true;
	this.map.setMap(this.mg.generateTestMap(this.map.getMap()));
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args)
    {
	BootCycle bc = new BootCycle();
	bc.run();

    }

    /**
     * Run.
     */
    public final void run()
    {
	LOGGER.info("LWJGL Version: " + Version.getVersion());

	try
	{
	    init();
	    loop();

	    // Free the window callbacks and destroy the window
	    glfwFreeCallbacks(display);
	    glfwDestroyWindow(display);
	} finally
	{
	    // Terminate GLFW and free the error callback
	    glfwTerminate();
	    glfwSetErrorCallback(null).free();
	}
    }

    /**
     * Inits the.
     */
    private void init()
    {
	// Setup an error callback. The default implementation
	// will print the error message in System.err.
	GLFWErrorCallback.createPrint(System.err).set();

	// Initialize GLFW. Most GLFW functions will not work before doing this.
	if (!glfwInit())
	{
	    throw new IllegalStateException("Unable to initialize GLFW");
	}

	// Configure our window
	glfwDefaultWindowHints(); // optional, the current window hints are
				  // already the default
	glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden
						  // after creation
	glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window wont be
						    // resizable

	// Create the window
	display = glfwCreateWindow(width, height, title, NULL, NULL);
	if (display == NULL)
	{
	    throw new RuntimeException("Failed to create the GLFW window");
	}

	// Setup a key callback. It will be called every time a key is pressed,
	// repeated or released.
	glfwSetKeyCallback(display, (window, key, scancode, action, mods) ->
	{
	    if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
	    {
		glfwSetWindowShouldClose(window, true); // We will detect this
	    } // in our rendering loop
	});

	// Get the resolution of the primary monitor
	GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
	// Center our window
	glfwSetWindowPos(display, (vidmode.width() - width) / 2, (vidmode.height() - height) / 2);

	// Make the OpenGL context current
	glfwMakeContextCurrent(display);
	// Enable v-sync
	glfwSwapInterval(2);

	// Make the window visible
	glfwShowWindow(display);

    }

    /**
     * Loop.
     */
    private void loop()
    {

	// This line is critical for LWJGL's interoperation with GLFW's
	// OpenGL context, or any context that is managed externally.
	// LWJGL detects the context that is current in the current thread,
	// creates the GLCapabilities instance and makes the OpenGL
	// bindings available for use.
	GL.createCapabilities();

	// Set the clear color
	glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

	// Run the rendering loop until the user has attempted to close
	// the window or has pressed the ESCAPE key.
	while (!glfwWindowShouldClose(display))
	{
	    if (startTurn)
	    {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the
								    // framebuffer

		glfwSwapBuffers(display); // swap the color buffers

		// Poll for window events. The key callback above will only be
		// invoked during this call.
		glfwPollEvents();

		// map.getMap().put(new Location(1, 2), "A");
		// this.map.getMap().put(new Location(2, 1), "B");
		// this.map.getMap().put(new Location(1, 1), "C");
		// this.map.getMap().put(new Location(2, 2), "D");
		// this.map.addLocation(new Location(1, 2), "B");

		if (newTurn)
		{
		    System.out.println("[EVENT] New Turn");
		    System.out.println("[STAT] actionPoints: " + this.player.getActionPoints());

		    // Deactivate start of a new Turn until the turn is over.
		    this.setNEWTURN(false);
		    this.turn.turnListener(this.turn, this.getPlayer(), this.getNpc());
		    this.startTurn = this.turn.isStartTurn();

		    // Allow a new Turn.
		    this.setNEWTURN(true);
		}
	    } else
	    {
		break;
	    }
	}
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
    public final boolean getNEWTURN()
    {
	return newTurn;
    }

    /**
     * Sets the newturn.
     *
     * @param b
     *            the new newturn
     */
    public final void setNEWTURN(final boolean b)
    {
	this.newTurn = b;
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    public final Player getPlayer()
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
    public final Npc getNpc()
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
