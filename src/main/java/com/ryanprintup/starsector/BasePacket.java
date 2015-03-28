package com.ryanprintup.starsector;

import com.ryanprintup.starsector.net.BufferStream;

public interface BasePacket
{
    public void read(BufferStream stream);

    public void write(BufferStream stream);

    public byte getId();
}

