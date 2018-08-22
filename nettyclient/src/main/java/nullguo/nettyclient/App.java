package nullguo.nettyclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Hello world!
 *
 */
public class App 
{ private static void initClient() {
    EventLoopGroup group = new NioEventLoopGroup();
    Bootstrap b = new Bootstrap();
    b.group(group)
        .channel(NioSocketChannel.class)
        .handler(new ChannelInitializer<SocketChannel>() {
          @Override
          public void initChannel(SocketChannel ch) throws Exception {
            ChannelPipeline p = ch.pipeline();
            p.addLast(new StringDecoder());
            p.addLast(new StringEncoder());
            p.addLast(new HelloClientHandler());
          }
        });
    try {
      b.connect("localhost",14567).sync().channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }  finally {  
        // Shut down the event loop to terminate all threads.  
  	  group.shutdownGracefully();  
    } 
  }
    public static void main( String[] args )
    {   
        System.out.println( "Hello World!" );
        initClient();
        System.out.println( "end" );
    }
}
