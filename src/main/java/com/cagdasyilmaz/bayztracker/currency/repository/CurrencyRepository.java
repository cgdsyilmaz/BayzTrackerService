package com.cagdasyilmaz.bayztracker.currency.repository;

import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
	Optional<Currency> findCurrencyBySymbol(String symbol);
	Optional<Currency> findCurrencyByCurrencyId(UUID currencyId);
	Optional<Currency> deleteCurrencyBySymbol(String symbol);
	Optional<Currency> deleteCurrencyByCurrencyId(UUID currencyId);
}
