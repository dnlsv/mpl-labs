import javax.swing.*;

public class Window extends JFrame {

    static JButton add, delete, edit;

    public Window(String str) {
        super(str);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add = new JButton("Add");
        delete = new JButton("Delete");
        edit = new JButton("Edit");

        setLayout(null);

        add.setSize(150, 30);
        add.setLocation(20, 20);
        delete.setSize(150, 30);
        delete.setLocation(20, 60);
        edit.setSize(150, 30);
        edit.setLocation(20, 100);

        add(add);
        add(delete);
        add(edit);
    }
}
