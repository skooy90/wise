package org.project;

import org.system.controller.SystemController;
import org.wiseSaying.controller.WiseSayingController;

import java.util.*;
// Controller,Service,Repository의 3박자로 웹이 움직인다.
public class App {
  App() {
  }

  public void run() {
    SystemController systemController = new SystemController();
    WiseSayingController wiseSayingController = new WiseSayingController();

    System.out.println("== motivation 앱 실행 == ");
    byte system_status = 1;
    while (system_status == 1) {
      System.out.print("명령어) ");
      String cmd = Container.getScanner().nextLine().trim();
      Rq rq = new Rq(cmd);


    switch (rq.getActionCode()) {
      case"delete":
        wiseSayingController.delete(rq);
        break;
      case"add":
        wiseSayingController.add();
        break;
      case"list":
        wiseSayingController.list();
        break;
      case"exit":
        systemController.exit();
        system_status = 0;
        break;
      case"modify":
        wiseSayingController.modify(rq);
        break;
      default:
        System.out.println("존재하지 않는 명령어입니다.");
        break;

    }
    }
  }
}
