package im.offlineMessage;

/**
 * Created by tianxing on 16/11/26.
 *
 * 离线消息处理策略
 *
 */
public class OfflineMessageStrategy {





































    /**
     * Strategy types.
     */
    public enum Type {

        /**
         * All messages are bounced to the sender.
         */
        bounce,

        /**
         * All messages are silently dropped.
         */
        drop,

        /**
         * All messages are stored.
         */
        store,

        /**
         * Messages are stored up to the storage limit, and then bounced.
         */
        store_and_bounce,

        /**
         * Messages are stored up to the storage limit, and then silently dropped.
         */
        store_and_drop
    }

}
