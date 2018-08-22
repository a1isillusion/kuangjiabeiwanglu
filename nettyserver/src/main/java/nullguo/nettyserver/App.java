package nullguo.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Hello world!
 *
 */
public class App 
{ private static void startServer0(int port) {
    NioEventLoopGroup bosseventLoopGroup = new NioEventLoopGroup();
    NioEventLoopGroup childeventLoopGroup = new NioEventLoopGroup();
	try {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bosseventLoopGroup,childeventLoopGroup)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
              @Override
              protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline p = ch.pipeline();
                p.addLast(new StringDecoder());
                p.addLast(new StringEncoder());
                p.addLast(new HelloServerHandler());
              }
            });
        bootstrap.bind(port).sync().channel().closeFuture().sync();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {  
          // Shut down the event loop to terminate all threads.  
    	  bosseventLoopGroup.shutdownGracefully();  
    	  childeventLoopGroup.shutdownGracefully();
      }  
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        startServer0(14567);
        System.out.println("finish");
    }
}
