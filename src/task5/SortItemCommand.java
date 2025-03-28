package task5;
import Task2.Item2d;

/** Команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class SortItemCommand implements Command {
/** Обрабатываемый объект; шаблон Command */
private Item2d item;

private Item2d item2;

/** Параметр команды; шаблон Command */
private double offset;
/** Устанавливаент поле {@linkplain ChangeItemCommand#item}
* @param item значение для {@linkplain ChangeItemCommand#item}
* @return новое значение {@linkplain ChangeItemCommand#item}
*/
public Item2d setItem(Item2d item) {
return this.item = item;
}
/** Возвращает поле {@linkplain ChangeItemCommand#item}
* @return значение {@linkplain ChangeItemCommand#item}
*/
public Item2d getItem() {
return item;
}
/** Устанавливаент поле {@linkplain ChangeItemCommand#offset}
* @param offset значение для {@linkplain ChangeItemCommand#offset}
* @return новое значение {@linkplain ChangeItemCommand#offset}
*/
public double setOffset(double offset) {
return this.offset = offset;
}
/** Возвращает поле {@linkplain ChangeItemCommand#offset}
* @return значение {@linkplain ChangeItemCommand#offset}
*/
public double getOffset() {
return offset;
}

public Item2d setItem2(Item2d item2) {
    return this.item2 = item2;
    }

    public Item2d getItem2() {
    return item2;
    }

@Override
public void execute() {

        double boxX = item2.getX();
        double boxY = item2.getY();

        if (item2.getX() < item.getX()) {
            
            item2.setX(item.getX());
            item.setX(boxX);

            item2.setY(item.getY());
            item.setY(boxY);

        }
}
}