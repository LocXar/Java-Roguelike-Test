/**
 * 
 */
package org.locxar.core.map;

import java.util.Map;

/**
 * @author LocXar
 *
 */
public class MapGenerator
{

    /**
     * 
     */
    public MapGenerator()
    {
	// TODO Auto-generated constructor stub
	
    }
    
    public Map generateTestMap(Map<Location, String> map)
    {
	for(int i = 0; i <= 256; i++) // Zeilen
	{
	    for (int j = 0; j <= 256; j++) // Spalten
	    {
		if(i == 0 || i == 256 || j == 0 || j == 256)
		{
		    map.put(new Location(i, j), "#");
		}
		else
		{
		    map.put(new Location(i, j), ".");
		}
	    }
	}
	return map;
    }
}
