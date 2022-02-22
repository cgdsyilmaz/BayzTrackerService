package com.cagdasyilmaz.bayztracker.currency.controller.mapper;

import com.cagdasyilmaz.bayztracker.currency.controller.model.response.CurrencyResponse;
import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {
	private static ModelMapper modelMapper;

	public CurrencyMapper(ModelMapper modelMapper) {
		CurrencyMapper.modelMapper = modelMapper;
	}

	public static CurrencyResponse mapCurrencyToCurrencyResponse(Currency currency) {
		return modelMapper.map(currency, CurrencyResponse.class);
	}
}
