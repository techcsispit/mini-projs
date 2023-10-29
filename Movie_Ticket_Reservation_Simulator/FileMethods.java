import javax.swing.*;
import java.io.*;

class FileMethods {

    void search(String str) throws IOException {
        FileReader fr = new FileReader("Ticket_Record.txt");
        BufferedReader br = new BufferedReader(fr);
        String s = ""; //To read each line
        boolean flag = false; //To check if email present or not
        String line = ""; //To store the correct line
        while ((s = br.readLine()) != null) {
            String email = s.substring(0, s.indexOf('-') - 1); //Extracting only email part
            if (email.equalsIgnoreCase(str) == true) {
                flag = true;
                line = s; //Storing email in variable line
                break;
            }
        }
        if (flag == true) {
            //Extracting only cost part
            String cost = line.substring(line.indexOf('-') + 2, line.lastIndexOf('-') - 1);
            //Showing cost to user
            JOptionPane.showMessageDialog(null, "The cost of your booking is " + cost, "PAYMENT CONFIRMATION", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Email not found. Please try booking again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        br.close();
        fr.close();
    }

    void read() throws IOException { //Method to calculate total number of booked seats in theatre
        FileReader fr = new FileReader("Booked.txt");
        BufferedReader br = new BufferedReader(fr);
        int no_of_booked_seats = 0;  //To store reserved seats in hall
        String s = "";
        while ((s = br.readLine()) != null) {
            no_of_booked_seats++;
        }
        br.close();
        fr.close();
        JOptionPane.showMessageDialog(null, "The total number of booked seats are " + no_of_booked_seats + "/48", "", JOptionPane.INFORMATION_MESSAGE);
    }

    void delete(String str) throws IOException { //A method to delete email and seats record
        FileReader fr = new FileReader("Ticket_Record.txt");
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        int totalseats = 0;
        String email = "";
        boolean flag = false;
        while ((s = br.readLine()) != null) { //To check if email present
            email = s.substring(0, s.indexOf(' '));
            totalseats += Integer.parseInt(s.substring(s.lastIndexOf('-') + 2)); //To calculate all reserved seats all the way till email
            if (email.equalsIgnoreCase(str)) {
                flag = true;
                break;
            }
        }
        br.close();
        fr.close();
        fr = new FileReader("Ticket_Record.txt");
        br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("emailtemp.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        s = "";
        int seats_to_be_removed = 0;
        while ((s = br.readLine()) != null) {
            String mail = s.substring(0, s.indexOf(' ')); //To store every email
            if (mail.equalsIgnoreCase(email) == false) {
                pw.println(s); //If mail and entered email are not same, the mail will be sent to the other file
            } else if (mail.equalsIgnoreCase(email) == true) {
                //To store exact amount of seats booked by entered email
                seats_to_be_removed = Integer.parseInt(s.substring(s.lastIndexOf('-') + 2));
            }
        }
        br.close();
        fr.close();
        pw.close();
        bw.close();
        fw.close();
        fr = new FileReader("emailtemp.txt");
        br = new BufferedReader(fr);
        fw = new FileWriter("Ticket_Record.txt");
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        s = "";
        while ((s = br.readLine()) != null) { //Printed all entries back to original file except the one to be deleted
            pw.println(s);
        }
        br.close();
        fr.close();
        pw.close();
        bw.close();
        fw.close();
        fr = new FileReader("Booked.txt");
        br = new BufferedReader(fr);
        fw = new FileWriter("seats_temp.txt");
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        s = "";
        int check = 0;
        while ((s = br.readLine()) != null) { //Updating the seats file
            if (check < (totalseats - seats_to_be_removed)) {
                pw.println(s); //Storing all seats before the ones to be removed
                check++;
            } else if (check > (totalseats - seats_to_be_removed)) {
                check++;
                if ((check - (totalseats - seats_to_be_removed) <= seats_to_be_removed)) {
                    continue; //Removing the seats selected by email user
                } else {
                    pw.println(s); //Storing all the other seats not selected by email user
                }
            } else {
                check++;
            }
        }
        br.close();
        fr.close();
        pw.close();
        bw.close();
        fw.close();
        fr = new FileReader("seats_temp.txt");
        br = new BufferedReader(fr);
        fw = new FileWriter("Booked.txt");
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        s = "";
        while ((s = br.readLine()) != null) {
            pw.println(s); //Printing the correct number of seats back to original file
        }
        br.close();
        fr.close();
        pw.close();
        bw.close();
        fw.close();
        if (flag == false) {
            JOptionPane.showMessageDialog(null, "Email not found!", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    void modify(String email) throws IOException{
        delete(email); //Deleting the email and no.of seats associated with it
        new Reservation(); //Prompting user to re-reserve tickets
    }
}
