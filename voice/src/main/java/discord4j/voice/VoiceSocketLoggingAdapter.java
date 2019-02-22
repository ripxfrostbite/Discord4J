package discord4j.voice;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import reactor.util.Logger;
import reactor.util.Loggers;

class VoiceSocketLoggingAdapter extends ChannelOutboundHandlerAdapter {

    private static final Logger LOG = Loggers.getLogger("discord4j.voice.udp.outbound");

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (LOG.isTraceEnabled()) {
            ByteBuf buf = ((ByteBuf) msg).slice(0, PacketTransformer.RTP_HEADER_LENGTH);
            LOG.trace(ByteBufUtil.hexDump(buf));
        }
        super.write(ctx, msg, promise);
    }
}
