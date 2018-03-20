package model;

import java.util.ArrayList;
import java.util.List;

import model.CreditType;

public class Credit {

    private double capital;
    private int installments;
    private double rate;
    private double fee;
    private CreditType type;

    private List<Installment> installmentsList = new ArrayList<>(480);


public Credit(double capital, int installments, double rate, double fee, CreditType type) {
    this.setCapital(capital);
    this.setInstallments(installments);
    this.setRate(rate);
    this.setFee(fee);
    this.setType(type);
    this.calculateInstallments();
	}

private void calculateInstallments() {
	double r = ((getRate()/100)/12);
	if (type == CreditType.DECREASING) {
		double capitalPart = getCapital() / getInstallments();
		double fee = getFee() / getInstallments();
		double capitalLeft = getCapital();
		for (int i = 1; i <= installments; i++) {
			double interestPart = capitalLeft*r;
			double installmentAmount = interestPart + capitalPart + fee;
			capitalLeft = capitalLeft - capitalPart;
			addInstalment(i, installmentAmount, capitalPart, interestPart, fee, capitalLeft);
		}
	}
	else if (type == CreditType.EQUAL) {
		double fee = getFee() / getInstallments();
		double capitalLeft = getCapital();
		double installmentAmount = getCapital() * (( r * Math.pow(1 + r, getInstallments())) / ( Math.pow( 1 + r, getInstallments()) - 1 ));
		double installmentAmountWithFee = installmentAmount + fee;
		for (int i = 1; i <= installments; i++) {
			double interestPart = capitalLeft*r;
			double capitalPart = installmentAmount - interestPart; 
			capitalLeft = capitalLeft - capitalPart;
			addInstalment(i, installmentAmountWithFee, capitalPart, interestPart, fee, capitalLeft);
		}
	}
}

private void addInstalment(int number, double installment, double capitalPart, double interestPart, double fee, double capitalLeft) {
		Installment installmentNew = new Installment();
		installmentNew.setNumber(number);
		installmentNew.setInstallment(installment);
		installmentNew.setCapitalPart(capitalPart);
		installmentNew.setInterestPart(interestPart);
		installmentNew.setFee(fee);
		installmentNew.setCapitalLeft(capitalLeft);
		this.installmentsList.add(installmentNew);	
}

public double getCapital() {
    return capital;
}

public void setCapital(double capital) {
    this.capital = capital;
}

public int getInstallments() {
	return installments;
}

public void setInstallments(int installments) {
	this.installments = installments;
}

public double getRate() {
	return rate;
}

public void setRate(double rate) {
	this.rate = rate;
}

public List<Installment> getInstallmentsList() {
	return installmentsList;
}

public void setInstallmentsList(List<Installment> installmentsList) {
	this.installmentsList = installmentsList;
}

public double getFee() {
	return fee;
}

public void setFee(double fee) {
	this.fee = fee;
}

public CreditType getType() {
    return type;
}

public void setType(CreditType type) {
    this.type = type;
}
}