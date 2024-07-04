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
    String date = Prompt.inputString("실행할 날짜와 시간을 입력해주세요. (YYYY-MM-DD HR:MIN): ");
    Entry entry = new Entry(description, date);
    toDoList.addEntry(entry);
  }
}
