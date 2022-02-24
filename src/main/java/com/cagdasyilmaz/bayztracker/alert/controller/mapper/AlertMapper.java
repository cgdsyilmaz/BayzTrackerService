package com.cagdasyilmaz.bayztracker.alert.controller.mapper;

import com.cagdasyilmaz.bayztracker.alert.controller.model.request.AlertCreateRequest;
import com.cagdasyilmaz.bayztracker.alert.controller.model.response.AlertResponse;
import com.cagdasyilmaz.bayztracker.alert.entity.Alert;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper {
	private static ModelMapper modelMapper;

	public AlertMapper(ModelMapper modelMapper) {
		AlertMapper.modelMapper = modelMapper;
	}

	public static AlertResponse mapAlertToAlertResponse(Alert alert) {
		return modelMapper.map(alert, AlertResponse.class);
	}

	public static Alert mapAlertCreateRequestToAlert(AlertCreateRequest alertCreateRequest) {
		return modelMapper.map(alertCreateRequest, Alert.class);
	}
}
