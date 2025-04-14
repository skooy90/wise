package org.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Rq == quest
public class Rq {

  private String actionCode;
  private Map<String, String> params;


  public Rq(String cmd){
    //parsing 기존에 들어온 개념을 쪼개서 나눈다.
    String[] cmdBits = cmd.split("\\?", 2);
//          for(String i : cmdBits){
//        System.out.println(i);
    actionCode = cmdBits[0];
    params = new HashMap<>();

    if(cmdBits.length == 1){
      return;
    }

    String[] paramBits = cmdBits[1].split("=", 2);

    if (paramBits.length == 1){
      return;
    }

    String key = paramBits[0];
    String value =paramBits[1];
    params.put(key, value);

    // parsing end
  }

  public String getActionCode(){
    return actionCode;
  }
  public String getParams(String key){
    return params.get(key);
  }


  public int getParams(String idValue, int defaultValue ) {
    try {
      return Integer.parseInt(getParams("id"));

    }
    catch (NumberFormatException e){
      System.out.println("id(정수)를 제대로 입력해주세요.");
    }
    return defaultValue;
  }
}
