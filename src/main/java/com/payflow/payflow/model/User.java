package com.payflow.payflow.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private UUID id;
    private String name;
    private String email;
    private BigDecimal balance;
}
