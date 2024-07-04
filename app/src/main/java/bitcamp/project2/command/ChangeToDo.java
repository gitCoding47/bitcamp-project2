package bitcamp.project2.command;

import bitcamp.project2.vo.Entry;
import bitcamp.project2.vo.ToDoList;
import bitcamp.project2.util.Prompt;

public class ChangeToDo {
  private ToDoList toDoList;

  public ChangeToDo(ToDoList toDoList) {
    this.toDoList = toDoList;
  }

  public void change(String subMenuTitle) {
    toDoList.showEntries();
    int index = Prompt.inputInt("수정할 항목 번호를 입력하세요: ") - 1;

    if (index >= 0 && index < toDoList.getEntries().size()) {
      Entry entry = toDoList.getEntries().get(index);
      String description = Prompt.inputString("새 내역을 입력하세요: ");
      String date = Prompt.inputString("새 날짜를 입력하세요 (YYYY-MM-DD): ");
      entry.setDescription(description);
      entry.setDate(date);
      System.out.println("항목이 수정되었습니다.");
    } else {
      System.out.println("잘못된 번호입니다.");
    }
  }
}
