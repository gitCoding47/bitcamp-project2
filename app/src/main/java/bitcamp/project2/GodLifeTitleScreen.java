package bitcamp.project2;

import java.util.Scanner;

public class GodLifeTitleScreen {
  // ANSI escape codes for colors and styles
  public static final String RESET = "\033[0m";
  public static final String RED = "\033[0;31m";
  public static final String GREEN = "\033[0;32m";
  public static final String YELLOW = "\033[0;33m";
  public static final String BLUE = "\033[0;34m";
  public static final String PURPLE = "\033[0;35m";
  public static final String CYAN = "\033[0;36m";
  public static final String WHITE = "\033[0;37m";
  public static final String BOLD = "\033[1m";
  public static final String UNDERLINE = "\033[4m";

  public static void showTitleScreen() {
    System.out.println(BOLD + BLUE + "*********************************" + RESET);
    System.out.println(BOLD + BLUE + "*        갓생 To-do list        *" + RESET);
    System.out.println(BOLD + BLUE + "*********************************" + RESET);
    System.out.println();
    System.out.println(PURPLE + "  ██████╗     ██████╗    ██████╗       " + RESET);
    System.out.println(PURPLE + " ██╔════╝    ██╔═══██╗   ██╔══██╗      " + RESET);
    System.out.println(PURPLE + " ██║  ███╗   ██║   ██║   ██    ██╗      " + RESET);
    System.out.println(PURPLE + " ██║   ██║   ██║   ██║   ██╔═══██       " + RESET);
    System.out.println(PURPLE + " ╚██████╔╝   ╚██████╔╝   ███████       " + RESET);
    System.out.println(PURPLE + "  ╚═════╝     ╚═════╝    ╚═════╝           " + RESET);
    System.out.println();
    System.out.println(PURPLE + "  ██╗        ██╗   ███████╗   ███████╗    " + RESET);
    System.out.println(PURPLE + "  ██║        ██║   ██║        ██╔════╝    " + RESET);
    System.out.println(PURPLE + "  ██║        ██║   ██████╗    █████╗      " + RESET);
    System.out.println(PURPLE + "  ██║        ██║   ██╔═══╝    ██╔══╝      " + RESET);
    System.out.println(PURPLE + "  ███████╗   ██║   ██║        ███████╗    " + RESET);
    System.out.println(PURPLE + "  ╚══════╝   ╚═╝   ══╝        ╚══════╝    " + RESET);
    System.out.println();
    System.out.println(BOLD + YELLOW + "    엔터 키를 누르면 시작합니다.    " + RESET);
  }

  public static void waitForEnter() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(CYAN + "계속하려면 엔터 키를 누르세요..." + RESET);
    scanner.nextLine();
  }
}
