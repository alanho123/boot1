package com.example.microservicesimpleprovideruser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardStatus {

    private String code;
    private String description;
    private String result;
}
