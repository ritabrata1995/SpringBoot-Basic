package com.example.edur.dao;

import com.example.edur.model.Leave;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveDao {

    List<Leave> getLeaves();

    Optional<Leave> getLeavebyID(UUID id);
}
