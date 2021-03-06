package com.piash;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
		Scanner input = new Scanner (System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
		private int customerNumber;
		private int pinNumber;
		private double checkingBalance;
		private double savingBalance;
		
		public int setCustomerNumber (int customerNumber) {
			this.customerNumber = customerNumber;
			return customerNumber;
		}
		public int setPinNumber (int pinNumber) {
			this.pinNumber = pinNumber;
			return pinNumber;
		}
		public int getCustomerNumber() {
			return customerNumber;
		}
		public int getPinNumber() {
			return pinNumber;
		}
		public double getCheckingBalance () {
			return checkingBalance;
		}
		public double getSavingBalance() {
			return savingBalance;
		}
		
		public double calcCheckingWithdraw(double amount) {
			checkingBalance = (checkingBalance-amount);
			return checkingBalance;
		}
		public double calcSavingWithdraw(double amount) {
			savingBalance = (savingBalance-amount);
			return savingBalance;
		}
		public double calcCheckingDeposit(double amount) {
			checkingBalance = (checkingBalance + amount);
			return checkingBalance;
		}
		public double calcSavingDeposit(double amount) {
			savingBalance = (savingBalance + amount);
			return savingBalance;
		}
		
		public void getCheckingWithdrawInput() {
			System.out.println("Checking account Balance"+moneyFormat.format(checkingBalance));
			System.out.println("Total Amount you want to withdraw  from checking Account");
			double amount = input.nextDouble();
			if((checkingBalance-amount)>=0) {
				calcCheckingWithdraw(amount);
				System.out.println("New checking account balance "+moneyFormat.format(checkingBalance));
			}else {
				System.out.println("You do not hava sufficient balance"+"\n");
			}
		}
		
		public void getSavingWithdrawInput() {
			System.out.println("Saving account balance"+ moneyFormat.format(savingBalance));
			System.out.println("Amount you want to withdraw from saving account");
			double amount = input.nextDouble();
			if((savingBalance-amount)>=0) {
				calcSavingWithdraw(amount);
				System.out.println("New Saving account balance"+savingBalance + "\n");
			}else {
				System.out.println("You do not have sufficient balance"+"\n");
			}
		}
		public void getCheckingDepositInput() {
			System.out.println("Checking account Balance"+moneyFormat.format(checkingBalance));
			System.out.println("Amount you want to deposit from checking Account");
			double amount = input.nextDouble();
			if((checkingBalance+amount)>=0) {
				calcCheckingDeposit(amount);
				System.out.println("New checking account balance "+moneyFormat.format(checkingBalance));
			}else {
				System.out.println("You do not have sufficient balance"+"\n");
			}
		}
		public void getSavingDepositInput() {
			System.out.println("Saving account balance"+ moneyFormat.format(savingBalance));
			System.out.println("Amount you want to deposit from saving account");
			double amount = input.nextDouble();
			if((savingBalance+amount)>=0) {
				calcSavingDeposit(amount);
				System.out.println("New saving account balance"+moneyFormat.format(savingBalance) + "\n");
			}else {
				System.out.println("You do not have sufficient balance"+"\n");
			}
		}

	}


