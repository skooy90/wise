package org.project;

import java.util.Scanner;

public class Container {
  private static Scanner sc;

  // 공통적으로 사용하는 자원들을 모아두는 공간 초기화
  public static void init() {
    sc = new Scanner(System.in);
  }

  // 공통적으로 사용하는 자원들을 모아두는 공간 해제
  public static void close() {
    sc.close();
  }

  public static Scanner getScanner() {
    return sc;
  }

}