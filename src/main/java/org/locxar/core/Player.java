/**
 * 
 */
package org.locxar.core;

import org.locxar.exec.BootCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 *
 * @author LocXar
 */
public class Player extends Actor
{
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Player.class);

    private double healthPoints;
    private double manaPoints;
    private double actionPoints;

    /**
     * Instantiates a new player.
     */
    public Player()
    {
	// TODO Auto-generated constructor stub
	this.setHealthPoints(1000);
	this.setManaPoints(1000);
	this.setActionPoints(10);
    }

    public double getHealthPoints()
    {
	return healthPoints;
    }

    public void setHealthPoints(double healthPoints)
    {
	this.healthPoints = healthPoints;
    }

    public double getManaPoints()
    {
	return manaPoints;
    }

    public void setManaPoints(double manaPoints)
    {
	this.manaPoints = manaPoints;
    }

    public double getActionPoints()
    {
	return actionPoints;
    }

    public void setActionPoints(double actionPoints)
    {
	this.actionPoints = actionPoints;
    }
}
