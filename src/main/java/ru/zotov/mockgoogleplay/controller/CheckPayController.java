package ru.zotov.mockgoogleplay.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zotov.mockgoogleplay.dto.RequestPaymentCheckedDto;
import ru.zotov.mockgoogleplay.dto.ResponsePaymentCheckedDto;
import ru.zotov.mockgoogleplay.model.StateChecked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Created by ZotovES on 11.09.2021
 * Контроллер
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "payment", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class CheckPayController {
    private static final List<Integer> delayTimerList = Arrays.asList(1, 1, 1, 1, 10, 100, 1000, 10000, 1000000);
    private final StateChecked stateChecked;

    /**
     * Получить кошелек игрока
     *
     * @return кошелек игрока
     */
    @PostMapping("/check")
    public ResponseEntity<ResponsePaymentCheckedDto> getPlayerWallet(@RequestBody RequestPaymentCheckedDto paymentCheckedDto)
            throws InterruptedException {
        Thread.sleep(delayTimerList.get((int) (Math.random() * 10)));

        ResponsePaymentCheckedDto responsePaymentCheckedDto = ResponsePaymentCheckedDto.builder()
                .id(paymentCheckedDto.getId())
                .token(paymentCheckedDto.getToken())
                .resultChecked(stateChecked.getReturnedResult())
                .build();

        return ResponseEntity.ok(responsePaymentCheckedDto);
    }

    /**
     * Переключить возвращаемый результат проверки
     *
     * @param value значение
     */
    @PostMapping("/toggle")
    public ResponseEntity<Void> getPlayerWallet(@RequestParam(name = "value") Boolean value) {

        stateChecked.setReturnedResult(value);
        return ResponseEntity.ok().build();
    }

}
