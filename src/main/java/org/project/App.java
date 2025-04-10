package org.project;

import org.system.controller.SystemController;
import org.wiseSaying.controller.WiseSayingController;

import java.util.*;

public class App {
  App() {
  }

  public void run() {
    SystemController systemController = new SystemController();
    WiseSayingController wiseSayingController = new WiseSayingController();

    System.out.println("== motivation 앱 실행 == ");
    while (true) {
      System.out.print("명령어) ");
      String cmd = Container.getScanner().nextLine().trim();
      if (cmd.equals("add")) {
        wiseSayingController.add();
      } else if (cmd.equals("list")) {
        wiseSayingController.list();
      } else if (cmd.startsWith("delete")){
           Rq rq = new Rq(cmd);
        System.out.println(rq.getActionCode());
        System.out.println(rq.getParams());


        wiseSayingController.delete();

      } else if (cmd.equals("exit")) {
        systemController.exit();
        break;
      } else {
        System.out.println("존재하지 않는 명령어입니다.");
      }
    }
  }
}
