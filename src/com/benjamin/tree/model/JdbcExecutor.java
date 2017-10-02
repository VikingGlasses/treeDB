package com.benjamin.tree.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JdbcExecutor implements CommandExecutor {
  
  private String url;
  private Properties jdbcProp;
  
  
  public JdbcExecutor() {
    url = "jdbc:mysql://localhost:3306/tree";
    jdbcProp = new Properties();
    jdbcProp.setProperty("user", "root");
    jdbcProp.setProperty("pass", "");
  }

  @Override
  public void update(String tableName, Attribute id, List<Attribute> attributes) {
    String prepedStatement = updateStatement(tableName, id, attributes);
    try (Connection con = DriverManager.getConnection(url, jdbcProp)) {
      con.createStatement().executeUpdate(prepedStatement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(String tableName, Attribute id) {
    String prepedStatement = deleteStatement(tableName, id);
    try (Connection con = DriverManager.getConnection(url, jdbcProp)) {
      con.createStatement().executeUpdate(prepedStatement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void read(String tableName, Attribute id) {
    String prepedStatement = selectStatement(tableName, id);
    try (Connection con = DriverManager.getConnection(url, jdbcProp)) {
      ResultSet r = con.createStatement().executeQuery(prepedStatement);
      printResultSet(r);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void create(String tableName, List<Attribute> attributes) {
    String prepedStatement = insertStatement(tableName, attributes);
    try (Connection con = DriverManager.getConnection(url, jdbcProp)) {
      con.createStatement().executeUpdate(prepedStatement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void search(String tableName, List<Attribute> attributes) {
    // TODO Auto-generated method stub

  }

  private void printResultSet(ResultSet r) throws SQLException {
    String result = "";
    int count = r.getMetaData().getColumnCount();
    while (r.next()) {
      result += "|";
      for (int i = 1; i <= count; i++) {
        result += "\t" + r.getString(i) + "\t|";
      }
      result += "\n";
    }
    System.out.println(result);
  }

  private String updateStatement(String tableName, Attribute id, List<Attribute> attributes) {
    String statement = "UPDATE " + tableName + " SET ";
    for (Attribute a : attributes) {
      if (!a.equals(id)) {
        String asign = a.getName() + "=" + a.getValue() + " ";
        statement += asign;
      }
    }
    statement += " WHERE " + id.getName() + "=" + id.getValue();
    return statement;
  }

  private String deleteStatement(String tableName, Attribute id) {
    String statement = "DELETE FROM " + tableName + " WHERE " + id.getName() + "=" + id.getValue();
    return statement;
  }

  private String selectStatement(String tableName, Attribute id) {
    String result = "SELECT * FROM " + tableName;
    if (id != null) {
      result += " WHERE " + id.getName() + "=" + id.getValue();
    }
    return result;
  }

  private String insertStatement(String tableName, List<Attribute> attributes) {
    String result = "INSERT INTO " + tableName + " (";
    String values = "VALUES (";
    int last = attributes.size() - 1;
    for (int i = 0; i < attributes.size(); i++) {
      Attribute a = attributes.get(i);
      if (i != last) {
        result += a.getName() + ", ";
        values += a.getValue() + ", ";
      } else {
        result += a.getName() + ") ";
        values += a.getValue() + ")";
      }
    }
    result += values;
    return result;
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub
    
  }

}
