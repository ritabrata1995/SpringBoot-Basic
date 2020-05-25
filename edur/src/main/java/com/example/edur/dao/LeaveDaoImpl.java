package com.example.edur.dao;

import com.example.edur.model.Leave;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("leaveDao")
public class LeaveDaoImpl implements LeaveDao {

    @Override
    public List<Leave> getLeaves() {

        Leave l1 = new Leave( UUID.randomUUID(), "Earn", 2);

        List<Leave> leaveList = new ArrayList<>();

        leaveList.add(l1);
        return leaveList;
    }
}
