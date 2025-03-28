package task5;
import Task2.Item2d;
import task3.View;
import task3.ViewResult;

/** Консольная команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class SortConsoleCommand
extends SortItemCommand
implements ConsoleCommand {
/** Объект, реализующий интерфейс {@linkplain View};
* обслуживает коллекцию объектов {@linkplain ex01.Item2d}
*/
private View view;
/** Возвращает поле {@linkplain SortConsoleCommand#view}
* @return значение {@linkplain SortConsoleCommand#view}
*/
public View getView() {
return view;
}
/** Устанавливает поле {@linkplain SortConsoleCommand#view}
* @param view значение для {@linkplain SortConsoleCommand#view}
* @return новое значение {@linkplain SortConsoleCommand#view}
*/
public View setView(View view) {
return this.view = view;
}
/** Инициализирует поле {@linkplain SortConsoleCommand#view}
* @param view объект, реализующий интерфейс {@linkplain View}
*/
public SortConsoleCommand(View view) {
this.view = view;
}
@Override
public char getKey() {
return 'a';
}
@Override
public String toString() {
return "'a'sort";
}
@Override
public void execute() {
System.out.println("Sorting ");
for (Item2d item : ((ViewResult)view).getItems()) {

    super.setItem(item);

    for (Item2d item2 : ((ViewResult)view).getItems()) {

super.setItem2(item2);
super.execute();

    }

}
view.viewShow();
}
}