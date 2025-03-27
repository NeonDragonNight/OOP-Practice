package task4;
import task3.View;
/** Вычисление и отображение результатов<br>
* Содержит реализацию статического метода main()
* @author xone
* @version 3.0
* @see Main#main
*/
public class Main extends task3.Main {
/** Инициализирует поле {@linkplain task3.Main#view view} */
public Main(View view) {
super(view);
}
/** Выполняется при запуске программы;
* вызывает метод {@linkplain task3.Main#menu menu()}
* @param args - параметры запуска программы
*/
public static void main(String[] args) {
Main main = new Main(new ViewableTable().getView());
main.menu();
}
}