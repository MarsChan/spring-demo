package pers.marscheng.spring.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
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

        ByteBuffer buffer = ByteBuffer.allocate(0x300000);




        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(path);
            for(Path p : ds){
                System.out.println(p);
                AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(p,
                        EnumSet.of(StandardOpenOption.READ),pool);


                dealFile(buffer,asynchronousFileChannel,0);

                System.out.println("===========main thread test=========================");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void dealFile(ByteBuffer buffer,AsynchronousFileChannel
            asynchronousFileChannel,long position){
        CompletionHandler<Integer,Map<String,Object>> handler = new CompletionHandler<Integer,
                Map<String,Object>>
                () {
            @Override
            public void completed(Integer result, Map<String,Object> attachment) {
                System.out.println("result"+result);
                ByteBuffer buffer1 = (ByteBuffer)attachment.get("buffer");
                long position = (long)attachment.get("position")+buffer1.capacity();
                buffer1.flip();
                byte[] data = new byte[buffer1.limit()];
                buffer1.get(data);
                System.out.println(new String(data));
                buffer1.clear();

                try {
                    if(position<asynchronousFileChannel.size()){ //判断是否读完数据
                        dealFile(buffer1,asynchronousFileChannel,position);
                    }
                    else{
                        System.out.println("=====success!!=======size="+asynchronousFileChannel.size
                                ());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Map<String,Object> attachment) {
                ByteBuffer buffer1 = (ByteBuffer)attachment.get("buffer");
                long position = (long)attachment.get("position")+buffer1.capacity();

                System.out.println("error"+exc);
                try {
                    if(position<asynchronousFileChannel.size()){
                        dealFile(buffer1,asynchronousFileChannel,position);
                    }
                    else{
                        System.out.println("=====success!!=======size="+asynchronousFileChannel
                                .size());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        Map<String,Object> temp = new HashMap<>();
        temp.put("position",position);
        temp.put("buffer",buffer);
        System.out.println("postion"+position);
        asynchronousFileChannel.read(buffer,position,temp,handler);
    }
}
