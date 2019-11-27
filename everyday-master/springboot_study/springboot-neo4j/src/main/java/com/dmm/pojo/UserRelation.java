package com.dmm.pojo;

import org.neo4j.ogm.annotation.*;

/**
 *
 * 关系实体类
 * @author DMM
 * @create 2019/10/9
 */

@RelationshipEntity(type = "UserRelation")
public class UserRelation {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private UserNode startNode;
    @EndNode
    private UserNode endNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserNode getStartNode() {
        return startNode;
    }

    public void setStartNode(UserNode startNode) {
        this.startNode = startNode;
    }

    public UserNode getEndNode() {
        return endNode;
    }

    public void setEndNode(UserNode endNode) {
        this.endNode = endNode;
    }
}

