package com.cagdasyilmaz.bayztracker.scheduling.service;

import com.cagdasyilmaz.bayztracker.alert.entity.AlertStatus;
import com.cagdasyilmaz.bayztracker.alert.service.AlertService;
import com.cagdasyilmaz.bayztracker.currency.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PriceCheckerService {

	private final AlertService alertService;
	private final CurrencyService currencyService;

	public PriceCheckerService(AlertService alertService, CurrencyService currencyService) {
		this.alertService = alertService;
		this.currencyService = currencyService;
	}

	@Scheduled(fixedRate = 30000)
	@Async
	public void checkTargetPrices() {
		alertService.getAlerts()
			.forEach(alert -> {
				String currencySymbol = alert.getCurrency();
				float currentPrice = currencyService.getCurrency(currencySymbol.toUpperCase()).getCurrentPrice();
				float targetPrice = alert.getTargetPrice();
				if (currentPrice >= targetPrice) {
					if(alert.getStatus() == AlertStatus.NEW) {
						log.info("Alert triggered for " + currencySymbol + ". Target price was " + targetPrice
							+ ", current price is " + currentPrice);
						alertService.triggerAlert(alert.getAlertId());
					}
				}
			});
	}
}
