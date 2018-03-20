package model;

public class Installment {
    private int number;
    private double installment;
    private double capitalPart;
    private double interestPart;
    private double fee;
    private double capitalLeft;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getInstallment() {
		return installment;
	}
	public void setInstallment(double installment) {
		this.installment = installment;
	}
	public double getCapitalPart() {
		return capitalPart;
	}
	public void setCapitalPart(double capitalPart) {
		this.capitalPart = capitalPart;
	}
	public double getInterestPart() {
		return interestPart;
	}
	public void setInterestPart(double interestPart) {
		this.interestPart = interestPart;
	}
	public double getCapitalLeft() {
		return capitalLeft;
	}
	public void setCapitalLeft(double capitalLeft) {
		this.capitalLeft = capitalLeft;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
}
