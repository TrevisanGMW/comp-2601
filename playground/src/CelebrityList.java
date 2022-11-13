import javax.swing.*;
class CelebrityList
{
    private JFrame frame;
    private JPanel panel;
    private JList<Celebrity> list;
    private DefaultListModel<Celebrity> model;
    private JLabel label;
    private JSplitPane splitPane; // looks nice

    CelebrityList()
    {
        frame = new JFrame("Famous People");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // close this one only

        panel = new JPanel();
        list = new JList<>();
        model = new DefaultListModel<>();
        label = new JLabel();
        splitPane = new JSplitPane();

        panel.add(label);
        list.setModel(model);
        splitPane.setLeftComponent(new JScrollPane(list));
        splitPane.setRightComponent(panel);
        frame.add(splitPane);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        model.addElement(new Celebrity("Tiger", "Woods", "Golf", 1975));

        list.getSelectionModel().addListSelectionListener(listSelectionEvent -> {
            Celebrity c = list.getSelectedValue();
            label.setText("Name: " + c.firstName + " " + c.lastName + " (" + c.famousFor + ") born in " + c.yearBorn);
        });


    }

    public static void main(final String[] args)
    {
        CelebrityList celebrityList;
        celebrityList = new CelebrityList();


    }
}


