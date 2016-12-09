package im.handler;

import im.auth.UnauthorizedException;
import im.message.IQ;
import im.message.Packet;

/**
 * Created by tianxing on 16/12/9.
 *
 * 处理info/query数据包
 *
 */
public abstract class IQHandler {





    public void process(Packet packet){

    }




    public abstract void handleIQ(IQ iq) throws UnauthorizedException;




}
