package com.cagdasyilmaz.bayztracker.alert.service;

import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import com.cagdasyilmaz.bayztracker.alert.entity.AlertStatus;
import com.cagdasyilmaz.bayztracker.alert.exception.IllegalAlertStatusChangeException;
import com.cagdasyilmaz.bayztracker.alert.exception.InvalidAlertTargetPriceException;
import com.cagdasyilmaz.bayztracker.alert.exception.NoSuchAlertException;
import com.cagdasyilmaz.bayztracker.alert.repository.AlertRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertServiceImpl implements AlertService {
	private final AlertRepository alertRepository;

	public AlertServiceImpl(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}

	@Override
	public Alert getAlert(UUID alertId, String username) {
		return alertRepository.findAlertByAlertIdAndUsername(alertId, username).orElseThrow(() -> new NoSuchAlertException(alertId));
	}

	@Override
	public List<Alert> getAlerts() {
		return alertRepository.findAll();
	}

	@Override
	@Transactional
	public UUID createAlert(Alert alert, String username) {
		validatePrice(alert.getTargetPrice());
		setAlertProperties(alert, username);

		alertRepository.save(alert);
		return alert.getAlertId();
	}

	private void validatePrice(float targetPrice) {
		if (targetPrice < 0) {
			throw new InvalidAlertTargetPriceException(targetPrice);
		}
	}

	private void setAlertProperties(Alert alert, String username) {
		alert.setCurrency(alert.getCurrency().toUpperCase());
		alert.setAlertId(UUID.randomUUID());
		alert.setCreatedAt(LocalDateTime.now());
		alert.setUsername(username);
		alert.setStatus(AlertStatus.NEW);
	}

	@Override
	@Transactional
	public void editAlert(UUID alertId, float targetPrice, String username) {
		validatePrice(targetPrice);

		Alert alert = alertRepository.findAlertByAlertIdAndUsername(alertId, username).orElseThrow(() -> new NoSuchAlertException(alertId));

		alert.setTargetPrice(targetPrice);
		alert.setStatus(AlertStatus.NEW);
	}

	@Override
	@Transactional
	public void deleteAlert(UUID alertId, String username) {
		alertRepository.deleteAlertByAlertIdAndUsername(alertId, username).orElseThrow(() -> new NoSuchAlertException(alertId));
	}

	@Override
	@Transactional
	public void cancelAlert(UUID alertId, String username) {
		Alert alert = alertRepository.findAlertByAlertIdAndUsername(alertId, username).orElseThrow(() -> new NoSuchAlertException(alertId));

		if (alert.getStatus() != AlertStatus.NEW) {
			throw new IllegalAlertStatusChangeException(alert.getStatus().getAlertText(), AlertStatus.CANCELLED.getAlertText());
		}

		alert.setStatus(AlertStatus.CANCELLED);
	}

	@Override
	@Transactional
	public void acknowledgeAlert(UUID alertId, String username) {
		Alert alert = alertRepository.findAlertByAlertIdAndUsername(alertId, username).orElseThrow(() -> new NoSuchAlertException(alertId));

		if (alert.getStatus() != AlertStatus.TRIGGERED) {
			throw new IllegalAlertStatusChangeException(alert.getStatus().getAlertText(), AlertStatus.ACKED.getAlertText());
		}

		alert.setStatus(AlertStatus.ACKED);
	}

	@Override
	@Transactional
	public void triggerAlert(UUID alertId) {
		Alert alert = alertRepository.findAlertByAlertId(alertId).orElseThrow(() -> new NoSuchAlertException(alertId));

		if (alert.getStatus() != AlertStatus.NEW) {
			throw new IllegalAlertStatusChangeException(alert.getStatus().getAlertText(), AlertStatus.TRIGGERED.getAlertText());
		}

		alert.setStatus(AlertStatus.TRIGGERED);
	}
}
