package com.ryanprintup.starsector.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author "ThisCouldBeBetter"
 * Source: http://thiscouldbebetter.wordpress.com/2011/08/26/compressing-and-uncompressing-data-in-java-using-zlib/
 * Modified By: Ryan Printup
 */
public class ZlibCompressor
{
	/**
	 * Starbound uses Zlib compression on data
	 * so we have to uncompress it to read it
	 * and compress it to send it
	 */
	
	public byte[] compress(final byte[] bytesToCompress) {
		Deflater deflater = new Deflater();
		deflater.setInput(bytesToCompress);
		deflater.finish();

		byte[] bytesCompressed = new byte[Short.MAX_VALUE];
		int numberOfBytesAfterCompression = deflater.deflate(bytesCompressed);
		byte[] returnValues = new byte[numberOfBytesAfterCompression];

		System.arraycopy(bytesCompressed, 0, returnValues, 0, numberOfBytesAfterCompression);
		return returnValues;
	}

	public byte[] compress(final String stringToCompress) {
		byte[] returnValues = null;
		try {
			returnValues = this.compress(stringToCompress.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}

		return returnValues;
	}

	public byte[] decompress(final byte[] bytesToDecompress, final int maxLength) {
		byte[] returnValues = null;
		Inflater inflater = new Inflater();

		int numberOfBytesToDecompress = bytesToDecompress.length;
		inflater.setInput(bytesToDecompress, 0, numberOfBytesToDecompress);
		int bufferSizeInBytes = numberOfBytesToDecompress;
		int numberOfBytesDecompressedSoFar = 0;
		List<Byte> bytesDecompressedSoFar = new ArrayList<Byte>();

		try {
			while (inflater.needsInput() == false) {
				byte[] bytesDecompressedBuffer = new byte[bufferSizeInBytes];
				int numberOfBytesDecompressedThisTime = inflater.inflate(bytesDecompressedBuffer);
				numberOfBytesDecompressedSoFar += numberOfBytesDecompressedThisTime;
				for (int b = 0; b < numberOfBytesDecompressedThisTime; b++) {
					bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
				}
				if (numberOfBytesDecompressedSoFar == maxLength) {
					break;
				}
			}
			returnValues = new byte[bytesDecompressedSoFar.size()];
			for (int b = 0; b < returnValues.length; b++) {
				returnValues[b] = (bytesDecompressedSoFar.get(b));
			}
		} catch (DataFormatException e) {
			e.printStackTrace();
		}

		inflater.end();
		return returnValues;
	}

	public byte[] decompress(final byte[] bytesToDecompress) {
		byte[] returnValues = null;
		Inflater inflater = new Inflater();

		int numberOfBytesToDecompress = bytesToDecompress.length;
		inflater.setInput(bytesToDecompress, 0, numberOfBytesToDecompress);
		int bufferSizeInBytes = numberOfBytesToDecompress;
		int numberOfBytesDecompressedSoFar = 0;
		List<Byte> bytesDecompressedSoFar = new ArrayList<Byte>();

		try {
			while (inflater.needsInput() == false) {
				byte[] bytesDecompressedBuffer = new byte[bufferSizeInBytes];
				int numberOfBytesDecompressedThisTime = inflater.inflate(bytesDecompressedBuffer);
				numberOfBytesDecompressedSoFar += numberOfBytesDecompressedThisTime;
				for (int b = 0; b < numberOfBytesDecompressedThisTime; b++) {
					bytesDecompressedSoFar.add(bytesDecompressedBuffer[b]);
				}
			}
			returnValues = new byte[bytesDecompressedSoFar.size()];
			for (int b = 0; b < returnValues.length; b++) {
				returnValues[b] = (bytesDecompressedSoFar.get(b));
			}
		} catch (DataFormatException e) {
			e.printStackTrace();
		}

		inflater.end();
		return returnValues;
	}

	public String decompressToString(final byte[] bytesToDecompress) {
		byte[] bytesDecompressed = decompress(bytesToDecompress);
		String returnValue = null;
		try {
			returnValue = new String(bytesDecompressed, 0, bytesDecompressed.length, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
}