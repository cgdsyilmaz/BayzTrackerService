package com.cagdasyilmaz.bayztracker.currency.repository;

import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
	Optional<Currency> findCurrencyBySymbol(String symbol);
	Optional<Currency> deleteCurrencyBySymbol(String symbol);
}
