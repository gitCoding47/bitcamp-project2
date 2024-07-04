package bitcamp.project2.command;

import bitcamp.project2.vo.ToDoList;
import bitcamp.project2.util.Prompt;

public class ViewToDo {
  private ToDoList toDoList;

  public ViewToDo(ToDoList toDoList) {
    this.toDoList = toDoList;
  }

  public void view(String subMenuTitle) {
    toDoList.showEntries();
  }
}
