package com.techelevator;

import java.io.File;

import com.techelevator.snack.SnackFactory;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.accounting.CashAccount;
import com.techelevator.accounting.ChangeMaker;
import com.techelevator.accounting.MinimumChangeMaker;
import com.techelevator.inventory.FileInventory;
import com.techelevator.vendingmachine.Inventory;
import com.techelevator.vendingmachine.Auditable;
import com.techelevator.vendingmachine.log.FileAuditLog;
import com.techelevator.vendingmachine.view.PurchaseMenuCLI;
import com.techelevator.vendingmachine.view.VendingMachineCLI;
import com.techelevator.view.Menu;

public class Application {

	public static void main(String[] args) {	
		Inventory inventoryDao = new FileInventory(new File("vendingmachine.csv"), new SnackFactory());
		
		ChangeMaker changeMaker = new MinimumChangeMaker();
		CashAccount account = new CashAccount(changeMaker);

		Auditable auditLog = new FileAuditLog(new File("Log.txt"));
		
		VendingMachine vendingMachine = new VendingMachine(inventoryDao, account, auditLog);

		// Create CLIs
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenuCLI purchaseMenuCLI = new PurchaseMenuCLI(menu, vendingMachine);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenuCLI, vendingMachine);

		// Begin
		cli.run();
	}

}
