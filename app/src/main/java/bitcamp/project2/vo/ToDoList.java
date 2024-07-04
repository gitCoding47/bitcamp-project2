package bitcamp.project2.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList {
  private List<Entry> entries = new ArrayList<>();

  public void addEntry(Entry entry) {
    entries.add(entry);
    Collections.sort(entries, Comparator.comparing(Entry::getDate));
    System.out.println("항목이 추가되었습니다: " + entry.getDescription());
  }

  public boolean deleteEntry(int index) {
    if (index >= 0 && index < entries.size()) {
      entries.remove(index);
      return true;
    }
    return false;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void showEntries() {
    if (entries.isEmpty()) {
      System.out.println("내역이 없습니다.");
      return;
    }

    System.out.println("번호 날짜 내역");
    for (int i = 0; i < entries.size(); i++) {
      Entry entry = entries.get(i);
      System.out.printf("%d. %s | %s\n", (i + 1), entry.getDate(), entry.getDescription());
    }
  }
}
