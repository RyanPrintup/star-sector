package org.json.simple;

import java.io.StringWriter;

/**
 * Used to write pretty-print JSON
 */
public class JSONWriter extends StringWriter
{
    private int indent = 0;

    @Override
    public void write(int c)
    {
    	switch ((char) c) {
    		case '[':
    		case '{':
    			super.write(c);
    			super.write('\n');
    			
    			indent++;
    			writeIndentation();
    			break;
    		case ',':
    			super.write(c);
    			super.write('\n');
    			
    			writeIndentation();
    			break;
    		case ':':
    			super.write(c);
    			super.write(' ');
    			
    			break;
    		case ']':
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