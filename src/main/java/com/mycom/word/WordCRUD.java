package com.mycom.word;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
  ArrayList<Word> list;
  Scanner s;
  String fileName = "Dictionary.txt";
  Connection conn;


  WordCRUD(Scanner s){
    list = new ArrayList<>();
    this.s = s;
//    conn = DBConnection.getConneciton();  // DB에 접근할 수 있게 해줌. 쿼리 관련!
  }

  @Override
  public Object add() {
    System.out.print("  => 난이도(1,2,3,4,5) & 새 단어 입력 : ");
    int level = s.nextInt();    // nextInt와 nextLine 구분!
    String word = s.nextLine();
    System.out.print("뜻 입력 : ");
    String meaning = s.nextLine();
    return new Word(0, level, word, meaning);
  }

  public void addItem() {
    Word _word = (Word)add();
    list.add(_word);
    System.out.println("새 단어가 단어장에 추가되었습니다. ");
  }

  public void listAll() {
    // 쿼리!!
//    loadData();1
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

  public void listAll(int level){
    int j = 0;

    System.out.println("--------------------------------");
    for(int i = 0 ; i < list.size() ; i++) {
      int tmp = list.get(i).getLevel();
      if(tmp != level) continue;
      System.out.print((j + 1) + " ");
      System.out.println(list.get(i).toString());
      j++;
    }
    System.out.println("--------------------------------");

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
    System.out.println("단어 수정 완료 ");
  }


  public void deleteItem() {
    System.out.println("=> 삭제할 단어 검색 : ");
    String keyword = s.next();
    ArrayList<Integer> idlist = this.listAll(keyword);
    System.out.println("=> 삭제할 번호 검색 : ");
    int id = s.nextInt();
    s.nextLine();

    System.out.println("=> 삭제할까요?(y/n) ");
    String ans = s.next();

    if (ans.equalsIgnoreCase("y")) {
      list.remove((int) idlist.get(id - 1)); // int type casting 필수!
      System.out.println("단어 삭제!.");
    } else {
      System.out.println("취소");
    }
  }



  public void loadFile(){
    // 파일 데이터 읽어오기
    try {
      BufferedReader bfrd = new BufferedReader(new FileReader(fileName));
      String line;
      int count = 0;


      while(true) {     // 이걸 buffer 사용해서 하는 것도 가능은 할 듯?
        line = bfrd.readLine();
        if(line == null) break;
        String content[] = line.split("\\|");
        list.add(new Word(0, Integer.parseInt(content[0]), content[1], content[2]));
        count++;
      }
      bfrd.close();
      System.out.println("==> " + count + "개 로딩");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // saveFile 기능은 문제 있음!
  public void saveFile(){
    // 파일저장
    try {
      PrintWriter pnt = new PrintWriter(new FileWriter("Dictionary.txt"));
      for(Word word : list){
        pnt.write(word.toFileString() + "\n");
      }
      pnt.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
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

  public void searchLevel() {
    System.out.print("원하는 레벨은?");
    int level = s.nextInt();
    listAll(level);
  }

  public void searchWord() {
    System.out.print("원하는 단어에 포함되어 있는 문자는? ");
    String word = s.next();
    listAll(word);
  }

  // 쿼리 관련 함수!
/*  public void loadData() {
    list.clear();
    String selectall = "select * from dictionary";
    try{
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(selectall);
      while(true){
        if(!rs.next()) break;
        int id = rs.getInt("id");
        int level = rs.getInt("level");
        String word = rs.getString("word");
        String meaning = rs.getString("meaning");
        list.add(new Word(id, level, word, meaning));
      }
      rs.close();
      stmt.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }*/

}