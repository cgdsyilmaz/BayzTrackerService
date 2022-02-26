package com.cagdasyilmaz.bayztracker.alert.entity;

import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AlertStatusConverter implements AttributeConverter<AlertStatus, String> {

	@Override
	public String convertToDatabaseColumn(AlertStatus alertStatus) {
		if (alertStatus == null)
			return null;

		return alertStatus.getAlertText();

	}

	@Override
	public AlertStatus convertToEntityAttribute(String alertText) {
		if (alertText == null)
			return null;

		return Stream.of(AlertStatus.values())
			.filter(alertStatus -> alertStatus.getAlertText().equals(alertText.toUpperCase()))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}
}
