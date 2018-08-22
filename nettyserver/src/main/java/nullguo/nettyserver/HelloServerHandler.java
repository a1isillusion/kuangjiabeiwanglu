package nullguo.nettyserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloServerHandler extends ChannelInboundHandlerAdapter {
	  @Override
	  public void channelRead(ChannelHandlerContext ctx, Object msg) {

	    if (msg.toString().startsWith("get")) {
	      String result = new HelloServiceImpl()
	          .hello(msg.toString());
	      ctx.writeAndFlush(result);
	    
	    }
	  }
	}
