package com.benjamin.tree;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.benjamin.tree.contoller.CommandLineReader;
import com.benjamin.tree.model.CommandExecutor;
import com.benjamin.tree.model.HibernateExecutor;
import com.benjamin.tree.view.Printer;

public class CrudApp {

  public static void main(String[] args) {
    Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    Printer p = new Printer();
    CommandExecutor ce = new HibernateExecutor();
    CommandLineReader clr = new CommandLineReader(p, ce);
    clr.run();
  }

}
