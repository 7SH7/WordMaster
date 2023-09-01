package org.example;

public class Student {
  public Student(String name) {
    this.name = name;
  }

  public Student(String ID, String name) {
    this.ID = ID;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String ID;

  private String name;

  @Override
  public String toString() {
    return "Student{" +
        "ID='" + ID + '\'' +
        ", name='" + name + '\'' +
        '}';
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }
}
