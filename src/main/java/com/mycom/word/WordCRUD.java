package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
  ArrayList<Word> list;
  Scanner s;

  WordCRUD(Scanner s){
    list = new ArrayList<>();
    this.s = s;
  }

  /*
  => 난이도(1,2,3) & 새 단어 입력 :1 driveway
  뜻 입력 : 차고 진입로
  새 단어가 단어장에 추가되었습니다.
   */

  @Override
  public Object add() {
    System.out.print("  => 난이도(1,2,3) & 새 단어 입력 : ");
    int level = s.nextInt();
    String word = s.nextLine();
    // 1 driveway
    System.out.print("뜻 입력 : ");
    String meaning = s.nextLine();
    // 차고 진입로
//    System.out.println();
    return new Word(0, level, word, meaning);
  }

  public void addWord() {
    // wordmanger에서 호출할 것이기 때문에 list에 추가까지
    Word one = (Word)add();
    list.add(one);
    System.out.println("새 단어가 단어장에 추가되었습니다. ");
  }

  public void listAll() {
    System.out.println("--------------------------------");
    for(int i = 0 ; i < list.size() ; i++) {
      System.out.print((i + 1) + " ");
      System.out.println(list.get(i).toString());
    }
    System.out.println("--------------------------------");
  }

  @Override
  public int update(Object obj) {
    return 0;
  }

  @Override
  public int delete(Object obj) {
    return 0;
  }

  @Override
  public void select(int id) {

  }
}
