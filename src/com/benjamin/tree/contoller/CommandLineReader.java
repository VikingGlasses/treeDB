package com.benjamin.tree.contoller;

import com.benjamin.tree.InputHelper;
import com.benjamin.tree.model.Command;
import com.benjamin.tree.model.CommandExecutor;
import com.benjamin.tree.model.JdbcExecutor;
import com.benjamin.tree.view.Printer;

public class CommandLineReader implements Runnable {

  private Printer printer;
  private CommandExecutor hibernate;
  private CommandExecutor jdbc = new JdbcExecutor();

  public CommandLineReader(Printer p, CommandExecutor ce) {
    this.printer = p;
    this.hibernate = ce;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void run() {
    boolean quit = false;
    while(!quit) {
      // read command
      String input = InputHelper.getStringInput(">> ");
      // TODO check for empty input
      
      // ex command:
      // -c branch length=2 age=5 type=4 parent=null
      // -r branch | attribute=?
      // -u branch id=5 --||--
      // -d branch id=4
      // command table attributes
      // -s branch age=5
      // -call name input
      // parse command
      try {
        Command c = new Command(input);
        // execute command & print result
        switch (c.getCommand()) {
          case CALL:
            break;
          case CREATE:
            jdbc.create(c.getTableName(), c.getAttributes());
            break;
          case DELETE:
            jdbc.delete(c.getTableName(), c.getId());
            break;
          case READ:
            jdbc.read(c.getTableName(), c.getId());
            break;
          case SEARCH:
            hibernate.search(c.getTableName(), c.getAttributes());
            break;
          case UPDATE:
            jdbc.update(c.getTableName(), c.getId(), c.getAttributes());
            break;
          case HELP:
            break;
          case QUIT:
            quit = true;
            break;
          default:
            break;
          
        }
      } catch (IllegalArgumentException e) {
        printer.printErrorMsg(e.getMessage());
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
    hibernate.close();
    jdbc.close();
  }

}
