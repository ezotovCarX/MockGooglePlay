package ru.zotov.mockgoogleplay.model;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author Created by ZotovES on 11.09.2021
 */
@Service
@Data
public class StateChecked {
    private Boolean returnedResult = true;
}
