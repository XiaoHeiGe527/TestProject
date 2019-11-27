package com.dmm.pojo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 *
 * 节点实体
 * //表示节点类型
 * //节点的名称
 * @author DMM
 * @create 2019/10/9
 */

@NodeEntity(label = "User")
public class UserNode {

    //节点的id
    @Id
    @GeneratedValue
    private Long nodeId;
    //用户的id
    @Property
    private String userId;
    @Property
    private String name;
    @Property
    private int age;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

