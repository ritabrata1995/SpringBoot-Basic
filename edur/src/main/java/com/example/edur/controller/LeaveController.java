package com.example.edur.controller;


import com.example.edur.model.Leave;
import com.example.edur.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class LeaveController {

	private final LeaveService leaveService;

	@Autowired
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	
	@GetMapping(value = "/leaves")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_EMPLOYEE')")
	public List<Leave> getAllLeaves() {
		return leaveService.getLeaves();
	}

	@GetMapping(value = "/leave/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_EMPLOYEE')")
	public Leave getLeave(@NotNull @PathVariable("id") UUID id) {
		return leaveService.getLeavebyID(id);
	}

	@PostMapping(value = "/addLeave")
	@PreAuthorize("hasAuthority('employee:write')")
	public UUID addLeave(@NotNull @Valid @RequestBody Leave leave) {
		return leaveService.addLeave(leave);
	}

}
