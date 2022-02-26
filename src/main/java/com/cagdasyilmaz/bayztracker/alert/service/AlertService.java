package com.cagdasyilmaz.bayztracker.alert.service;

import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import java.util.List;
import java.util.UUID;

public interface AlertService {
	Alert getAlert(UUID alertId, String username);
	List<Alert> getAlerts();
	UUID createAlert(Alert alert, String username);
	void editAlert(UUID alertId, float targetPrice, String username);
	void deleteAlert(UUID alertId, String username);
	void cancelAlert(UUID alertId, String username);
	void acknowledgeAlert(UUID alertId, String username);
	void triggerAlert(UUID alertId);
}
