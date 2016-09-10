package org.locxar.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Enum Type.
 * 
 * @author LocXar
 */
public enum Type
{

    /** The player. */
    PLAYER(0),
    /** The npc. */
    NPC(1);

    private final static Logger slf4jLogger = LoggerFactory.getLogger(Type.class);
    
    /** The type. */
    private int type;

    /**
     * Instantiates a new type.
     *
     * @param id
     *            the id
     */
    Type(int id)
    {
	this.type = id;
    }

    /**
     * Gets the type id.
     *
     * @return the type id
     */
    public int getTypeId()
    {
	return this.type;
    }
}