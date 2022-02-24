package com.cagdasyilmaz.bayztracker.alert.repository;

import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, UUID> {
	Optional<Alert> findAlertByAlertId(UUID alertId);
	Optional<Alert> deleteAlertByAlertId(UUID alertId);
}
