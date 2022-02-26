package com.cagdasyilmaz.bayztracker.alert.controller;

import com.cagdasyilmaz.bayztracker.alert.controller.mapper.AlertMapper;
import com.cagdasyilmaz.bayztracker.alert.controller.model.request.AlertCreateRequest;
import com.cagdasyilmaz.bayztracker.alert.controller.model.request.AlertEditRequest;
import com.cagdasyilmaz.bayztracker.alert.controller.model.response.AlertResponse;
import com.cagdasyilmaz.bayztracker.alert.service.AlertService;
import java.net.URI;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/alerts")
public class AlertController {
	private final AlertService alertService;

	public AlertController(AlertService alertService) {
		this.alertService = alertService;
	}

	@GetMapping("/{alertId}")
	public ResponseEntity<AlertResponse> getAlert(@PathVariable UUID alertId, @AuthenticationPrincipal
		String username) {
		return ResponseEntity.ok().body(AlertMapper.mapAlertToAlertResponse(alertService.getAlert(alertId, username)));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createAlert(@RequestBody @Validated AlertCreateRequest alertCreateRequest, @AuthenticationPrincipal
		String username) {
		UUID alertId = alertService
			.createAlert(AlertMapper.mapAlertCreateRequestToAlert(alertCreateRequest), username);
		return ResponseEntity.created(URI.create("/v1/alerts/" + alertId)).build();
	}

	@PutMapping("/edit/{alertId}")
	public ResponseEntity<UUID> editAlert(@PathVariable UUID alertId, @RequestBody AlertEditRequest alertEditRequest, @AuthenticationPrincipal
		String username) {
		alertService.editAlert(alertId, alertEditRequest.getTargetPrice(), username);
		return ResponseEntity.ok().body(alertId);
	}

	@DeleteMapping("/{alertId}")
	public ResponseEntity<String> deleteAlert(@PathVariable UUID alertId, @AuthenticationPrincipal
		String username) {
		alertService.deleteAlert(alertId, username);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/cancel/{alertId}")
	public ResponseEntity<UUID> cancelAlert(@PathVariable UUID alertId, @AuthenticationPrincipal
		String username) {
		alertService.cancelAlert(alertId, username);
		return ResponseEntity.ok().body(alertId);
	}

	@PutMapping("/ack/{alertId}")
	public ResponseEntity<UUID> acknowledgeAlert(@PathVariable UUID alertId, @AuthenticationPrincipal
		String username) {
		alertService.acknowledgeAlert(alertId, username);
		return ResponseEntity.ok().body(alertId);
	}
}
