import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Reservation extends JFrame implements MouseListener, ActionListener { /*Inheriting a JFrame(a GUI window
                                                                                 to add components too) class and linking
                                                                                 to the MouseListener and ActionListener
                                                                                 interfaces*/
    JFrame frame; //Declaring a JFrame
    JLabel seat1; //Declaring Jlabels(A GUI display area for text, image or both) to hold individual seats
    JLabel seat2;
    JLabel seat3;
    JLabel seat4;
    JLabel seat5;
    JLabel seat6;
    JLabel seat7;
    JLabel seat8;
    JLabel seat9;
    JLabel seat10;
    JLabel seat11;
    JLabel seat12;
    JLabel seat13;
    JLabel seat14;
    JLabel seat15;
    JLabel seat16;
    JLabel seat17;
    JLabel seat18;
    JLabel seat19;
    JLabel seat20;
    JLabel seat21;
    JLabel seat22;
    JLabel seat23;
    JLabel seat24;
    JLabel seat25;
    JLabel seat26;
    JLabel seat27;
    JLabel seat28;
    JLabel seat29;
    JLabel seat30;
    JLabel seat31;
    JLabel seat32;
    JLabel seat33;
    JLabel seat34;
    JLabel seat35;
    JLabel seat36;
    JLabel seat37;
    JLabel seat38;
    JLabel seat39;
    JLabel seat40;
    JLabel seat41;
    JLabel seat42;
    JLabel seat43;
    JLabel seat44;
    JLabel seat45;
    JLabel seat46;
    JLabel seat47;
    JLabel seat48;
    JButton pay; //Declaring a JButton(A button that performs an action when clicked on) for confirming payment

    int cost=0; //To store cumulative cost of all tickets
    String email; //To store email
    int seats=0; //To store individual seat count

    FileWriter data_storing;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter; //To store email and cost in a file

    //Images to be stored as icons for seats and dialogue boxes
    ImageIcon seat = new ImageIcon("seat3.png"); //Creating an ImageIcon object with desired filepath to the image
    ImageIcon selectedseat = new ImageIcon("sseat.png"); //Creating an ImageIcon object with desired filepath to the image
    ImageIcon green_tick=new ImageIcon("Green_tick.png"); //Creating an ImageIcon object with desired filepath to the image
    ImageIcon seat_taken=new ImageIcon("taken_seat.png");

    Reservation()  {
        frame = new JFrame(); //Initializing frame
        int ch = JOptionPane.showConfirmDialog(null, "Do you want to reserve tickets?", "CONFIRMATION WINDOW", JOptionPane.YES_NO_CANCEL_OPTION); // A variable to record choice
        if (ch == 0) { //O stands for yes in JOptionPanes(A standard dialogue box that informs user of something)
            email = JOptionPane.showInputDialog("Please enter your email id:"); //Asking user to enter email
            int space_check=0; //To check if there is any space in email
            int check=0; //To check if there is only one @ in email
            for(int i=0;i<email.length();i++){ //Loop to see whether email entered is valid or not
                if(email.charAt(i) == ' '){
                    space_check++;
                    break;
                }
                if(email.charAt(i) == '@'){
                    check++;
                }
            }
            if(check == 0 || space_check >= 1 || check > 1){
                JOptionPane.showMessageDialog(null,"Invalid email. Booking process terminated.","ERROR",JOptionPane.ERROR_MESSAGE);
            } else if(space_check == 0 && check == 1) {
                JPanel section1 = new JPanel(); //Creating(declaring) sections to hold seats. A JPanel is a GUI component that can contain other elements.
                JPanel section2 = new JPanel();
                JPanel section3 = new JPanel();
                pay = new JButton(); //Initializing JButton

                //WORKING ON SEATS INDIVIDUALLY

                seat1 = new JLabel(); //Initializing JLabel named seat1
                    try { //try-catch to detect and resolve exceptions
                        String name = "seat1";
                        if (SeatBooked(name) == true) { //Checking if seat has been booked or not
                            seat1.setIcon(seat_taken); //Setting up an image to the JLabel
                            seat1.setSize(50, 50); //Setting up dimensions of the JLabel
                        } else {//If not booked, setting up seat accordingly
                            seat1.setIcon(seat); //Setting up an image to the JLabel
                            seat1.setSize(50, 50);
                            seat1.addMouseListener(this); //Linking it with MouseListener interface, so when label is clicked,
                            // the control will go to mouseClicked(MouseEvent e)
                        }
                    } catch (IOException e) {
                        return;
                    }

                seat2 = new JLabel();
                    try {
                        if (SeatBooked("seat2") == true) {
                            seat2.setIcon(seat_taken);
                            seat2.setSize(50, 50);
                        } else {
                            seat2.setIcon(seat);
                            seat2.setSize(50, 50);
                            seat2.addMouseListener(this); //The 'this' keyword in this case acts as an instance of the class
                        }
                    } catch (Exception e){
                        return;
                    }

                seat3 = new JLabel();
                try {
                    if (SeatBooked("seat3") == true) {
                        seat3.setIcon(seat_taken);
                        seat3.setSize(50, 50);
                    } else {
                        seat3.setIcon(seat);
                        seat3.setSize(50, 50);
                        seat3.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat4 = new JLabel();
                try {
                    if (SeatBooked("seat4") == true) {
                        seat4.setIcon(seat_taken);
                        seat4.setSize(50, 50);
                    } else {
                        seat4.setIcon(seat);
                        seat4.setSize(50, 50);
                        seat4.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat5 = new JLabel();
                try {
                    if (SeatBooked("seat5") == true) {
                        seat5.setIcon(seat_taken);
                        seat5.setSize(50, 50);
                    } else {
                        seat5.setIcon(seat);
                        seat5.setSize(50, 50);
                        seat5.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat6 = new JLabel();
                try {
                    if (SeatBooked("seat6") == true) {
                        seat6.setIcon(seat_taken);
                        seat6.setSize(50, 50);
                    } else {
                        seat6.setIcon(seat);
                        seat6.setSize(50, 50);
                        seat6.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat7 = new JLabel();
                try {
                    if (SeatBooked("seat7") == true) {
                        seat7.setIcon(seat_taken);
                        seat7.setSize(50, 50);
                    } else {
                        seat7.setIcon(seat);
                        seat7.setSize(50, 50);
                        seat7.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat8 = new JLabel();
                try {
                    if (SeatBooked("seat8") == true) {
                        seat8.setIcon(seat_taken);
                        seat8.setSize(50, 50);
                    } else {
                        seat8.setIcon(seat);
                        seat8.setSize(50, 50);
                        seat8.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat9 = new JLabel();
                try {
                    if (SeatBooked("seat9") == true) {
                        seat9.setIcon(seat_taken);
                        seat9.setSize(50, 50);
                    } else {
                        seat9.setIcon(seat);
                        seat9.setSize(50, 50);
                        seat9.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat10 = new JLabel();
                try {
                    if (SeatBooked("seat10") == true) {
                        seat10.setIcon(seat_taken);
                        seat10.setSize(50, 50);
                    } else {
                        seat10.setIcon(seat);
                        seat10.setSize(50, 50);
                        seat10.addMouseListener(this);
                    }
                } catch (Exception e){
                    return;
                }

                seat11 = new JLabel();
                try {
                    String name = "seat11";
                    if (SeatBooked(name) == true) { 
                        seat11.setIcon(seat_taken); 
                        seat11.setSize(50, 50);
                    } else {
                        seat11.setIcon(seat); 
                        seat11.setSize(50, 50); 
                        seat11.addMouseListener(this);
                    }
                } catch (IOException e) {
                    return;
                }

                seat12 = new JLabel();
                try {
                    String name = "seat12";
                    if (SeatBooked(name) == true) { 
                        seat12.setIcon(seat_taken); 
                        seat12.setSize(50, 50);
                    } else {
                        seat12.setIcon(seat); 
                        seat12.setSize(50, 50); 
                        seat12.addMouseListener(this); 
                    }
                } catch (IOException e) {
                    return;
                }

                seat13 = new JLabel();
                try {
                    String name = "seat13";
                    if (SeatBooked(name) == true) { 
                        seat13.setIcon(seat_taken); 
                        seat13.setSize(50, 50);
                    } else {
                        seat13.setIcon(seat); 
                        seat13.setSize(50, 50); 
                        seat13.addMouseListener(this); 
                    }
                } catch (IOException e) {
                    return;
                }

                seat14 = new JLabel();
                try {
                    String name = "seat14";
                    if (SeatBooked(name) == true) { 
                        seat14.setIcon(seat_taken); 
                        seat14.setSize(50, 50);
                    } else {
                        seat14.setIcon(seat); 
                        seat14.setSize(50, 50); 
                        seat14.addMouseListener(this); 
                    }
                } catch (IOException e) {
                    return;
                }

                seat15 = new JLabel();
                try {
                    String name = "seat15";
                    if (SeatBooked(name) == true) { 
                        seat15.setIcon(seat_taken); 
                        seat15.setSize(50, 50);
                    } else {
                        seat15.setIcon(seat); 
                        seat15.setSize(50, 50); 
                        seat15.addMouseListener(this); 
                    }
                } catch (IOException e) {
                    return;
                }

                seat16 = new JLabel();
                try {
                    String name = "seat16";
                    if (SeatBooked(name) == true) {  
                        seat16.setIcon(seat_taken);   
                        seat16.setSize(50, 50);
                    } else {
                        seat16.setIcon(seat);   
                        seat16.setSize(50, 50);   
                        seat16.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat17 = new JLabel();
                try {
                    String name = "seat17";
                    if (SeatBooked(name) == true) {  
                        seat17.setIcon(seat_taken);   
                        seat17.setSize(50, 50);
                    } else {
                        seat17.setIcon(seat);   
                        seat17.setSize(50, 50);   
                        seat17.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat18 = new JLabel();
                try {
                    String name = "seat18";
                    if (SeatBooked(name) == true) {  
                        seat18.setIcon(seat_taken);   
                        seat18.setSize(50, 50);
                    } else {
                        seat18.setIcon(seat);   
                        seat18.setSize(50, 50);   
                        seat18.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat19 = new JLabel();
                try {
                    String name = "seat19";
                    if (SeatBooked(name) == true) {  
                        seat19.setIcon(seat_taken);   
                        seat19.setSize(50, 50);
                    } else {
                        seat19.setIcon(seat);   
                        seat19.setSize(50, 50);   
                        seat19.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat20 = new JLabel();
                try {
                    String name = "seat20";
                    if (SeatBooked(name) == true) {  
                        seat20.setIcon(seat_taken);   
                        seat20.setSize(50, 50);
                    } else {
                        seat20.setIcon(seat);   
                        seat20.setSize(50, 50);   
                        seat20.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat21 = new JLabel();
                try {
                    String name = "seat21";
                    if (SeatBooked(name) == true) {  
                        seat21.setIcon(seat_taken);   
                        seat21.setSize(50, 50);
                    } else {
                        seat21.setIcon(seat);   
                        seat21.setSize(50, 50);   
                        seat21.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat22 = new JLabel();
                try {
                    String name = "seat22";
                    if (SeatBooked(name) == true) {  
                        seat22.setIcon(seat_taken);   
                        seat22.setSize(50, 50);
                    } else {
                        seat22.setIcon(seat);   
                        seat22.setSize(50, 50);   
                        seat22.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat23 = new JLabel();
                try {
                    String name = "seat23";
                    if (SeatBooked(name) == true) {  
                        seat23.setIcon(seat_taken);   
                        seat23.setSize(50, 50);
                    } else {
                        seat23.setIcon(seat);   
                        seat23.setSize(50, 50);   
                        seat23.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat24 = new JLabel();
                try {
                    String name = "seat24";
                    if (SeatBooked(name) == true) {  
                        seat24.setIcon(seat_taken);   
                        seat24.setSize(50, 50);
                    } else {
                        seat24.setIcon(seat);   
                        seat24.setSize(50, 50);   
                        seat24.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat25 = new JLabel();
                try {
                    String name = "seat25";
                    if (SeatBooked(name) == true) {  
                        seat25.setIcon(seat_taken);   
                        seat25.setSize(50, 50);
                    } else {
                        seat25.setIcon(seat);   
                        seat25.setSize(50, 50);   
                        seat25.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat26 = new JLabel();
                try {
                    String name = "seat26";
                    if (SeatBooked(name) == true) {  
                        seat26.setIcon(seat_taken);   
                        seat26.setSize(50, 50);
                    } else {
                        seat26.setIcon(seat);   
                        seat26.setSize(50, 50);   
                        seat26.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat27 = new JLabel();
                try {
                    String name = "seat27";
                    if (SeatBooked(name) == true) {  
                        seat27.setIcon(seat_taken);   
                        seat27.setSize(50, 50);
                    } else {
                        seat27.setIcon(seat);   
                        seat27.setSize(50, 50);   
                        seat27.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat28 = new JLabel();
                try {
                    String name = "seat28";
                    if (SeatBooked(name) == true) {  
                        seat28.setIcon(seat_taken);   
                        seat28.setSize(50, 50);
                    } else {
                        seat28.setIcon(seat);   
                        seat28.setSize(50, 50);   
                        seat28.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat29 = new JLabel();
                try {
                    String name = "seat29";
                    if (SeatBooked(name) == true) {  
                        seat29.setIcon(seat_taken);   
                        seat29.setSize(50, 50);
                    } else {
                        seat29.setIcon(seat);   
                        seat29.setSize(50, 50);   
                        seat29.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat30 = new JLabel();
                try {
                    String name = "seat30";
                    if (SeatBooked(name) == true) {  
                        seat30.setIcon(seat_taken);   
                        seat30.setSize(50, 50);
                    } else {
                        seat30.setIcon(seat);   
                        seat30.setSize(50, 50);   
                        seat30.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat31 = new JLabel();
                try {
                    String name = "seat31";
                    if (SeatBooked(name) == true) {  
                        seat31.setIcon(seat_taken);   
                        seat31.setSize(50, 50);
                    } else {
                        seat31.setIcon(seat);   
                        seat31.setSize(50, 50);   
                        seat31.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat32 = new JLabel();
                try {
                    String name = "seat32";
                    if (SeatBooked(name) == true) {  
                        seat32.setIcon(seat_taken);   
                        seat32.setSize(50, 50);
                    } else {
                        seat32.setIcon(seat);   
                        seat32.setSize(50, 50);   
                        seat32.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat33 = new JLabel();
                try {
                    String name = "seat33";
                    if (SeatBooked(name) == true) {  
                        seat33.setIcon(seat_taken);   
                        seat33.setSize(50, 50);
                    } else {
                        seat33.setIcon(seat);   
                        seat33.setSize(50, 50);   
                        seat33.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat34 = new JLabel();
                try {
                    String name = "seat34";
                    if (SeatBooked(name) == true) {  
                        seat34.setIcon(seat_taken);   
                        seat34.setSize(50, 50);
                    } else {
                        seat34.setIcon(seat);   
                        seat34.setSize(50, 50);   
                        seat34.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat35 = new JLabel();
                try {
                    String name = "seat35";
                    if (SeatBooked(name) == true) {  
                        seat35.setIcon(seat_taken);   
                        seat35.setSize(50, 50);
                    } else {
                        seat35.setIcon(seat);   
                        seat35.setSize(50, 50);   
                        seat35.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat36 = new JLabel();
                try {
                    String name = "seat36";
                    if (SeatBooked(name) == true) {  
                        seat36.setIcon(seat_taken);   
                        seat36.setSize(50, 50);
                    } else {
                        seat36.setIcon(seat);   
                        seat36.setSize(50, 50);   
                        seat36.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat37 = new JLabel();
                try {
                    String name = "seat37";
                    if (SeatBooked(name) == true) {  
                        seat37.setIcon(seat_taken);   
                        seat37.setSize(50, 50);
                    } else {
                        seat37.setIcon(seat);   
                        seat37.setSize(50, 50);   
                        seat37.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat38 = new JLabel();
                try {
                    String name = "seat38";
                    if (SeatBooked(name) == true) {  
                        seat38.setIcon(seat_taken);   
                        seat38.setSize(50, 50);
                    } else {
                        seat38.setIcon(seat);   
                        seat38.setSize(50, 50);   
                        seat38.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat39 = new JLabel();
                try {
                    String name = "seat39";
                    if (SeatBooked(name) == true) {  
                        seat39.setIcon(seat_taken);   
                        seat39.setSize(50, 50);
                    } else {
                        seat39.setIcon(seat);   
                        seat39.setSize(50, 50);   
                        seat39.addMouseListener(this);   
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat40 = new JLabel();
                try {
                    String name = "seat40";
                    if (SeatBooked(name) == true) {  
                        seat40.setIcon(seat_taken);
                        seat40.setSize(50, 50);
                    } else {
                        seat40.setIcon(seat);
                        seat40.setSize(50, 50);
                        seat40.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat41 = new JLabel();
                try {
                    String name = "seat41";
                    if (SeatBooked(name) == true) {  
                        seat41.setIcon(seat_taken);
                        seat41.setSize(50, 50);
                    } else {
                        seat41.setIcon(seat);
                        seat41.setSize(50, 50);
                        seat41.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat42 = new JLabel();
                try {
                    String name = "seat42";
                    if (SeatBooked(name) == true) {  
                        seat42.setIcon(seat_taken);
                        seat42.setSize(50, 50);
                    } else {
                        seat42.setIcon(seat);
                        seat42.setSize(50, 50);
                        seat42.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat43 = new JLabel();
                try {
                    String name = "seat43";
                    if (SeatBooked(name) == true) {  
                        seat43.setIcon(seat_taken);
                        seat43.setSize(50, 50);
                    } else {
                        seat43.setIcon(seat);
                        seat43.setSize(50, 50);
                        seat43.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat44 = new JLabel();
                try {
                    String name = "seat44";
                    if (SeatBooked(name) == true) {  
                        seat44.setIcon(seat_taken);
                        seat44.setSize(50, 50);
                    } else {
                        seat44.setIcon(seat);
                        seat44.setSize(50, 50);
                        seat44.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat45 = new JLabel();
                try {
                    String name = "seat45";
                    if (SeatBooked(name) == true) {  
                        seat45.setIcon(seat_taken);
                        seat45.setSize(50, 50);
                    } else {
                        seat45.setIcon(seat);
                        seat45.setSize(50, 50);
                        seat45.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat46 = new JLabel();
                try {
                    String name = "seat46";
                    if (SeatBooked(name) == true) {  
                        seat46.setIcon(seat_taken);
                        seat46.setSize(50, 50);
                    } else {
                        seat46.setIcon(seat);
                        seat46.setSize(50, 50);
                        seat46.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat47 = new JLabel();
                try {
                    String name = "seat47";
                    if (SeatBooked(name) == true) {  
                        seat47.setIcon(seat_taken);
                        seat47.setSize(50, 50);
                    } else {
                        seat47.setIcon(seat);
                        seat47.setSize(50, 50);
                        seat47.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                seat48 = new JLabel();
                try {
                    String name = "seat48";
                    if (SeatBooked(name) == true) {  
                        seat48.setIcon(seat_taken);
                        seat48.setSize(50, 50);
                    } else {
                        seat48.setIcon(seat);
                        seat48.setSize(50, 50);
                        seat48.addMouseListener(this);
                           
                    }
                } catch (IOException e) {
                    return;
                }

                //WORKING ON SECTION 1

                section1.setBounds(0, 150, 200, 700); //Setting exact position and dimensions of section in JFrame
                section1.setLayout(new GridLayout(8, 2, 2, 3)); /*A GridLayout has rows and columns
                                                                                   which can store seats */
                section1.setBackground(Color.DARK_GRAY);
                section1.add(seat1); //Adding seats to section
                section1.add(seat2);
                section1.add(seat3);
                section1.add(seat4);
                section1.add(seat5);
                section1.add(seat6);
                section1.add(seat7);
                section1.add(seat8);
                section1.add(seat9);
                section1.add(seat10);
                section1.add(seat11);
                section1.add(seat12);
                section1.add(seat13);
                section1.add(seat14);
                section1.add(seat15);
                section1.add(seat16);

                section1.setPreferredSize(new Dimension(200, 700));

                //SECTION 1 ENDS HERE
                //WORKING ON SECTION 2 BEGINS HERE

                section2.setBounds(500, 450, 600, 400); //Setting exact position and dimensions of section in JFrame
                section2.setLayout(new GridLayout(4, 4, 3, 2)); /*A GridLayout has rows and columns
                                                                                   which can store seats */
                section2.setBackground(Color.DARK_GRAY);
                section2.add(seat17); //Adding seats to section
                section2.add(seat18);
                section2.add(seat19);
                section2.add(seat20);
                section2.add(seat21);
                section2.add(seat22);
                section2.add(seat23);
                section2.add(seat24);
                section2.add(seat25);
                section2.add(seat26);
                section2.add(seat27);
                section2.add(seat28);
                section2.add(seat29);
                section2.add(seat30);
                section2.add(seat31);
                section2.add(seat32);

                section2.setPreferredSize(new Dimension(600, 400));

                //SECTION 2 ENDS HERE
                //WORKING ON SECTION 3 BEGINS HERE

                section3.setBounds(1350, 150, 200, 700); //Setting exact position and dimensions of section in JFrame
                section3.setLayout(new GridLayout(8, 2, 2, 3)); /*A GridLayout has rows and columns
                                                                                   which can store seats */
                section3.setBackground(Color.DARK_GRAY);
                section3.add(seat33); //Adding a particular seat
                section3.add(seat34);
                section3.add(seat35);
                section3.add(seat36);
                section3.add(seat37);
                section3.add(seat38);
                section3.add(seat39);
                section3.add(seat40);
                section3.add(seat41);
                section3.add(seat42);
                section3.add(seat43);
                section3.add(seat44);
                section3.add(seat45);
                section3.add(seat46);
                section3.add(seat47);
                section3.add(seat48);

                section3.setPreferredSize(new Dimension(200, 700));

                //SECTION 3 ENDS HERE
                //Setting up JButton

                pay.setBounds(700, 100, 100, 40);
                pay.setText("Payment");
                pay.addActionListener(this);

                //SETTING UP JFrame

                frame.getContentPane().setBackground(new Color(0, 0, 0)); //Adding a background colour
                frame.setTitle("Movie Ticket Reservation"); //Putting a title
                frame.setLayout(null); //Setting layout
                frame.add(pay); //Adding JButton pay to the frame
                frame.add(section1); //Adding section1, which contains seats 1-16
                frame.add(section2); //Adding section2, which contains seats 17-32
                frame.add(section3); //Adding section3, which contains seats 33-48
                frame.setSize(500, 400); //To set size
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This means frame will close on clicking upper right cross
                frame.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for coming.", "THANK YOU", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void mouseClicked(MouseEvent e) { //Automatically imported method that comes with MouseListener interface
        try {
            FileWriter seat_reserved = new FileWriter("Booked.txt", true);
            BufferedWriter seat_reserver=new BufferedWriter(seat_reserved);
            PrintWriter store_seat=new PrintWriter(seat_reserver);
            seats++;
            if (e.getSource() == seat1) { //Code which works when a particular seat is selected
                seat1.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat1");
            } else if (e.getSource() == seat2) {
                seat2.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat2");
            } else if (e.getSource() == seat3) {
                seat3.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat3");
            } else if (e.getSource() == seat4) {
                seat4.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat4");
            } else if (e.getSource() == seat5) {
                seat5.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat5");
            } else if (e.getSource() == seat6) {
                seat6.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat6");
            } else if (e.getSource() == seat7) {
                seat7.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat7");
            } else if (e.getSource() == seat8) {
                seat8.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat8");
            } else if (e.getSource() == seat9) {
                seat9.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat9");
            } else if (e.getSource() == seat10) {
                seat10.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat10");
            } else if (e.getSource() == seat11) {
                seat11.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat11");
            } else if (e.getSource() == seat12) {
                seat12.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat12");
            } else if (e.getSource() == seat13) {
                seat13.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat13");
            } else if (e.getSource() == seat14) {
                seat14.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat14");
            } else if (e.getSource() == seat15) {
                seat15.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat15");
            } else if (e.getSource() == seat16) {
                seat16.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat16");
            } else if (e.getSource() == seat17) {
                seat17.setIcon(selectedseat);
                cost += 400; //Seats 17-32 lie in the luxury section, so a higher cost
                store_seat.println("seat17");
            } else if (e.getSource() == seat18) {
                seat18.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat18");
            } else if (e.getSource() == seat19) {
                seat19.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat19");
            } else if (e.getSource() == seat20) {
                seat20.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat20");
            } else if (e.getSource() == seat21) {
                seat21.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat21");
            } else if (e.getSource() == seat22) {
                seat22.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat22");
            } else if (e.getSource() == seat23) {
                seat23.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat23");
            } else if (e.getSource() == seat24) {
                seat24.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat24");
            } else if (e.getSource() == seat25) {
                seat25.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat25");
            } else if (e.getSource() == seat26) {
                seat26.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat26");
            } else if (e.getSource() == seat27) {
                seat27.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat27");
            } else if (e.getSource() == seat28) {
                seat28.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat28");
            } else if (e.getSource() == seat29) {
                seat29.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat29");
            } else if (e.getSource() == seat30) {
                seat30.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat30");
            } else if (e.getSource() == seat31) {
                seat31.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat31");
            } else if (e.getSource() == seat32) {
                seat32.setIcon(selectedseat);
                cost += 400;
                store_seat.println("seat32");
            } else if (e.getSource() == seat33) {
                seat33.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat33");
            } else if (e.getSource() == seat34) {
                seat34.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat34");
            } else if (e.getSource() == seat35) {
                seat35.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat35");
            } else if (e.getSource() == seat36) {
                seat36.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat36");
            } else if (e.getSource() == seat37) {
                seat37.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat37");
            } else if (e.getSource() == seat38) {
                seat38.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat38");
            } else if (e.getSource() == seat39) {
                seat39.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat39");
            } else if (e.getSource() == seat40) {
                seat40.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat40");
            } else if (e.getSource() == seat41) {
                seat41.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat41");
            } else if (e.getSource() == seat42) {
                seat42.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat42");
            } else if (e.getSource() == seat43) {
                seat43.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat43");
            } else if (e.getSource() == seat44) {
                seat44.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat44");
            } else if (e.getSource() == seat45) {
                seat45.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat45");
            } else if (e.getSource() == seat46) {
                seat46.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat46");
            } else if (e.getSource() == seat47) {
                seat47.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat47");
            } else if (e.getSource() == seat48) {
                seat48.setIcon(selectedseat);
                cost += 200;
                store_seat.println("seat48");
            }
            store_seat.close();
            seat_reserver.close();
            seat_reserved.close();
        } catch(Exception exception){
            return;
        }
    }

    //Unneeded methods of the MouseListener interface

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void actionPerformed(ActionEvent e) { //An automatically imported method of the ActionListener interface
            if (e.getSource() == pay) { //getSource() senses the JButton being clicked
                frame.dispose(); //JFrame will dissapear
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to pay ₹" + cost, "Confirm payment", JOptionPane.YES_NO_OPTION); //A variable to confirm cost
                if (choice == 0) {
                    String[] responses = {"Cash on spot", "Credit/Debit card"}; //An array containing various payment methods
                    int payment_choice = JOptionPane.showOptionDialog(null, "Please select method of payment.", "Payment Window", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, responses, 0); //Storing payment choice
                    if (payment_choice == 0) { //0 is the first button(leftmost) that is present in the option-dialogue box. In this case, "Cash on spot"
                        JOptionPane.showMessageDialog(null, "Thankyou for choosing us as your booking partner.", "You are done", JOptionPane.INFORMATION_MESSAGE, green_tick);
                        try { //try-catch block to avoid exception
                            data_storing = new FileWriter("Ticket_Record.txt", true);//Initializing FileWriter
                            bufferedWriter = new BufferedWriter(data_storing); //Initializing BufferedWriter
                            printWriter = new PrintWriter(bufferedWriter); //Initializing PrintWriter
                            printWriter.println(email + " - " + cost + " - "+seats); //Storing email and cost in file
                            printWriter.close();
                            bufferedWriter.close();
                            data_storing.close();//Closing printWriter,bufferedWriter,fw
                        } catch (IOException ex) {
                            return;
                        }
                    } else if (payment_choice == 1) { //If "Credit/Debit card" is selected
                        String card_no = JOptionPane.showInputDialog("Please enter card number"); //Showing dialogue box and storing card number
                        boolean check = true;
                        for (int i = 0; i < card_no.length(); i++) { //A loop to see if credit card number is valid or not
                            if (Character.isDigit(card_no.charAt(i)) == false) {
                                JOptionPane.showMessageDialog(null, "Invalid card number. Booking process terminated.", null, JOptionPane.ERROR_MESSAGE);
                                check = false;
                                break;
                            }
                        }
                        if (check == true) { //If credit card number is valid, the body of this statement will be executed
                            String cvv = JOptionPane.showInputDialog("Please enter CVV:"); //Asking user to enter cvv and storing it temporarily
                            boolean check2 = true;
                            for (int i = 0; i < cvv.length(); i++) {
                                if (Character.isDigit(cvv.charAt(i)) == false) {
                                    JOptionPane.showMessageDialog(null, "Invalid cvv. Booking process terminated.", null, JOptionPane.ERROR_MESSAGE);
                                    check2 = false;
                                    break;
                                }
                            }
                            if (check2 == true) { //If cvv is valid, this if statement will be executed
                                JOptionPane.showMessageDialog(null, "You are done. Thank you for choosing us as your booking prtner.", "THANK YOU!", JOptionPane.INFORMATION_MESSAGE, green_tick); //Final dialogue box to confirm that payment has been done
                                try { //A try-catch block to avoid exceptions
                                    data_storing = new FileWriter("Ticket_Record.txt", true); //Initializing FileWriter
                                    bufferedWriter = new BufferedWriter(data_storing); //Initializing BufferedWriter
                                    printWriter = new PrintWriter(bufferedWriter); //Initiailizing PrintWriter
                                    printWriter.println(email + " - " + cost + " - " + seats); //Storing email, cost and seats in a file
                                    printWriter.close();
                                    bufferedWriter.close();
                                    data_storing.close();//Closing printWriter, bufferedWriter and data_storing
                                } catch (IOException ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }
                }
            }
    }

    boolean SeatBooked(String seat_name) throws IOException{ //A function to check if a seat has been previously booked or not
        FileReader fr=new FileReader("Booked.txt");
        BufferedReader br=new BufferedReader(fr);
        boolean present =false;
        String temp="";
        while((temp = br.readLine()) != null){
            if(temp.equalsIgnoreCase(seat_name)){ // If seat is present in file or not
                 present = true;
                 break;
            }
        }
        br.close();
        fr.close();
        return present;
    }
}

