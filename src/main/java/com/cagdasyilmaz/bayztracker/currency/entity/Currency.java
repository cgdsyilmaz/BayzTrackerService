package com.cagdasyilmaz.bayztracker.currency.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currencies")
public class Currency {
    @Id
    private UUID currencyId;
    private String name;

    @Column(unique = true)
    private String symbol;

    private float currentPrice;
    private boolean isEnabled;
    private LocalDateTime creationTime;
}
