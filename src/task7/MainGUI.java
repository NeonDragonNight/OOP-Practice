package task7;

import task3.View;
import task3.ViewResult;
import task4.ViewableTable;
import task5.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import Task2.Item2d;

public class MainGUI extends JFrame {

    private JCheckBox chek;

    private View view = new ViewableTable().getView();
    private JTable table;
    private DefaultTableModel tableModel;

    public MainGUI() {
        setTitle("Десяткове в бінарне");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 6, 5, 5));

        JButton viewBtn = new JButton("Показати");
        JButton restoreBtn = new JButton("Відновити");
        JButton saveBtn = new JButton("Зберегти");
        JButton generateBtn = new JButton("Згенерувати");
        JButton sortBtn = new JButton("Сортувати");
        JButton cleanBtn = new JButton("Очистити");

        add (chek = new JCheckBox ("Очищувати при оновленні"), BorderLayout.SOUTH);

        panel.add(viewBtn).setBackground(Color.orange);
        panel.add(restoreBtn).setBackground(Color.orange);
        panel.add(saveBtn).setBackground(Color.orange);
        panel.add(generateBtn).setBackground(Color.orange);
        panel.add(sortBtn).setBackground(Color.orange);
        panel.add(cleanBtn).setBackground(Color.orange);

        String[] columnNames = {"Dec", "Bin"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        viewBtn.addActionListener(e -> updateTable());
        cleanBtn.addActionListener(e -> cleanTable());
        restoreBtn.addActionListener(e -> {
            new RestoreConsoleCommand(view).execute();
            updateTable();
        });
        saveBtn.addActionListener(e -> new SaveConsoleCommand(view).execute());
        generateBtn.addActionListener(e -> {
            new GenerateConsoleCommand(view).execute();
            updateTable();
        });
        sortBtn.addActionListener(e -> {
            new SortConsoleCommand(view).execute();
            updateTable();
        });

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Метод для оновлення таблиці
    private void updateTable() {

        if(chek.isSelected() == true)tableModel.setRowCount(0);

        for (Item2d item : ((ViewResult)view).getItems()){
            tableModel.addRow(new Object[]{item.getX(), item.getY()});
        }

        tableModel.addRow(new Object[]{"", ""});
    }

    // Очистити таблицю
    private void cleanTable(){
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
