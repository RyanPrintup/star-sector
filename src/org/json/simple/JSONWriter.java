package org.json.simple;

import java.io.StringWriter;

/**
 * Used to write pretty-print JSON
 * 
 * Example of output:
 * 
 * {
 *    "Key": "value",
 *    "Array": [ "One", "Two", "Three" ],
 *    "Object": {
 *       "Key": 1
 *    }
 * }
 */
public class JSONWriter extends StringWriter
{
    private int indent = 0;
    private boolean inArray = false;
    
    @Override
    public void write(int c)
    {
    	switch ((char) c) {
    		case '{':
    			super.write(c);
    			super.write('\n');
    			
    			indent++;
    			writeIndentation();
    			break;
    		case '[':
    			inArray = true;
    			
    			super.write(c);
    			super.write(' ');
    			
    			break;
    		case ',':
    			super.write(c);
    			
    			if (!inArray) {
    				super.write('\n');
    				writeIndentation();
    			} else {
    				super.write(' ');
    			}
    			
    			break;
    		case ':':
    			super.write(c);
    			super.write(' ');
    			
    			break;
    		case ']':
    			inArray = false;
    			
    			super.write(' ');
    			super.write(c);
    			
    			break;
    		case '}':
    			super.write('\n');
    			
    			indent--;
    			writeIndentation();
    			
    			super.write(c);
    			break;
    		default:
    			super.write(c);
    	}
    }

    private void writeIndentation()
    {
        for (int i = 0; i < indent; i++) {
            super.write("   ");
        }
    }
}