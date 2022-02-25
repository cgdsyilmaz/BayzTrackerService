package com.cagdasyilmaz.bayztracker.alert.service;

import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import java.util.List;
import java.util.UUID;

public interface AlertService {
	Alert getAlert(UUID alertId);
	List<Alert> getAlerts();
	UUID createAlert(Alert alert);
	void editAlert(UUID alertId, float targetPrice);
	void deleteAlert(UUID alertId);
	void cancelAlert(UUID alertId);
	void acknowledgeAlert(UUID alertId);
	void triggerAlert(UUID alertId);
}
