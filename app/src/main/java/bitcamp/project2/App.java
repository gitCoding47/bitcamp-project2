package bitcamp.project2;

import bitcamp.project2.command.AppendToDo;
import bitcamp.project2.command.ChangeToDo;
import bitcamp.project2.command.DeleteToDo;
import bitcamp.project2.command.ViewToDo;
import bitcamp.project2.util.Prompt;
import bitcamp.project2.vo.ToDoList;

public class App {

    String[] mainMenus = new String[] {"등록", "조회", "삭제", "수정", "도움말", "종료"};
    String[][] subMenus = {
        {"금일 To-do list", "내일 To-do list", "금주 To-do list", "이번 달 To-do list"},
        {"금일 To-do list 조회", "내일 To-do list 조회", "금주 To-do list 조회", "이번 달 To-do list 조회"},
        {"금일 To-do list 삭제", "내일 To-do list 삭제", "금주 To-do list 삭제", "이번 달 To-do list 삭제"},
        {"금일 To-do list 수정", "내일 To-do list 수정", "금주 To-do list 수정", "이번 달 To-do list 수정"},
    };

    ToDoList toDoList = new ToDoList();
    AppendToDo appendToDo = new AppendToDo(toDoList);
    ViewToDo viewToDo = new ViewToDo(toDoList);
    DeleteToDo deleteToDo = new DeleteToDo(toDoList);
    ChangeToDo changeToDo = new ChangeToDo(toDoList);

    public static void main(String[] args) {
        GodLifeTitleScreen.showTitleScreen();
        GodLifeTitleScreen.waitForEnter();
        System.out.println(GodLifeTitleScreen.GREEN + "To-do List 프로그램이 시작되었습니다." + GodLifeTitleScreen.RESET);

        new App().execute();
    }

    void execute() {
        printMenu();
        while (true) {
            try {
                String command = Prompt.inputString("메인>");
                if (command.equals("menu")) {
                    printMenu();
                } else {
                    int menuNo = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(menuNo, mainMenus);
                    if (menuTitle == null) {
                        System.out.println("유효한 메뉴 번호가 아닙니다.");
                    } else if (menuTitle.equals("종료")) {
                        break;
                    } else if (menuTitle.equals("도움말")) {
                        showHelp();
                    } else {
                        processMenu(menuTitle, subMenus[menuNo - 1]);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }

        System.out.println("종료합니다.");

        Prompt.close();
    }

    void printMenu() {
        String boldAnsi = "\033[1m";
        String redAnsi = "\033[31m";
        String resetAnsi = "\033[0m";

        String appTitle = "[To-do list 관리 시스템에 오신걸 환영합니다!!]\n";
        String line = "--------------------------------------------";

        System.out.println(boldAnsi + line + resetAnsi);
        System.out.println(boldAnsi + appTitle + resetAnsi);

        for (int i = 0; i < mainMenus.length; i++) {
            if (mainMenus[i].equals("종료")) {
                System.out.printf("%s%d. %s%s\n", (boldAnsi + redAnsi), (i + 1), mainMenus[i], resetAnsi);
            } else {
                System.out.printf("%d. %s\n", (i + 1), mainMenus[i]);
            }
        }

        System.out.println(boldAnsi + line + resetAnsi);
    }

    void printSubMenu(String menuTitle, String[] menus) {
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.println("\033[31m" + "\033[1m" + "9. 이전" + "\033[0m");
    }

    boolean isValidateMenu(int menuNo, String[] menus) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    String getMenuTitle(int menuNo, String[] menus) {
        return isValidateMenu(menuNo, menus) ? menus[menuNo - 1] : null;
    }

    void processMenu(String menuTitle, String[] menus) {
        printSubMenu(menuTitle, menus);
        while (true) {
            String command = Prompt.inputString(String.format("메인/%s>", menuTitle));
            if (command.equals("menu")) {
                printSubMenu(menuTitle, menus);
                continue;
            } else if (command.equals("9")) { // 이전 메뉴 선택
                break;
            }

            try {
                int menuNo = Integer.parseInt(command);
                String subMenuTitle = getMenuTitle(menuNo, menus);
                if (subMenuTitle == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                } else {
                    switch (menuTitle) {
                        case "등록":
                            appendToDo.append(subMenuTitle);
                            break;
                        case "조회":
                            viewToDo.view(subMenuTitle);
                            break;
                        case "삭제":
                            deleteToDo.delete(subMenuTitle);
                            break;
                        case "수정":
                            changeToDo.change(subMenuTitle);
                            break;
                        default:
                            System.out.printf("%s 메뉴의 명령을 처리할 수 없습니다.\n", menuTitle);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    void showHelp() {
        System.out.println("\033[1m");
        System.out.println("Help Menu:");
        System.out.println("1. 등록: 금일, 내일, 금주 또는 이번 달의 To-do 항목을 등록할 수 있습니다.\n");
        System.out.println("2. 조회: 금일, 내일, 금주 또는 이번 달의 To-do 항목을 조회할 수 있습니다.\n");
        System.out.println("3. 삭제: 금일, 내일, 금주 또는 이번 달의 To-do 항목을 삭제할 수 있습니다.\n");
        System.out.println("4. 수정: 금일, 내일, 금주 또는 이번 달의 To-do 항목을 수정할 수 있습니다.\n");
        System.out.println("5. 도움말: 사용법을 안내합니다.\n");
        System.out.println("6. 종료: 애플리케이션을 종료합니다.\n");
        System.out.println("메뉴 옵션을 다시 보고 싶으시면 'menu'를 입력해주세요.");
        System.out.println("\033[0m");
    }
}