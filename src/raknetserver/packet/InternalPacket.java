package raknetserver.packet;

import io.netty.buffer.ByteBuf;

public interface InternalPacket {

	public void decode(ByteBuf buf);

	public void encode(ByteBuf buf);

}
