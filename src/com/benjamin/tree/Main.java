package com.benjamin.tree;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.benjamin.tree.entity.Branch;
import com.benjamin.tree.entity.Type;

public class Main {
  
  private static CrudExecutor exe;
  
  public static void main(String[] args) {
    Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    exe  = new CrudExecutor();
    final List<String> crudMenu = Arrays.asList("Create", "Read", "Update", "Delete");
    while(true) {
      // print menu
      printMenu(crudMenu);
      
      // get menu alternative
      String input = InputHelper.getStringInput("Choose option: ");
      
      // execute menu alternative
      if ("-q".equalsIgnoreCase(input) || "-e".equalsIgnoreCase(input)) {
        break;
      } else if (isInteger(input)) {
        int menuChoice = Integer.parseInt(input);
        executeMenuChoice(menuChoice);
      } else {
        System.out.println("Bad input...");
      }
    }
    exe.closeFactory();
  }

  private static void executeMenuChoice(int menuChoice) {
    switch (menuChoice) {
      case 1:
        exe.createType("Oak", 1, 1);
        break;
      case 2:
        List<?> list = exe.read(Branch.class);
        printRows(list);
        break;
      case 3:
        break;
      case 4:
        break;
      default:
          
    }
  }

  private static void printMenu(List<String> menuItems) {
    String menu = "";
    for (int i = 0; i < menuItems.size(); i++) {
      menu += String.format("[%d] - %s\n", i + 1, menuItems.get(i));
    }
    System.out.println(menu);
  }

  private static <T> void printRows(List<T> list) {
    String str = "\n";
    for (T item : list) {
      str += item.toString() + "\n";
    }
    System.out.println(str);
  }

  private static boolean isInteger(String input) {
    boolean isNumber;
    try {
      Integer.parseInt(input);
      isNumber = true;
    } catch (NumberFormatException e) {
      isNumber = false;
    }
    return isNumber;
  }

}
