package com.example.edur.dao;

import com.example.edur.model.Leave;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("leaveDao")
public class LeaveDaoImpl implements LeaveDao {



    private static List<Leave> addLeave(){

        List<Leave> leaveList = new ArrayList<>();

        Leave l1 = new Leave( UUID.randomUUID(), "Earn", 2);

        Leave l2 = new Leave( UUID.randomUUID(), "Casual", 2);

        leaveList.add(l1);

        leaveList.add(l2);

        return leaveList;
    }

    List<Leave> finalList = addLeave();

    @Override
    public List<Leave> getLeaves() {

        List<Leave> allLeaves = finalList;
        return allLeaves;
    }

    @Override
    public Optional<Leave> getLeavebyID(UUID id) {

        List<Leave> getLeave = finalList;

        System.out.println("DAO Incoming Value: " +  id);

        System.out.println("DAO filtered value: " + getLeave
                .stream()
                .filter(leave -> leave.getId().equals(id))
                .findFirst());

        return getLeave
                .stream()
                .filter(leave -> leave.getId().equals(id))
                .findFirst();
    }
}
