package task4;
import task3.ViewableResult;
import task3.View;
/** ConcreteCreator
* (шаблон проектирования
* Factory Method)<br>
* Объявляет метод,
* "фабрикующий" объекты
* @author xone
* @version 1.0
* @see ViewableResult
* @see ViewableTable#getView()
*/
public class ViewableTable extends ViewableResult {
/** Создаёт отображаемый объект {@linkplain ViewTable} */
@Override
public View getView() {
return new ViewTable();
}
}