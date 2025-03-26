package task3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Task2.Item2d;
/** ConcreteProduct
* (Шаблон проектирования
* Factory Method)<br>
* Вычисление функции,
* сохранение и отображение
* результатов
* @author xone
* @version 1.0
* @see View
*/
public class ViewResult implements View {
/** Имя файла, используемое при сериализации */
private static final String FNAME = "items.bin";
/** Определяет количество значений для вычисления по умолчанию */
private static final int DEFAULT_NUM = 10;
/** Коллекция аргументов и результатов вычислений */
private ArrayList<Item2d> items = new ArrayList<Item2d>();
/** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
* с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
*/
public ViewResult() {
this(DEFAULT_NUM);
}
/** Инициализирует коллекцию {@linkplain ViewResult#items}
* @param n начальное количество элементов
*/
public ViewResult(int n) {
for(int ctr = 0; ctr < n; ctr++) {
items.add(new Item2d());
}
}
/** Получить значение {@linkplain ViewResult#items}
* @return текущее значение ссылки на объект {@linkplain ArrayList}
*/
public ArrayList<Item2d> getItems() {
return items;
}
/** Вычисляет значение функции
* @param x аргумент вычисляемой функции
* @return результат вычисления функции
*/
private double calc(double x) {

        int integerPart = (int) x;
        double fractionalPart = x - integerPart;

        // Конвертація цілої частини в двійкову
        String binaryInteger = Integer.toBinaryString(integerPart);
        
        // Конвертація дробової частини
        StringBuilder binaryFraction = new StringBuilder();
        int precision = 10; // Кількість знаків після коми

        while (fractionalPart > 0 && precision > 0) {
            fractionalPart *= 2;
            int bit = (int) fractionalPart;
            binaryFraction.append(bit);
            fractionalPart -= bit;
            precision--;
        }

    String binaryResult = binaryInteger + (binaryFraction.length() > 0 ? "." + binaryFraction : "");

    double ress = Double.parseDouble(binaryResult);
    
    return ress;

//return Math.sin(x * Math.PI / 180);
}
/** Вычисляет значение функции и сохраняет
* результат в коллекции {@linkplain ViewResult#items}
* @param stepX шаг приращения аргумента
*/
public void init(double stepX) {
double x = stepX;//0.0;
for(Item2d item : items) {
item.setXY(x, calc(x));

//viewInit();
//x += stepX;
x = (Math.random() * 100.0);
}
}
/** Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
* {@inheritDoc}
*/
@Override
public void viewInit() {

init(Math.random() * 100.0);
}
/** Реализация метода {@linkplain View#viewSave()}<br>
* {@inheritDoc}
*/
@Override
public void viewSave() throws IOException {
ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
os.writeObject(items);
os.flush();
os.close();
}
/** Реализация метода {@linkplain View#viewRestore()}<br>
* {@inheritDoc}
*/
@SuppressWarnings("unchecked")
@Override
public void viewRestore() throws Exception {
ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
items = (ArrayList<Item2d>) is.readObject();
is.close();
}
/** Реализация метода {@linkplain View#viewHeader()}<br>
* {@inheritDoc}
*/
@Override
public void viewHeader() {
System.out.println("Results:");
}
/** Реализация метода {@linkplain View#viewBody()}<br>
* {@inheritDoc}
*/
@Override
public void viewBody() {
for(Item2d item : items) {
//System.out.printf("(%.3f; %.3f) ", item.getX(), item.getY());
System.out.println(item.getX() + "; " + item.getY());
}
System.out.println();
}
/** Реализация метода {@linkplain View#viewFooter()}<br>
* {@inheritDoc}
*/
@Override
public void viewFooter() {
System.out.println("End.");
}
/** Реализация метода {@linkplain View#viewShow()}<br>
* {@inheritDoc}
*/
@Override
public void viewShow() {
viewHeader();
viewBody();

viewFooter();
}
}