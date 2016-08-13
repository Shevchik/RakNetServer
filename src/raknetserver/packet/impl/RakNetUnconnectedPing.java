package raknetserver.packet.impl;

import io.netty.buffer.ByteBuf;
import raknetserver.packet.RakNetConstants;
import raknetserver.packet.RakNetPacket;

public class RakNetUnconnectedPing implements RakNetPacket {

	private long clientTime;

	@Override
	public void decode(ByteBuf buf) {
		this.clientTime = buf.readLong();
		buf.skipBytes(RakNetConstants.MAGIC.length);
		buf.skipBytes(8); //guid
	}

	@Override
	public void encode(ByteBuf buf) {
		throw new UnsupportedOperationException();
	}

	public long getClientTime() {
		return clientTime;
	}

}
