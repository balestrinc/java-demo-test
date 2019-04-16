package com.srmasset.demo.api;

public enum Risk {
    A(0),
    B(10),
    C(20);

    private Integer interestRate;

    Risk(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getRate(){
        return this.interestRate;
    }
}
