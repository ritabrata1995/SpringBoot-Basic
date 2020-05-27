package com.example.edur.service;

import com.example.edur.model.Leave;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LeaveService {

    List<Leave> getLeaves();

    Leave getLeavebyID(UUID id);

    UUID addLeave(Leave leave);
}
