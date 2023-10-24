package services;

public interface OnlinePaymentServices {

	Double paymentFee(double amount);

	Double interest(double amount, int months);
}