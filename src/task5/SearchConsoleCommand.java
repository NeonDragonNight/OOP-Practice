package task5;

import java.util.Scanner;

import Task2.Item2d;
import task3.View;
import task3.ViewResult;

//import tt.ChangeConsoleCommand;

/** Консольная команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class SearchConsoleCommand
extends SearchItemCommand
implements ConsoleCommand {
/** Объект, реализующий интерфейс {@linkplain View};
* обслуживает коллекцию объектов {@linkplain ex01.Item2d}
*/
private View view;
/** Возвращает поле {@linkplain ChangeConsoleCommand#view}
* @return значение {@linkplain ChangeConsoleCommand#view}
*/
public View getView() {
return view;
}
/** Устанавливает поле {@linkplain ChangeConsoleCommand#view}
* @param view значение для {@linkplain ChangeConsoleCommand#view}
* @return новое значение {@linkplain ChangeConsoleCommand#view}
*/
public View setView(View view) {
return this.view = view;
}
/** Инициализирует поле {@linkplain ChangeConsoleCommand#view}
* @param view объект, реализующий интерфейс {@linkplain View}
*/
public SearchConsoleCommand(View view) {
this.view = view;
}
@Override
public char getKey() {
return 'e';
}
@Override
public String toString() {
return "'e'search";
}
@Override
public void execute() {

        setOffkey(0);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer to search: ");
        int inputNumber = scanner.nextInt();

        setOffset(inputNumber);

for (Item2d item : ((ViewResult)view).getItems()) {

    super.setItem(item);
    super.execute();
}

if (getOffkey() == 1) {
    System.out.println("Searching success");
}
else System.out.println("Searching fail");

view.viewShow();
}
}