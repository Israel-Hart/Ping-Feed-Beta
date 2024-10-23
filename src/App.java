import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font; 
import java.awt.BorderLayout;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import java.awt.Component;

class App  {
    private JFrame frame; 
    private JPanel content_panel, north, btn_panel, clear_panel;
    protected JPanel display_panel; 
    private JButton add_btn, ping_btn, clear_btn; 
    private JLabel title, message; 
    private JTextField textField;
    private String[] add_messages;
    private JOptionPane pane;
    private String address; 

    interface AppActions {
        public void showMessage(String message); 
    }

    /* 
     * Initialize Components 
     */
    App(String title) 
    {
        this.title = new JLabel(title);
        this.frame = new JFrame();
        this.textField = new JTextField();
        this.content_panel = new JPanel();
        this.north = new JPanel(); 
        this.btn_panel = new JPanel(); 
        this.display_panel = new JPanel(); //handles display of results from ping
        this.clear_panel = new JPanel(); 
        this.add_btn = new JButton("add"); 
        this.ping_btn = new JButton("ping"); 
        this.clear_btn = new JButton("clear");
        this.add_messages = new String[]{"Item added", "Item exists!", "Invalid Input"}; // message return when add button is clicked 

        createGui(); //create components and put things together
        addListeners(); //add action listener to components and handle actions 
    }

    App() {this("Building");}

    private void createGui() { 

        /*
         * Format Components
         */
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(new EmptyBorder(10,10,10,10));
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        textField.setBorder(new EmptyBorder(5,5,5,5));
        textField.setFont(new Font("Consolas", Font.PLAIN, 14));

        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        content_panel.setPreferredSize(new Dimension(400,500));
        content_panel.setLayout(new BorderLayout());

        display_panel.setBackground(Color.black); 
        display_panel.setLayout(new BoxLayout(display_panel, BoxLayout.Y_AXIS));
        display_panel.setBorder(new EmptyBorder(10,10,10,10)); 

        /* 
         * Add Components 
         */
        btn_panel.add(add_btn); 
        btn_panel.add( ping_btn);

        north.add(title); 
        north.add(textField);
        north.add(btn_panel);

        clear_panel.add(clear_btn); 

        content_panel.add(north, BorderLayout.NORTH); 
        content_panel.add(display_panel, BorderLayout.CENTER); 
        content_panel.add(clear_panel, BorderLayout.SOUTH);

        /*
         * Format Frame
         */
        frame.setTitle("PingFeed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(content_panel); 
        frame.setResizable(false); 
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    /*
     * Action Listener
     */
    private void addListeners() {
        Net net = new Net(); 
        ActionListener ears = new ActionListener(){

            @Override 
            public void actionPerformed(ActionEvent e) {
                JButton btn_clicked = (JButton) e.getSource(); 
                btn_clicked = (JButton) e.getSource();
                
                if(btn_clicked == add_btn) 
                {
                    String pingRes = net.ping("www.google.com", 1000) ? " is reachable" : "is not reachable";
                    String hostname = net.getHost();
                    createLabel(hostname + pingRes); 
                }

                if(btn_clicked == ping_btn){
                    
                    if(net.validateAddress(textField.getText()))
                    {
                        print("true"); 
                        // JOptionPane.showMessageDialog(frame, "Address is ");
                    }else {
                        String pingRes = net.ping("www.google.com", 1000) ? " is reachable" : "is not reachable";
                        String hostname = net.getHost();
                        createLabel(hostname + pingRes);
                        print("false");
                    }
                    
                }

                if(btn_clicked == clear_btn) 
                {
                   print("inside actionPerformed"); 
                  try {
                    Component[] components = display_panel.getComponents();
                    for(Component c : components)
                    { 
                        display_panel.remove(c);
                    }
                    display_panel.repaint(); 
                    display_panel.revalidate(); 
                  } catch(Exception ex) 
                  {
                    ex.printStackTrace();
                  }
                }

            }
        };

        add_btn.addActionListener(ears); 
        ping_btn.addActionListener(ears); 
        clear_btn.addActionListener(ears); 
        
    }

    void createLabel(String str) 
    {
         message = new JLabel(str); 
         message.setFont(new Font("consolas", Font.PLAIN, 10));
         message.setForeground(Color.green); 
         display_panel.add(message);
         display_panel.revalidate(); 
    }

    void print(String message) { 
        System.out.println(message); 
    }
}