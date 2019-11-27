package com.dmm.service;

import com.dmm.dao.UserRelationRepository;
import com.dmm.pojo.UserRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DMM
 * @create 2019/10/9
 */
@Service
public class UserRelationService {

    @Autowired
    private UserRelationRepository userRelationRepository;

    public List<UserRelation> addUserNode(UserRelation userRelation){
        //userRelationRepository.
        return userRelationRepository.addUserRelation(userRelation.getStartNode().getName(),userRelation.getEndNode().getName());
    }

    public List<UserRelation> findUserNode(UserRelation userRelation){
        //userRelationRepository.
        return userRelationRepository.findUserRelationByEachId(userRelation.getStartNode().getName(),userRelation.getEndNode().getName());
    }
}

