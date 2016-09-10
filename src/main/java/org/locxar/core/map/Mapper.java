/**
 * 
 */
package org.locxar.core.map;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LocXar
 *
 */
public class Mapper
{
    private final static Logger slf4jLogger = LoggerFactory.getLogger(Mapper.class);
    Map<Location, String> map;

	    /**
	     * 
	     */
    public Mapper()
    {
	// TODO Auto-generated constructor stub
	this.map = new HashMap<Location, String>();
    }
    
    public Mapper(Map<Location, String> map)
    {
	this.map = map;
    }

    public Map<Location, String> getMap()
    {
	return this.map;
    }
    
    public void setMap(Map map)
    {
	this.map = map;
    }

    public void addLocation(Location loc, String s)
    {
	if(map.containsKey(loc))
	{
	    this.map.put(loc, s);
	}
	else
	{
	    slf4jLogger.error("Location found!");
	}
    }
}
