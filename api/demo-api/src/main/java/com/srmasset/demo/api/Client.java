package com.srmasset.demo.api;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;


public class Client {

    private Long id;
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Credit limit is required")
    private Double creditLimit;
    @NotNull(message = "Risk is required")
    private Risk risk;
    private Integer interestRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Client(Long id, String name, Double creditLimit, Risk risk, Integer interestRate) {
        this.id = id;
        this.name = name;
        this.creditLimit = creditLimit;
        this.risk = risk;
        this.interestRate = interestRate;
    }

    public Client(String name, Double creditLimit, Risk risk, Integer interestRate) {
        this(null, name, creditLimit, risk, interestRate);
    }

    public Client() {
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, creditLimit, risk, interestRate);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Client) {
            Client that = (Client) object;
            return Objects.equal(this.id, that.id)
                    && Objects.equal(this.name, that.name)
                    && Objects.equal(this.creditLimit, that.creditLimit)
                    && Objects.equal(this.risk, that.risk)
                    && Objects.equal(this.interestRate, that.interestRate);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("creditLimit", creditLimit)
                .add("risk", risk)
                .add("interestRate", interestRate)
                .toString();
    }
}
