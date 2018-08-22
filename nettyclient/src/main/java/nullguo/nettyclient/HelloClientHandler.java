package nullguo.nettyclient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloClientHandler extends ChannelInboundHandlerAdapter {

	  /**
	   * 收到服务端数据，唤醒等待线程
	   */
	public static int count=0;
	  @Override
	  public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) {
	    System.out.println("收到"+msg.toString());
	    ctx.channel().writeAndFlush("get在测试"+count++);
	    if(count>10)ctx.channel().close();
	  }
	   @Override    
	    public void channelActive(ChannelHandlerContext ctx) throws Exception {    
	        String msg = "gethello Server!";         
	        ctx.write(msg);    
	        ctx.flush();    
	    }    

	}
