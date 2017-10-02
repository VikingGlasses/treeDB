package com.benjamin.tree.model;

import java.util.List;

public interface CommandExecutor {

  public void update(String tableName, Attribute id, List<Attribute> attributes);

  public void delete(String tableName, Attribute id);

  public void read(String tableName, Attribute id);

  public void create(String tableName, List<Attribute> attributes);

  public void search(String tableName, List<Attribute> attributes);

  public void close();

}
