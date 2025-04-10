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
            //parsing 기존에 들어온 개념을 쪼개서 나눈다.
          String[] cmdBits = cmd.split("\\?");
//          for(String i : cmdBits){
//        System.out.println(i);
        String actionCode = cmdBits[0];
          Map<String, String> params = new HashMap<>();

        String[] paramBits = cmdBits[1].split("=", 2);

        String key = paramBits[0];
        String value =paramBits[1];
        params.put(key, value);
        System.out.println(Arrays.toString(cmdBits));
        System.out.println("actioncode : " + actionCode);
        System.out.println("key : " + key);
        System.out.println("value : " + value);

        // parsing end

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
