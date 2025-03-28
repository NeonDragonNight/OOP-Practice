package task5;
import Task2.Item2d;
/** Команда
* Change item;
* шаблон Command
* @author xone
* @version 1.0
*/
public class SearchItemCommand implements Command {
/** Обрабатываемый объект; шаблон Command */
private Item2d item;
/** Параметр команды; шаблон Command */
private double offset;
/** Устанавливаент поле {@linkplain ChangeItemCommand#item}
* @param item значение для {@linkplain ChangeItemCommand#item}
* @return новое значение {@linkplain ChangeItemCommand#item}
*/

private int offkey;

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

public int setOffkey(int offkey) {
    return this.offkey = offkey;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#offset}
    * @return значение {@linkplain ChangeItemCommand#offset}
    */
    public int getOffkey() {
    return offkey;
    }

@Override
public void execute() {

    int integerPart = (int) item.getX();

    if (integerPart == offset){
        System.out.printf("Decimal %.4f;Binary %.10f ", item.getX(), item.getY());

        offkey = 1;
    }

}
}