package com.mycom.word;

public interface ICRUD {
  public Object add();
  public int update(Object obj);
  public int delete(Object obj);
  public void select(int id);
}
