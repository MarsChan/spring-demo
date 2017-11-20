package pers.marscheng.spring.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 大excel文件读取测试类
 *
 * @author marscheng
 * @create 2017-11-20 下午3:29
 */
public class FileImportTest {
    public static void main(String[] args){
        ExecutorService pool = new ScheduledThreadPoolExecutor(3);
        String basePath = FileImportTest.class.getResource("/").getPath();
        Path path = Paths.get(basePath+"/statics");

        ByteBuffer buffer = ByteBuffer.allocate(1024);




        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(path);
            for(Path p : ds){
                System.out.println(p);
                AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(p,
                        EnumSet.of(StandardOpenOption.READ),pool);
                CompletionHandler<Integer,ByteBuffer> handler = new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        System.out.println("result"+result);

                        attachment.flip();
                        byte[] data = new byte[attachment.limit()];
                        attachment.get(data);
                        System.out.println(new String(data));
                        attachment.clear();
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        System.out.println("error"+exc);
                    }
                };

                asynchronousFileChannel.read(buffer,0,buffer,handler);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
