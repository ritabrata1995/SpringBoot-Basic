package com.example.edur.service;

import com.example.edur.dao.LeaveDao;
import com.example.edur.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveServiceImpl implements  LeaveService {

    private final LeaveDao leaveDao;

    @Autowired
    public LeaveServiceImpl(@Qualifier(value = "leaveDao") LeaveDao leaveDao){
        this.leaveDao = leaveDao;
    }

    @Override
    public List<Leave> getLeaves() {
        return leaveDao.getLeaves();
    }
}
