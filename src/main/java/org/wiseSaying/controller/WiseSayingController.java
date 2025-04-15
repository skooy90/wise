package org.wiseSaying.controller;

import org.project.Container;
import org.project.Rq;
import org.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

  public WiseSayingController() {
  }

  int lastId = 1;
  List<WiseSaying> wiseSayingList = new ArrayList<>();

  public void add() {
    System.out.print("명언 : ");
    String content = Container.getScanner().nextLine();
    System.out.print("인물 : ");
    String person = Container.getScanner().nextLine();
    System.out.printf("%d번 명언이 등록되었습니다.\n", lastId);

    WiseSaying temp = new WiseSaying(lastId, content, person);
    wiseSayingList.add(temp);

    lastId++;
  }

  public void list() {
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
      System.out.println("id를 제대로 입력해주세요");
    } else {

      WiseSaying removeWiseSaying = findById(id);
      if (removeWiseSaying != null) {
        wiseSayingList.remove(removeWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
      } else {

        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
      }
    }
  }


    public WiseSaying findById ( int id){
      for (WiseSaying wiseSaying : wiseSayingList) {
        if (id == wiseSaying.getId()) {
          return wiseSaying;
        }
      }
      return null;
    }

  public void modify(Rq rq) {
    int id = rq.getParams("id", -1);
    if (id == -1) {
      System.out.println("id를 제대로 입력해주세요");
    } else {

      WiseSaying modifyWiseSaying = findById(id);
      if (modifyWiseSaying != null){
        System.out.println("명언(기존) : " + modifyWiseSaying.getContent());
        System.out.println("인물(기존) : " + modifyWiseSaying.getPerson());
        System.out.println("명언을 수정해주세요!");
        System.out.print("명언 : ");
        String newcontent = Container.getScanner().nextLine();
        System.out.print("인물 : ");
        String newperson = Container.getScanner().nextLine();
        System.out.printf("%d번 명언이 재등록되었습니다.\n", modifyWiseSaying.getId());

        modifyWiseSaying.setPerson(newperson);
        modifyWiseSaying.setContent(newcontent);

      } else {
        System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
      }
    }
  }
}
