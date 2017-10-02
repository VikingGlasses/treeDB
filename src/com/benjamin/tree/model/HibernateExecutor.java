package com.benjamin.tree.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benjamin.tree.entity.Branch;
import com.benjamin.tree.entity.Leaf;
import com.benjamin.tree.entity.Type;

public class HibernateExecutor implements CommandExecutor {
  
  SessionFactory factory = new Configuration()
                              .configure("hibernate.cfg.xml")
                              .addAnnotatedClass(Type.class)
                              .addAnnotatedClass(Branch.class)
                              .addAnnotatedClass(Leaf.class)
                              .buildSessionFactory();
  BeanFactory beanFactory = new BeanFactory();

  @Override
  public void update(String tableName, Attribute id, List<Attribute> attributes) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(String tableName, Attribute id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void read(String tableName, Attribute id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void create(String tableName, List<Attribute> attributes) {
    // create bean
    Class<?> clazz = getClazz(tableName);
    beanFactory.createBean(clazz, attributes);
    // begin transaction
    // save bean
    // commit transaction

  }

  @Override
  public void search(String tableName, List<Attribute> attributes) {
    Class<?> clazz = getClazz(tableName);
    String value = attributes.get(0).getValue();
    String question = "from " + clazz.getSimpleName() + " t where t.color like '%" + value + "%'";
    Session session = factory.getCurrentSession();
    session.beginTransaction();
    List<?> resultList = session
                    .createQuery(question, clazz)
                    .getResultList();
    session.getTransaction().commit();
    printRows(resultList);
  }

  private <T> Class<?> getClazz(String tableName) {
    switch (tableName.toUpperCase()) {
      case "TYPE":
        return Type.class;
      case "BRANCH":
        return Branch.class;
      case "LEAF":
        return Leaf.class;
        default:
          throw new IllegalArgumentException(tableName);
    }
  }

  public <T> void printRows(List<T> list) {
    String str = "\n";
    for (T item : list) {
      str += item.toString() + "\n";
    }
    System.out.println(str);
  }

  @Override
  public void close() {
    factory.close();
  }

}
