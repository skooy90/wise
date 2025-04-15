package org.wiseSaying.controller;

import org.project.Container;
import org.project.Rq;
import org.wiseSaying.entity.WiseSaying;
import org.wiseSaying.repository.WiseSayingRepository;
import org.wiseSaying.service.WiseSayingService;

import java.util.List;


public class WiseSayingController {

  WiseSayingService wiseSayingService = new WiseSayingService();


  public WiseSayingController() {
  }

  public void add() {
    System.out.print("명언 : ");
    String content = Container.getScanner().nextLine();
    System.out.print("인물 : ");
    String person = Container.getScanner().nextLine();

    int id = wiseSayingService.add(content, person);

    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
  }

  public void list() {
    List<WiseSaying> wiseSayingList = wiseSayingService.getList();

    if (wiseSayingList.size() == 0) {
      System.out.println("등록된 명언이 없습니다.");
    } else {
      System.out.println("번호   /     인물     /    명언");
      System.out.println("=".repeat(30));
      for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
        WiseSaying temp = wiseSayingList.get(i);
        System.out.printf("%d        %s      %s\n", temp.getId(), temp.getPerson(), temp.getContent());
      }

    }
  }

  public void delete(Rq rq) {

    int id = rq.getParams("id", -1);
    if (id == -1) {
      System.out.println("id(정수)를 제대로 입력해주세요.");
    } else {
      WiseSaying removeWiseSaying = wiseSayingService.findById(id);
      if (removeWiseSaying != null) {
        wiseSayingService.delete(removeWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
      } else {
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
      }
    }

  }

  public void modify(Rq rq) {
    int id = rq.getParams("id", -1);
    if (id == -1) {
      System.out.println("id(정수)를 제대로 입력해주세요.");
    } else {
      WiseSaying modifyWiseSaying = wiseSayingService.findById(id);

      if (modifyWiseSaying != null) {
        System.out.println("명언(기존) : " + modifyWiseSaying.getContent());
        System.out.println("인물(기존) : " + modifyWiseSaying.getPerson());

        System.out.print("명언 : ");
        String newContent = Container.getScanner().nextLine();
        System.out.print("인물 : ");
        String newPerson = Container.getScanner().nextLine();
        int modifiedId = wiseSayingService.modify(modifyWiseSaying, newContent, newPerson);

        System.out.printf("%d번 명언이 수정되었습니다.\n", modifiedId);
      } else {
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
      }
    }

  }


}