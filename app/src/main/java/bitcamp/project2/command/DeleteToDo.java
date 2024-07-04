package bitcamp.project2.command;

import bitcamp.project2.vo.ToDoList;
import bitcamp.project2.util.Prompt;

public class DeleteToDo {
  private ToDoList toDoList;

  public DeleteToDo(ToDoList toDoList) {
    this.toDoList = toDoList;
  }

  public void delete(String subMenuTitle) {
    toDoList.showEntries();
    int index = Prompt.inputInt("삭제할 항목 번호를 입력하세요: ") - 1;

    if (toDoList.deleteEntry(index)) {
      System.out.println("항목이 삭제되었습니다.");
    } else {
      System.out.println("잘못된 번호입니다.");
    }
  }
}
