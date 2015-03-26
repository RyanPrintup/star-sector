package com.ryanprintup.starsector.datatypes;

import java.util.Map;

public class Variant
{
	private Object value;

	private Variant()
	{
	}
	
    public Variant(Object value) throws Exception
    {
        if (!(value == null ||
              value instanceof String ||
              value instanceof Double ||
              value instanceof Boolean ||
              value instanceof Byte ||
              value instanceof Variant[] ||
              value instanceof Map<?, ?>)) 
        {
            throw new Exception("Variants are unable to represent " + value.getClass().getName() + ".");
        }

        this.value = value;
    }

	public Object getValue()
	{
		return value;
	}
}
