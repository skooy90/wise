
package org.wiseSaying.repository;

import org.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
  List<WiseSaying> wiseSayingList = new ArrayList<>();


  public void add(WiseSaying temp) {
    wiseSayingList.add(temp);
  }

  public List<WiseSaying> getList() {
    return wiseSayingList;
  }

  public void delete(WiseSaying removeWiseSaying) {
    wiseSayingList.remove(removeWiseSaying);
  }
}