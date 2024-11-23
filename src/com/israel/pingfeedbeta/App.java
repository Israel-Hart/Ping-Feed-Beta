/*
* realized java apps run faster when 
* import statement include only required files than everything ("*")
*/

import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane;


import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class App  {
    /*
    * Components Declarations 
    */
    private JFrame frame; 
    private JPanel content_panel, north, btn_panel, clear_panel;
    protected JPanel display_panel, input_wrap; 
    private JButton add_btn, ping_btn, clear_btn;
    private JScrollPane scroll_pane; 
    private JLabel title, message, input_label; 
    private JTextField textField;

    private Image icon;

    /* 
     * Initialize Components 
     */
    App(String title) 
    {
        init(title);
        createGui(); //create components and put things together
        addListeners(); //add action listeners to components and handle actions 
    }

    App() {this("Building");}

    private void init(String title) {
        this.title = new JLabel(title);
        this.input_label = new JLabel("Hostname / IP: "); 
        this.frame = new JFrame();
        this.textField = new JTextField();
        this.content_panel = new JPanel();
        this.north = new JPanel(); 
        this.input_wrap = new JPanel(); 
        this.btn_panel = new JPanel(); 
        this.display_panel = new JPanel(); //handles display of results from ping
        this.clear_panel = new JPanel(); 
        this.scroll_pane = new JScrollPane(display_panel); 
        this.add_btn = new JButton("add"); 
        this.ping_btn = new JButton("ping"); 
        this.clear_btn = new JButton("clear");
        this.icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Israel\\projects\\Ping-Feed-Beta\\res\\icons\\icon.png");
    }

    private void createGui() { 

        /*
         * Format Components
         */
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBorder(new EmptyBorder(10,10,10,10));
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        input_wrap.setLayout(new FlowLayout());
        input_label.setFont(new Font("Arial", Font.BOLD, 10));

        ping_btn.setFont(new Font("Arial", Font.BOLD, 10));
        clear_btn.setFont(new Font("Arial", Font.BOLD, 10));

        textField.setBorder(new EmptyBorder(5,5,5,5));
        textField.setFont(new Font("Consolas", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(300,30)); 

        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        content_panel.setPreferredSize(new Dimension(400,500));
        content_panel.setLayout(new BorderLayout());

        display_panel.setBackground(Color.black); 
        display_panel.setLayout(new BoxLayout(display_panel, BoxLayout.Y_AXIS));
        display_panel.setBorder(new EmptyBorder(10,10,10,10)); 

        scroll_pane.setBorder(null);  

          /*
         * Date picker
         */

         input_wrap.add(input_label); 
         input_wrap.add(textField); 
         
        /* 
         * Add Components 
         */
        // btn_panel.add(add_btn); 
        btn_panel.add( ping_btn);
        btn_panel.add( ping_btn);

        north.add(title); 
        north.add(input_wrap);        
        north.add(btn_panel);

        clear_panel.add(clear_btn);

        content_panel.add(north, BorderLayout.NORTH); 
        content_panel.add(scroll_pane, BorderLayout.CENTER); 
        content_panel.add(clear_panel, BorderLayout.SOUTH);

        /*
         * Format Frame
         */
        frame.setTitle("PingFeed Beta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(content_panel); 
        frame.setResizable(false);
        frame.setIconImage(icon);
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

                if(btn_clicked == ping_btn){
                    String user_input = textField.getText(); 
                    if(net.validateAddress(user_input))
                    {
                        clearDisplay(); 
                        String pingRes = net.ping(user_input, 500) ? " is reachable" : " is not reachable";
                        String hostname = net.getHost();
                        createLabel(hostname + pingRes);
                        print("false");
                    }else {
                        JOptionPane.showMessageDialog(frame, "Invalid Address", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }

                if(btn_clicked == clear_btn) 
                {
                    clearDisplay(); 
                }

            }
        };

        add_btn.addActionListener(ears); 
        ping_btn.addActionListener(ears); 
        clear_btn.addActionListener(ears);    
    }

    void clearDisplay() { 
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

    void createLabel(String str) 
    {
         message = new JLabel(str); 
         message.setFont(new Font("consolas", Font.PLAIN, 10));
         message.setForeground(Color.green); 
         display_panel.add(message);
         display_panel.revalidate(); 
    }
// shortcut to print 
    void print(String message) { 
        System.out.println(message); 
    }
}
