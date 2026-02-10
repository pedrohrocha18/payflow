package com.payflow.payflow.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private UUID id; //identificador único transação
    private UUID senderId; //remetente (null se for depósito)
    private UUID receiverID; //destinatário
    private BigDecimal amount; //valor transação
    private LocalDateTime timestamp; //data e hora da transação
    private String type; // TRANSFER ou DEPOSIT
}
