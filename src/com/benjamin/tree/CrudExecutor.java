package com.benjamin.tree;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benjamin.tree.entity.Branch;
import com.benjamin.tree.entity.Leaf;
import com.benjamin.tree.entity.Type;

public class CrudExecutor {

  private final SessionFactory factory = new Configuration()
                                         .configure("hibernate.cfg.xml")
                                         .addAnnotatedClass(Type.class)
                                         .addAnnotatedClass(Branch.class)
                                         .addAnnotatedClass(Leaf.class)
                                         .buildSessionFactory();

  public void createType(String name, int growthRate, int leafDensity) {
    Session s = factory.getCurrentSession();
    s.beginTransaction();
    s.save(new Type(name, growthRate, leafDensity));
    s.getTransaction().commit();
    
  }

  public void closeFactory() {
    factory.close();
  }

  public <T> List<T> read(Class<T> clazz) {
    Session s = factory.getCurrentSession();
    s.beginTransaction();
    List<T> l = s.createQuery("from " + clazz.getSimpleName(), clazz).getResultList();
    s.getTransaction().commit();
    return l;
  }
  
  
  
}
