/**
 * 
 */
package org.locxar.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.locxar.core.Npc;
import org.locxar.core.Player;
import org.locxar.core.Turn;
import org.locxar.core.Type;
import org.locxar.core.map.Location;
import org.locxar.core.map.MapGenerator;
import org.locxar.core.map.Mapper;

// TODO: Auto-generated Javadoc
/**
 * The Class BootCycle.
 *
 * @author LocXar
 */
public class BootCycle
{

    /** The Constant slf4jLogger. */
    private final static Logger slf4jLogger = LoggerFactory.getLogger(BootCycle.class);

    /** The window. */
    // The window handle
    private long window;

    /** The turn. */
    private Turn turn = new Turn();

    // Create new Player object
    private Player player = new Player();
    // Create new Npc object
    private Npc npc = new Npc();
    
    Mapper map = new Mapper();
    
    MapGenerator mg = new MapGenerator();

    private int NEWTURN = GL_TRUE;

    /**
     * Instantiates a new boot cycle.
     */
    public BootCycle()
    {
	// TODO Auto-generated constructor stub
	this.map.setMap(this.mg.generateTestMap(map.getMap()));
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args)
    {
	BootCycle bc = new BootCycle();
	bc.run();

    }

    /**
     * Run.
     */
    public void run()
    {
	slf4jLogger.info("LWJGL Version: " + Version.getVersion());
	
	try
	{
	    init();
	    loop();

	    // Free the window callbacks and destroy the window
	    glfwFreeCallbacks(window);
	    glfwDestroyWindow(window);
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
	    throw new IllegalStateException("Unable to initialize GLFW");

	// Configure our window
	glfwDefaultWindowHints(); // optional, the current window hints are
				  // already the default
	glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden
						  // after creation
	glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window wont be
						    // resizable

	int WIDTH = 1024;
	int HEIGHT = 768;
	String TITLE = null;

	// Debug Input
	TITLE = "Test Title...";

	// Create the window
	window = glfwCreateWindow(WIDTH, HEIGHT, TITLE, NULL, NULL);
	if (window == NULL)
	    throw new RuntimeException("Failed to create the GLFW window");

	// Setup a key callback. It will be called every time a key is pressed,
	// repeated or released.
	glfwSetKeyCallback(window, (window, key, scancode, action, mods) ->
	{
	    if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
		glfwSetWindowShouldClose(window, true); // We will detect this
							// in our rendering loop
	});

	// Get the resolution of the primary monitor
	GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
	// Center our window
	glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);

	// Make the OpenGL context current
	glfwMakeContextCurrent(window);
	// Enable v-sync
	glfwSwapInterval(2);

	// Make the window visible
	glfwShowWindow(window);

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
	while (!glfwWindowShouldClose(window))
	{
	    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the
								// framebuffer

	    glfwSwapBuffers(window); // swap the color buffers

	    // Poll for window events. The key callback above will only be
	    // invoked during this call.
	    glfwPollEvents();
	    
	    // map.getMap().put(new Location(1, 2), "A");
	    // this.map.getMap().put(new Location(2, 1), "B");
	    // this.map.getMap().put(new Location(1, 1), "C");
	    // this.map.getMap().put(new Location(2, 2), "D");
	    // this.map.addLocation(new Location(1, 2), "B");
	    
	    if (NEWTURN == GL_TRUE)
	    {
		System.out.println("[EVENT] New Turn");
		System.out.println("[STAT] actionPoints: " + this.player.getActionPoints());
		
		// Deactivate start of a new Turn until the turn is over.
		this.setNEWTURN(GL_FALSE);
		this.turn.turnListener(this.turn, this.getPlayer(), this.getNpc());

		// Allow a new Turn.
		this.setNEWTURN(GL_TRUE);
	    }
	}
    }

    public Turn getTurn()
    {
	return turn;
    }

    public void setTurn(Turn turn)
    {
	this.turn = turn;
    }

    public int getNEWTURN()
    {
	return NEWTURN;
    }

    public void setNEWTURN(int nEWTURN)
    {
	this.NEWTURN = nEWTURN;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Npc getNpc()
    {
        return npc;
    }

    public void setNpc(Npc npc)
    {
        this.npc = npc;
    }
    
    
}
