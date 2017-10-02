package com.benjamin.tree.view;

import java.util.List;

public class Printer {


  public void printMenu(List<String> menuItems) {
    String menu = "";
    for (int i = 0; i < menuItems.size(); i++) {
      menu += String.format("[%d] - %s\n", i + 1, menuItems.get(i));
    }
    System.out.println(menu);
  }

  public <T> void printRows(List<T> list) {
    String str = "\n";
    for (T item : list) {
      str += item.toString() + "\n";
    }
    System.out.println(str);
  }

  public void printErrorMsg(String msg) {
    System.out.println(msg);
  }
}
