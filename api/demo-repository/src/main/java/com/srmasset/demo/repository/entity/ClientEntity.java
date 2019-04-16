package com.srmasset.demo.repository.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.srmasset.demo.api.Risk;

import javax.persistence.*;


@Entity
@Table(name = "TB_CLIENT")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "interest_rate")
    private Integer interestRate;

    @Enumerated(EnumType.STRING)
    private Risk risk;

    public ClientEntity() {
    }

    public ClientEntity(String name, Double creditLimit, Integer interestRate, Risk risk) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.risk = risk;
    }

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

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id &&
                interestRate == that.interestRate &&
                Objects.equal(name, that.name) &&
                Objects.equal(creditLimit, that.creditLimit) &&
                Objects.equal(risk, that.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, creditLimit, interestRate, risk);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("creditLimit", creditLimit)
                .add("interestRate", interestRate)
                .add("risk", risk)
                .toString();
    }
}