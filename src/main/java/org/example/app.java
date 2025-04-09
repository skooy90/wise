package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
  private Scanner sc;
  private int quoteId = 1; // 명언 번호 (자동 증가)
  private ArrayList<mo> quoteList = new ArrayList<>(); // 명언 저장소

  App(Scanner sc){
    this.sc = sc;
  }

  public void run(){
    System.out.println("== motivation 앱 실행 ==");

    while (true) {
      System.out.print("명령어) ");
      String cmd = sc.nextLine().trim();

      if (cmd.equals("add")) {
        System.out.print("명언: ");
        String content = sc.nextLine().trim();

        System.out.print("작가: ");
        String author = sc.nextLine().trim();

        mo quote = new mo(quoteId, content, author);
        quoteList.add(quote);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quoteId);
        quoteId++;
      }
      else if (cmd.equals("list")) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        // 최신 등록이 위로 올라오게 역순 출력
        for (int i = quoteList.size() - 1; i >= 0; i--) {
          mo q = quoteList.get(i);
          System.out.printf("%d / %s / %s\n", q.id, q.author, q.content);
        }
      }
      else if (cmd.equals("exit")) {
        System.out.println("== motivation 앱 종료 ==");
        break;
      }
      else {
        System.out.println("알 수 없는 명령어입니다.");
      }
    }
  }
}

class mo {
  int id;
  String content;
  String author;

  mo(int id, String content, String author) {
    this.id = id;
    this.content = content;
    this.author = author;
  }
}
