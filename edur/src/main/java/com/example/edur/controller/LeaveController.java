package com.example.edur.controller;

import com.example.edur.model.Leave;
import com.example.edur.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class LeaveController {

	private final LeaveService leaveService;

	@Autowired
	public LeaveController(LeaveService leaveService) {
		this.leaveService = leaveService;
	}
	
	@GetMapping(value = "/leaves")
	public List<Leave> getAllLeaves() {
		return leaveService.getLeaves();
	}

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

}
