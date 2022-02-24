package com.cagdasyilmaz.bayztracker.alert.controller;

import com.cagdasyilmaz.bayztracker.alert.service.AlertService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
public class AlertController {
	private final AlertService alertService;

	public AlertController(AlertService alertService) {
		this.alertService = alertService;
	}

	@PutMapping("/create")
	public ResponseEntity<UUID> createAlarm(@RequestBody @Validated AlarmCreateRequest alarmCreateRequest) {
		return 
	}
}
