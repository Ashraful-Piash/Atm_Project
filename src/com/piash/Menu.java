package com.piash;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class Menu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
		int x =1;
		do {
			try {
				data.put(123456, 123);
				data.put(212212, 212);
				
				System.out.println("Welcome to  ATM Machine");
				System.out.print("Enter your Customer Number:");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN Number:");
				setPinNumber(menuInput.nextInt());
				
			}catch (Exception e) {
				System.out.println( "\n"+"Invalid character(s). Only Numbers." + "\n");
				x=2;
			}
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if(data.containsKey(cn) && data.get(cn)==pn) {
				getAccountType();
			}else
				System.out.println("Invalid  PIN number or ID");
			
		}while(x==1);
		
	}
	

	public void getAccountType(){
		System.out.println("Select the account you want to access");
		System.out.println("Type 1: Checking Account");
		System.out.println("Type 2: Saving Account");
		System.out.println("Type 3: Exit");
		System.out.println("Choice :");
		int selection = menuInput.nextInt();
		switch(selection) {
		case 1:
			getCheckingBalance();
			break;
		case 2:
			getSavingBalance();
			break;
		case 3:
			System.out.println("Thank you for using this ATM , Bye");
			break;
			
			default:
				System.out.println("Invalid Choice"+"\n");
				getAccountType();
		}
		
	}
	public void getChecking() {
		System.out.println("Checking account");
		System.out.println("Type 1: View balance");
		System.out.println("Type 2: Withdraw funds");
		System.out.println("Type 3: Deposit funds");
		System.out.println("Type 4: Exit");
		System.out.println("Choice :"+"\n");
		int selection = menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance"+moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
		    getChecking();
			
		}
    }
	public void getSaving() {
		System.out.println("Saving account");
		System.out.println("Type 1: View balance");
		System.out.println("Type 2: Withdraw funds");
		System.out.println("Type 3: Deposit funds");
		System.out.println("Type 4: Exit");
		System.out.println("Choice :"+"\n");
		int selection = menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Saving Account Balance"+moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		default:
			System.out.println("\n"+"Invalid Choice"+"\n");
			getSaving();
			
		}
		
	}
	

}
