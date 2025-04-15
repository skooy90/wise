package org.wiseSaying.service;

import org.wiseSaying.entity.WiseSaying;
import org.wiseSaying.repository.WiseSayingRepository;


import java.util.List;

public class WiseSayingService {
  int lastId = 1;

  WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

  public int add(String content, String person) {
    int id = lastId;
    WiseSaying temp = new WiseSaying(id, content, person);
    wiseSayingRepository.add(temp);
    lastId++;

    return id;
  }

  public List<WiseSaying> getList() {
    return wiseSayingRepository.getList();
  }

  public void delete(WiseSaying removeWiseSaying) {
    wiseSayingRepository.delete(removeWiseSaying);
  }

  public int modify(WiseSaying modifyWiseSaying, String newContent, String newPerson) {
    modifyWiseSaying.setContent(newContent);
    modifyWiseSaying.setPerson(newPerson);

    return modifyWiseSaying.getId();
  }

  public WiseSaying findById(int id) {
    List<WiseSaying> wiseSayingList = wiseSayingRepository.getList();
    for (WiseSaying wiseSaying : wiseSayingList) {
      if (id == wiseSaying.getId()) {
        return wiseSaying;
      }
    }
    return null;
  }
}