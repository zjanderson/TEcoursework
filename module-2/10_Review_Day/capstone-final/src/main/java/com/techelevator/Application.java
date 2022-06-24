package com.techelevator;

import com.techelevator.dao.CsvInventoryDao;
import com.techelevator.dao.HardCodeInventoryDao;
import com.techelevator.dao.InventoryDao;
import com.techelevator.view.Menu;

public class Application {
    public static void main(String[] args) {
        InventoryDao inventoryDao = new CsvInventoryDao();
        VendingMachine machine = new VendingMachine(inventoryDao);
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu, machine);
        cli.run();
    }
}
