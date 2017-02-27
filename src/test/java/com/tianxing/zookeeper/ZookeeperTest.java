package com.tianxing.zookeeper;


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by tianxing on 17/2/21.
 *
 */
public class ZookeeperTest {

    public static void main(String[] args) {
        try {

            ZooKeeper zooKeeper = new ZooKeeper("", 1500, new mWatcher());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class mWatcher implements Watcher {

        @Override
        public void process(WatchedEvent event) {

        }
    }



}
