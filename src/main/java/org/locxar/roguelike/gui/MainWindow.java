package org.locxar.roguelike.gui;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class MainFrame.
 */
public class MainWindow extends JFrame
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1886329940868267474L;

    /**
     * Instantiates a new main frame.
     */
    public MainWindow()
    {
	createAndShowGUI();
    }

    /**
     * Creates the and show GUI.
     */
    public final void createAndShowGUI()
    {
	// TODO Auto-generated method stub
	setTitle("Simple example");
	setSize(300, 200);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	Console con = new Console(null, null, 200, 100);
	this.add(con);
    }

}
