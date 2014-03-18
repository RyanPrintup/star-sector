/* 
 * Project Starlight
 * Copyright 2013, Opalium
 * Created by Opalium (TheOpalium@Gmail.com)
 * 
 *
 *  Project Starlight is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Project Starlight is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Project Starlight.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ryanprintup.starsector.net;

import java.awt.Point;

/**
 * @author Opalium
 * 
 */
public class PacketReader {

	private int position = 0;
	private final byte[] buffer;

	/**
	 * Class constructor
	 * 
	 * @param buffer
	 *        the byte array containing the packet data.
	 */
	public PacketReader(final byte[] buffer) {
		this.buffer = buffer;
	}

	/**
	 * Advances a number of bytes ahead.
	 * 
	 * @param count
	 *        the number of bytes to advance.
	 * 
	 * @return the position at which the advance started.
	 */
	private int checkedAdvance(final int count) {
		final int oldPosition = position;
		position += count;
		if (position >= buffer.length) {
			return -1;
		}
		return oldPosition;
	}

	/**
	 * Reads a byte.
	 * 
	 * @return the byte that was readBytes.
	 */
	public byte readByte() {
		return buffer[checkedAdvance(1)];
	}

	/**
	 * Checks how many bytes are remaining in the stream.
	 * 
	 * @return the number of bytes until the end of the stream.
	 */
	public long remaining() {
		return buffer.length - position;
	}

	/**
	 * Gets the current position of the stream.
	 */
	public long getPosition() {
		return position;
	}

	/**
	 * Advances a specified number of bytes ahead.
	 * 
	 * @param count
	 *        the number of bytes to skip.
	 * 
	 * @throws PacketFormatException
	 *         if the advance put the current position past the end of the
	 *         buffer.
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * 
	 */
	public void skip(final int count) {
		if (count >= 0) {
			checkedAdvance(count);
		}
	}

	/**
	 * 
	 * @param count
	 * @return
	 * @throws PacketFormatException
	 */
	private long readReverse(final int count) {

		final int start = checkedAdvance(count);
		final int end = position;
		long number = 0;
		for (int i = start; i < end; i++) {
			number <<= 8;
			number |= buffer[i] & 0xFF;
		}
		return number;

	}

	/**
	 * Reads a 32-bit integer.
	 * 
	 * @return the integer that was readBytes.
	 */
	public final int readInt() {
		return (int) (readReverse(4) & 0xFFFFFFFF);
	}

	/**
	 * Reads a short integer from the stream.
	 * 
	 * @return The short read.
	 */

	public final short readShort() {
		return (short) (readReverse(2) & 0xFFFF);
	}

	public final int readUShort() {
		int quest = readShort();
		if (quest < 0) { //questid 50000 and above, WILL cast to negative, this was tested.
			quest += 65536; //probably not the best fix, but whatever
		}
		return quest;
	}

	/**
	 * Reads a single character from the stream.
	 * 
	 * @return The character read.
	 */

	public final char readChar() {
		return (char) readShort();
	}

	/**
	 * Reads a long integer from the stream.
	 * 
	 * @return The long integer read.
	 */

	public final long readLong() {
		return readReverse(8);
	}

	/**
	 * Reads a floating point integer from the stream.
	 * 
	 * @return The float-type integer read.
	 */

	public final float readFloat() {
		return Float.intBitsToFloat(readInt());
	}

	/**
	 * Reads a double-precision integer from the stream.
	 * 
	 * @return The double-type integer read.
	 */

	public final double readDouble() {
		return Double.longBitsToDouble(readLong());
	}

	/**
	 * Reads a 32-bit potentially unsigned integer.
	 * 
	 * @return the integer that was readBytes.
	 */
	public final long readUnsignedInt() {
		return readReverse(4) & 0xFFFFFFFF;
	}

	/**
	 * Reads a 16-bit potentially unsigned integer.
	 * 
	 * @return the integer that was readBytes.
	 */
	public final int readUnsignedShort() {
		return (int) (readReverse(2) & 0xFFFF);
	}

	/**
	 * Reads an ASCII string from the stream with length <code>n</code>.
	 * 
	 * @param n
	 *        Number of characters to read.
	 * @return The string read.
	 */
	public final String readString(final int n) {
		final char ret[] = new char[n];
		for (int x = 0; x < n; x++) {
			ret[x] = (char) readByte();
		}
		return new String(ret);
	}

	/**
	 * Reads a length-prefixed ASCII string. This consists of a
	 * byte telling the length of the string, then the string itself.
	 * 
	 * @return The string read.
	 */

	public final String readPrefixedString() {
		byte length = readByte();
		if (length >= 0) {
			return readString(length);
		} else {
			return "";
		}
	}

	/**
	 * Reads a null-terminated string.
	 * 
	 * @return the string that was readBytes.
	 */
	public final String readNullTerminatedString() {
		final int start = position;
		final StringBuilder builder = new StringBuilder();
		int i = start;
		while (buffer[i = checkedAdvance(1)] != 0x00) {
			builder.append((char) buffer[i]);
		}
		return builder.toString();
	}

	/**
	 * Reads a position value. This consists of 2 shorts.
	 * 
	 * @return The Position read.
	 */

	public final Point readPoint() {
		final int x = readShort();
		final int y = readShort();
		return new Point(x, y);
	}

	/**
	 * Reads <code>num</code> bytes off the stream.
	 * 
	 * @param num
	 *        The number of bytes to read.
	 * @return An array of bytes with the length of <code>num</code>
	 */

	public final byte[] read(final int num) {
		byte[] ret = new byte[num];
		for (int x = 0; x < num; x++) {
			ret[x] = readByte();
		}
		return ret;
	}

	public long readVLQValue() {
		long n = 0;
		while (true) {
			int curByte = readByte() & 0xFF;
			n = (n << 7) | (curByte & 0x7F);
			if ((curByte & 0x80) == 0) {
				break;
			}
		}
		return n;
	}

	public byte[] readPrefixedArray() {
		byte length = readByte();
		if (length > 0 && length <= remaining()) {
			byte[] result = new byte[length];
			for (int i = 0; i < length; i++) {
				result[i] = readByte();
			}
			return result;
		}
		return null;
	}

	/**
	 * Seek the pointer to <code>offset</code>
	 * 
	 * @param offset
	 *        The offset to seek to.
	 */

	public final void seek(final long offset) {
		int newPos = (int) (position + offset);
		if (newPos <= buffer.length && newPos > 0) {
			position = newPos;
		}
	}
}