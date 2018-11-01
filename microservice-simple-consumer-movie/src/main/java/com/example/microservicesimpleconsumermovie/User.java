package com.example.microservicesimpleconsumermovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:alanho123@gmail.com">Jason Ho</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String account;
    private String username;
    private Integer age;
    private BigDecimal balance;

}
