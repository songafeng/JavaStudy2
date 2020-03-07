package com.example.ZookeeperStudy;
import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

public class Demo3 {
    private static final int TIMEOUT=3000;
    private static Watcher getWatcher(){
        return new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.toString());
            }
        };
    }

    public static void main(String[] args) throws IOException{
        ZooKeeper zkp=new ZooKeeper("172.16.247.132:2181",TIMEOUT,null);
        try{
            //一次性注意Watcher zkp.register(getWatcher());
            zkp.create("/node1", "data1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Stat stat=new Stat();
            byte[] data=zkp.getData("/node1", false, stat);
            zkp.exists("/node1", false);
            zkp.getChildren("/", false);
            System.out.println("NodeData is:"+ new String(data));
            stat=zkp.setData("/node1", "newdata".getBytes(), stat.getVersion());
            zkp.delete("/node1", stat.getVersion());
            zkp.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
