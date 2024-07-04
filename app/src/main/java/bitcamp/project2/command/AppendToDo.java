package bitcamp.project2.command;

import bitcamp.project2.vo.Entry;
import bitcamp.project2.vo.ToDoList;
import bitcamp.project2.util.Prompt;

public class AppendToDo {
  private ToDoList toDoList;

  public AppendToDo(ToDoList toDoList) {
    this.toDoList = toDoList;
  }

  public void append(String subMenuTitle) {
    String description = Prompt.inputString("내역을 입력하세요: ");
    String date = Prompt.inputString("날짜를 입력하세요 (YYYY-MM-DD): ");
    Entry entry = new Entry(description, date);
    toDoList.addEntry(entry);
  }
}
