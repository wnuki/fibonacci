package com.java.fibonacci.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
public class OperationModel {
    private String operation;
    private long n;

    public OperationModel(String operation) {
        this.operation = operation;
    }

    public OperationModel(long n) {
        this.n = n;
    }
}
