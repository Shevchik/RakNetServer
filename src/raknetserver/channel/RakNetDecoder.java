package raknetserver.channel;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToMessageDecoder;
import raknetserver.packet.RakNetPacket;
import raknetserver.packet.RakNetPacketRegistry;

public class RakNetDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> list) throws Exception {
		if (!buffer.isReadable()) {
			return;
		}
		RakNetPacket packet = RakNetPacketRegistry.getPacket(buffer.readUnsignedByte());
		packet.decode(buffer);
		if (buffer.readableBytes() > 0) {
			throw new DecoderException(buffer.readableBytes() + " bytes left after decoding packet " + packet.getClass().getName());
		}
		list.add(packet);
	}

}
