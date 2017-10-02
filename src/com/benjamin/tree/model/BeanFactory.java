package com.benjamin.tree.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.benjamin.tree.entity.Type;

public class BeanFactory {

  public <T> T createBean(Class<T> clazz, List<Attribute> attributes) {
    try {
      T t = clazz.getConstructor().newInstance();
      System.out.println(t.toString());
      for (Attribute a : attributes) {
        Field field = clazz.getDeclaredField(a.getName());
        Class<?> fieldType = field.getType();
        System.out.println("Invoking method with " + a.toString());
        // TODO fix attribute name casing
        Method method = clazz.getMethod("set" + a.getName(), fieldType);
        
        if (fieldType.isAssignableFrom(String.class)) {
          method.invoke(t, a.getValue());
        } else if (fieldType.isAssignableFrom(int.class)) {
          int x = Integer.parseInt(a.getValue());
          method.invoke(t, x);
        } else {
          
        }
      }
      return t;
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    throw new IllegalArgumentException();
  }
  
  private Type createType() {
    return null;
  }

}
