package com.power.node.bank.pojo;

/**
 *
 * @Author darren
 * @Date 2022/11/16 9:37
 */
public class Account {
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(final String actno, final Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(final String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(final Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
