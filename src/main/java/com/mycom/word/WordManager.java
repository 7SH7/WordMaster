package com.mycom.word;

import java.io.*;
import java.util.Dictionary;
import java.util.Scanner;

public class WordManager{
  Scanner s = new Scanner(System.in);
  WordCRUD wordCRUD;

  WordManager() {
    wordCRUD = new WordCRUD(s);
  }

  public int selectmenu() {

    System.out.print("*** 영단어 마스터 ***\n" +
        "*********************\n" +
        "1. 모든 단어 보기\n" +
        "2. 수준별 단어 보기\n" +
        "3. 단어 검색\n" +
        "4. 단어 추가\n" +
        "5. 단어 수정\n" +
        "6. 단어 삭제\n" +
        "7. 파일 저장\n" +
        "0. 나가기\n" +
        "*********************\n" +
        "=> 원하는 메뉴는? ");

    return s.nextInt();   // 숫자 받아와.

  }


  public void start() {

    wordCRUD.loadFile();
    while (true) {
      int menu = selectmenu();
      if(menu == 0)  {
        System.out.println("프로그램 종료! 다음에 만나요~");
        break;
      }
      else if(menu == 1) {  // ok
        wordCRUD.listAll();
      }
      else if(menu == 2) {  // ok
        wordCRUD.searchLevel();
      }
      else if(menu == 3) {  // ok
        // 단어검색
        wordCRUD.searchWord();
      }
      else if(menu == 4) {  // ok
        wordCRUD.addItem();
      }
      else if(menu == 5){ // ok
        wordCRUD.updateItem();
      }
      else if(menu == 6){ // ok
        // delete
        wordCRUD.deleteItem();
      }
      else if(menu == 7){ // -> dictionary가 변하지 않는다. => 수정 필요
        wordCRUD.saveFile();
      }
    }
  }

}
