package com.screenplay.models.general;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorModel {
    private String username;
    private String passwordCDE;
    private String passwordNonCDE;
    private String bankName;
    private String bin;
    private String identity;
    private String paymentCredential;
    private String alias;
}
