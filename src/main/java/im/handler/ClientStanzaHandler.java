package im.handler;

import im.message.IQ;
import im.message.Message;
import im.message.Presence;

/**
 * Created by tianxing on 16/12/14.
 *
 *
 *
 */
public class ClientStanzaHandler extends StanzaHandler{



    @Override
    void processIQ(IQ packet) {

    }

    @Override
    void processPresence(Presence packet) {

    }

    @Override
    void processMessage(Message packet) {

    }

    @Override
    boolean createSession() {
        return false;
    }
}
