package com.tianxing;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by tianxing on 16/11/21.
 */
public class DisruptorTest {








    /**
     * 发布事件
     * */
    public void publish(){

    }



    /**
     * 需要传递的事件
     * */
    private class StringEvent{
        private String a = "a";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    /**
     * 事件工厂 用于实例化事件
     * */
    private class StringEventFactory implements EventFactory<StringEvent>{


        @Override
        public StringEvent newInstance() {
            return new StringEvent();
        }
    }

    /**
     * 事件消费者
     * */
    private class StringEventHandler implements EventHandler<StringEvent>{


        @Override
        public void onEvent(StringEvent event, long sequence, boolean endOfBatch) throws Exception {

        }
    }


    /**
     * 事件生成
     * */
    private class StringEventProducer{
        private final RingBuffer<StringEvent> ringBuffer;

        public StringEventProducer(RingBuffer<StringEvent> ringBuffer){
            this.ringBuffer = ringBuffer;
        }


        /**
         * 发布事件
         * */
        public void onData(StringEvent stringEvent){
            //取得一个空事件槽
            Long sequence = ringBuffer.next();

            try {
                //用取得的索引取得一个新的事件 用于填充
                StringEvent event = ringBuffer.get(sequence);
                event.setA(stringEvent.getA());
            } finally {
                //发布事件
                ringBuffer.publish(sequence);
            }
        }
    }



//    public class LongEventProducerWithTranslator {
//        //一个translator可以看做一个事件初始化器，publicEvent方法会调用它
//        //填充Event
//        private final EventTranslatorOneArg<StringEvent, ByteBuffer> TRANSLATOR =
//                new EventTranslatorOneArg<StringEvent, ByteBuffer>() {
//                    public void translateTo(StringEvent event, long sequence, ByteBuffer bb) {
//                        event.setA(bb.get());
//                    }
//                };
//        private final RingBuffer<StringEvent> ringBuffer;
//        public LongEventProducerWithTranslator(RingBuffer<StringEvent> ringBuffer) {
//            this.ringBuffer = ringBuffer;
//        }
//
//        public void onData(ByteBuffer bb) {
//            ringBuffer.publishEvent(TRANSLATOR, bb);
//        }
//    }




    /***
     * 启动入口
     * */
    public void start(){
        Executor executor = Executors.newCachedThreadPool();
        ThreadFactory threadFactory = new DefaultThreadFactory("factory");
        StringEventFactory eventFactory = new StringEventFactory();
        int bufferSize = 1024;//指定ring buffer 容量 2的倍数
        Disruptor<StringEvent> disruptor = new Disruptor<StringEvent>(eventFactory, bufferSize, threadFactory);//构建disruptor
        disruptor.handleEventsWith(new StringEventHandler());
        disruptor.start();

        RingBuffer<StringEvent> ringBuffer = disruptor.getRingBuffer();

        StringEventProducer producer = new StringEventProducer(ringBuffer);

        ByteBuffer buffer = ByteBuffer.allocate(8);

        //发布事件
        //buffer.putLong()

    }


}
