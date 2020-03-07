package com.example.ZookeeperStudy;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

public class Demo2 {
    private static final int TIMEOUT=3000;
    private static Watcher getWatcher(final String msg){
        return new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                System.out.println(msg+"\t"+event.getType().name());
            }
        };
    }

    public static void main(String[] args) throws IOException{
        //建立连接，触发Watcher
        ZooKeeper zkp=new ZooKeeper("172.16.247.132:2181",TIMEOUT,getWatcher("Connection changed"));
        try{
            zkp.create("/node1", "data1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zkp.exists("/node1", getWatcher("Existence changed"));
            Stat stat=new Stat();
            //getData时获取version，因为在setData和delete时需要提供正确的version
            byte[] data=zkp.getData("/node1", getWatcher("Nodedata changed"), stat);
            System.out.println("NodeData is:"+ new String(data));
            zkp.getChildren("/", getWatcher("Children changed"));
            //setData触发exists、getData中的Watcher。setData时会改为version，所以注意要获取新的version
            stat=zkp.setData("/node1","newdata".getBytes(), stat.getVersion());
            //delete触发exists、getData、getChildren中的Watcher
            zkp.delete("/node1", stat.getVersion());
            zkp.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}