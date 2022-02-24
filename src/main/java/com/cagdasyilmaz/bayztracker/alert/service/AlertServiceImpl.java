package com.cagdasyilmaz.bayztracker.alert.service;

import com.cagdasyilmaz.bayztracker.alert.repository.AlertRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {
	private final AlertRepository alertRepository;

	public AlertServiceImpl(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}
}
