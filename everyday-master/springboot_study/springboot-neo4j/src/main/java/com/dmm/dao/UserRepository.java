package com.dmm.dao;

import com.dmm.pojo.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * dao层操作
 * @author DMM
 * @create 2019/10/9
 */
@Component
public interface UserRepository extends Neo4jRepository<UserNode,Long> {

    //查询节点实体
    @Query("match (n:User) RETURN n")
    List<UserNode> getUserNodeList();
    //创建节点实体
    @Query("create (n:User{name:{name},age:{age}}) return n")
    List<UserNode> addUserNodeList(@Param("name") String name,@Param("age") int age);

}

