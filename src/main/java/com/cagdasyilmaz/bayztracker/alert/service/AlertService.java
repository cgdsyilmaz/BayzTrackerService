package com.cagdasyilmaz.bayztracker.alert.service;

import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import java.util.UUID;

public interface AlertService {
	Alert getAlert(UUID alertId);
	UUID createAlert(Alert alert);
	void editAlert(UUID alertId, float targetPrice);
	void deleteAlert(UUID alertId);
	void cancelAlert(UUID alertId);
	void acknowledgeAlert(UUID alertId);
}
