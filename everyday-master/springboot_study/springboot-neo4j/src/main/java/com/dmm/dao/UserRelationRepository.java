package com.dmm.dao;

import com.dmm.pojo.UserRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author DMM
 * @create 2019/10/9
 */
@Component
public interface UserRelationRepository extends Neo4jRepository<UserRelation,Long> {

    //查询节点实体关系
    @Query("match p=(n:User) <-[r:UserRelation]->(n1:User) where n.name={firstUserId} and n1.name={secondUserId} return p")
    List<UserRelation> findUserRelationByEachId(@Param("firstUserId") String firstUserId,@Param("secondUserId") String secondUserId);
    //关联节点实体关系
    @Query("match (fu:User),(su:User) where fu.name={firstUserId} and su.name={secondUserId} create p=(fu)-[r:UserRelation]->(su) return p")
    List<UserRelation> addUserRelation(@Param("firstUserId") String firstUserId,@Param("secondUserId") String secondUserId);
}

