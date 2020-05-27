package com.example.edur.dao;

import com.example.edur.model.Leave;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("leaveDao")
public class LeaveDaoImpl implements LeaveDao {

    List<Leave> leaveList = new ArrayList<>();

    @Override
    public List<Leave> getLeaves() {
        return leaveList;
    }

    @Override
    public Leave getLeavebyID(UUID id) {

        return leaveList.stream()
                .filter(leave -> id.equals(leave.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Leave ID doesn't exist"));
    }

    @Override
    public UUID addLeave(Leave leave) {
        Leave lv = new Leave(UUID.randomUUID(), "Earn", 2);
        leaveList.add(lv);
        return lv.getId();
    }
}
