package org.example;

import java.util.Scanner;

public class App {

  private Scanner sc;


  App(Scanner sc){
    this.sc = sc;

  }


  public void run(){
    System.out.println("== motivation 앱 실행 ==");

    // 혹시 모를 공백 제거 : trim();
    System.out.print("명령어) ");
    String cmd = sc.nextLine().trim();  // trim() 좌우 공백을 제거 해줌

    // String을 비교하기 위해서는 equals가 필요
    if (cmd.equals("exit")) {
      System.out.println("== motivation 앱 종료 ==");
    }
    
  }

}
