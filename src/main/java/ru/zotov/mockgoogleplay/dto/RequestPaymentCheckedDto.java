package ru.zotov.mockgoogleplay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Created by ZotovES on 11.09.2021
 * Входящяя дто для проверки покупки
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPaymentCheckedDto {
    private String id;
    private String token;
}
