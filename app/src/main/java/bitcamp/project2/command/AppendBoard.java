package bitcamp.project2.command;

import bitcamp.project2.util.Prompt;
import bitcamp.project2.vo.AccountBook;
import bitcamp.project2.vo.Entry;

public class AppendBoard {

  private AccountBook accountBook;

  public AppendBoard(AccountBook accountBook) {
    this.accountBook = accountBook;
  }

  public void append(String subMenuTitle) {
    switch (subMenuTitle) {
      case "예산 설정":
        if (accountBook.getMonthlyBudget() != 0) {
          System.out.println("예산이 이미 설정되어 있습니다!! 재설정을 원하시면 '4. 수정' 메뉴에서 재설정 해주십시오.");
          break;
        }
        int budget = Prompt.inputInt("예산 금액을 입력하세요: ");
        accountBook.setMonthlyBudget(budget);
        System.out.println("월 예산이 설정되었습니다: " + budget);
        break;
      case "수입 등록":
        String incomeDesc = Prompt.input("수입 내역을 입력하세요: ");
        int incomeAmount = Prompt.inputInt("수입 금액을 입력하세요: ");
        String incomeDate = Prompt.input("수입 날짜를 입력하세요 (YYYY-MM-DD): ");
        String incomeCategory = Prompt.input("수입 카테고리를 입력하세요: ");
        accountBook.addEntry(new Entry("수입", incomeDesc, incomeAmount, incomeDate, incomeCategory));
        break;
      case "지출 등록":
        String expenseDesc = Prompt.input("지출 내역을 입력하세요: ");
        int expenseAmount = Prompt.inputInt("지출 금액을 입력하세요: ");
        String expenseDate = Prompt.input("지출 날짜를 입력하세요 (YYYY-MM-DD): ");
        String expenseCategory = Prompt.input("지출 카테고리를 입력하세요: ");
        accountBook.addEntry(
            new Entry("지출", expenseDesc, expenseAmount, expenseDate, expenseCategory));
        break;
      default:
        System.out.println("잘못된 메뉴 선택입니다.");
    }
  }
}
