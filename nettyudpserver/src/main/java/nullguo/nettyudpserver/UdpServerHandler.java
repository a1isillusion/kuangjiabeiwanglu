package nullguo.nettyudpserver;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class UdpServerHandler  extends SimpleChannelInboundHandler<DatagramPacket> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
		// TODO Auto-generated method stub
        String req = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if ("get".equals(req)) {
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(
                    "服务器时间:"+System.currentTimeMillis(), CharsetUtil.UTF_8), msg.sender()));
        }
	}

}
