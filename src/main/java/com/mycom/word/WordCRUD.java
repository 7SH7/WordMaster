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

  public ArrayList<Integer> listAll(String keyword) {
    ArrayList<Integer> idlist = new ArrayList<>();
    int j = 0;

    System.out.println("--------------------------------");
    for(int i = 0 ; i < list.size() ; i++) {
      String word = list.get(i).getWord();
      if(!word.contains(keyword)) continue;
      System.out.print((j + 1) + " ");
      System.out.println(list.get(i).toString());
      idlist.add(i);
      j++;
    }
    System.out.println("--------------------------------");

    return idlist;
  }

  public void updateItem(){
    System.out.println("=> 수정할 단어 검색 : ");
    String keyword = s.next();
    ArrayList<Integer> idlist = this.listAll(keyword);
    System.out.println("=> 수정할 번호 검색 : ");
    int id = s.nextInt();
    s.nextLine();

    System.out.println("=> 뜻 입력 : ");
    String meaning = s.nextLine();
    Word word = list.get(idlist.get(id-1));
    word.setMeaning(meaning);

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
