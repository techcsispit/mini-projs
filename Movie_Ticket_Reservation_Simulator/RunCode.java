import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class RunCode extends JFrame implements ActionListener { //A class with a main method to run the Project class. Just for order and neatness
    //This class acts as a menu and communicator between all classes in the project
    JButton bookticket;
    JButton cost_of_ticket;
    JButton total_seats;
    JButton Deletebooking;
    JButton ModifyBooking;
    JLabel PVR;
    String address; //A variable to store email address
    ImageIcon logo = new ImageIcon("PVRLogo1.png");

    RunCode() {  //Constructing JFrame in this constructor
        bookticket = new JButton(); //Initializing all JButtons
        cost_of_ticket = new JButton();
        total_seats = new JButton();
        Deletebooking = new JButton();
        ModifyBooking=new JButton();
        PVR=new JLabel();

        //ADDING PROPERTIES TO ALL JBUTTONS

        bookticket.setBounds(200, 500, 150, 60);
        bookticket.setText("Book tickets");
        bookticket.setFocusable(false);
        bookticket.setHorizontalTextPosition(JButton.CENTER);
        bookticket.setVerticalTextPosition(JButton.CENTER);
        bookticket.setBackground(Color.CYAN);
        bookticket.addActionListener(this);

        cost_of_ticket.setBounds(450, 500, 200, 60);
        cost_of_ticket.setText("Check cost of reservation");
        cost_of_ticket.setFocusable(false);
        cost_of_ticket.setHorizontalTextPosition(JButton.CENTER);
        cost_of_ticket.setVerticalTextPosition(JButton.CENTER);
        cost_of_ticket.setBackground(Color.ORANGE);
        cost_of_ticket.addActionListener(this);

        total_seats.setBounds(750, 500, 250, 60);
        total_seats.setText("Check the number of seats booked");
        total_seats.setFocusable(false);
        total_seats.setHorizontalTextPosition(JButton.CENTER);
        total_seats.setVerticalTextPosition(JButton.CENTER);
        total_seats.setBackground(Color.GREEN);
        total_seats.addActionListener(this);

        Deletebooking.setBounds(1100, 500, 150, 60);
        Deletebooking.setText("Cancel reservation");
        Deletebooking.setFocusable(false);
        Deletebooking.setHorizontalTextPosition(JButton.CENTER);
        Deletebooking.setVerticalTextPosition(JButton.CENTER);
        Deletebooking.setBackground(Color.RED);
        Deletebooking.addActionListener(this);

        ModifyBooking.setBounds(1350,500,150,60);
        ModifyBooking.setText("Modify booking");
        ModifyBooking.setFocusable(false);
        ModifyBooking.setVerticalTextPosition(JButton.CENTER);
        ModifyBooking.setHorizontalTextPosition(JButton.CENTER);
        ModifyBooking.setBackground(Color.pink);
        ModifyBooking.addActionListener(this);

        //ADDING BUTTONS TO THE FRAME

        PVR.setIcon(logo);
        PVR.setBounds(475,125,600,216);


        this.add(bookticket);
        this.add(cost_of_ticket);
        this.add(total_seats);
        this.add(Deletebooking);
        this.add(ModifyBooking);
        this.add(PVR);
        this.setTitle("PVR BOOKING PORTAL||HOME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { //This method will be invoked when any JButton is pressed
        FileMethods obj = new FileMethods();
        if (e.getSource() == bookticket) {
            //this.dispose();
            new Reservation();
        } else if (e.getSource() == cost_of_ticket) {
            try {
                address = JOptionPane.showInputDialog("Please enter your email address: ");
                obj.search(address);
            } catch (Exception exception) {
                return;
            }
        } else if (e.getSource() == total_seats) {
            try {
                obj.read();
            } catch (Exception exception) {
                return;
            }
        } else if (e.getSource() == Deletebooking) {
            try {
                address = JOptionPane.showInputDialog("Please enter your email address: ");
                obj.delete(address);
            } catch (Exception exception) {
                return;
            }
        } else if(e.getSource() == ModifyBooking){
            try{
                address=JOptionPane.showInputDialog("Please enter your email address: ");
                obj.modify(address);
            }catch(Exception exception){
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new RunCode();
    }
}
