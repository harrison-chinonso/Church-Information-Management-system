 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OkotaArea;

/**
 *
 * @author chinex
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JPanel;



public class SubPanelUpdater extends javax.swing.JPanel {
    
    private  JPanel panel;
   //private Membership mem1 ;
    MVP mvp;
    Membership mem;
    NewBeliver NB;
    Workers Wk;
    Cell cell;
    AreaReport ap;
    Discipleship dis;
    DBOperations db;
    public SubPanelUpdater() {
        try {
            initComponents();
            contactemails.createNewFile();
            contactnumbers.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(SubPanelUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    } 
    public SubPanelUpdater(DBOperations db)
    {
    this.db= db;
    }
    public SubPanelUpdater(Membership mem)
    {
    this.mem= mem;
    }
    public SubPanelUpdater( Workers Wk)
    {
    this.Wk= Wk;
    }
    public SubPanelUpdater(MVP mvp) 
    {
        this.mvp= mvp;
    }
    public SubPanelUpdater(NewBeliver NB)
    {
     this.NB = NB;  
    }
    public SubPanelUpdater(Discipleship dis) 
    {
     this.dis = dis;      
    }
    
public void NewupdatePanel (JPanel currentPanel)
    {
        panel = mem.getBackgroundPanel();
        GroupLayout l = (GroupLayout) panel.getLayout();   
        l.setHorizontalGroup(
            l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        l.setVerticalGroup(
            l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
   } 
public String Timestamper ()
{   String Timestamps = null;String Month = null;String timeString= null; Calendar cal = new GregorianCalendar();
    int ch = 10; int hr =  cal.get(Calendar.HOUR_OF_DAY); int min =  cal.get(Calendar.MINUTE);int year = cal.get(Calendar.YEAR);
    int sec =  cal.get(Calendar.SECOND); int day =  cal.get(Calendar.DAY_OF_MONTH); int month = cal.get(Calendar.MONTH);

            if (ch > hr && ch < min && ch < sec )
            {
                timeString = "0" + hr + ":" + min + ":" + sec ;
            }
            else if (ch > min && ch < hr & ch < sec )
            {
                timeString = hr + ":" + "0" + min + ":" + sec ;
            }
            else if (ch > sec && ch < min && ch < hr )
            {
                timeString = hr + ":" + min + ":" + "0" + sec;
            }
            else if (ch > hr && ch > min && ch < sec )
            {
                timeString = "0" + hr  + ":" + "0" + min + ":" + sec ;
            }
            else if (ch > hr && ch > sec && ch < min)
            {
                timeString = "0" + hr + ":" + min + ":" + "0" + sec ;
            }
            else if (ch > min && ch > sec && ch < hr)
            {
                timeString = hr + ":" + "0" + min +":" + "0" + sec;
            }
            else if (ch > min && ch > sec && ch > hr)
            {
                timeString = "0" + hr +  ":" + "0" + min +":" + "0" + sec ;
            }
            else
            {
                timeString = hr + ":" + min + ":" + sec ;
            }
                    switch (month) {
                        case 0:
                            Month="January";
                            break;
                        case 1:
                            Month="February";
                            break;
                        case 2:
                            Month="March";
                            break;
                        case 3:
                            Month="April";
                            break;
                        case 4:
                            Month="May";
                            break;
                        case 5:
                            Month="June";
                            break;
                        case 6:
                            Month="July";
                            break;
                        case 7:
                            Month="August";
                            break;
                        case 8:
                            Month="September";
                            break;
                        case 9:
                            Month="October";
                            break;
                        case 10:
                            Month="November";
                            break;
                        case 11:
                            Month="December";
                            break;
                        default:
                    }
                    String date =  day + "/" + Month + "/" + year;
                    Timestamps = timeString + " " + date;
 return Timestamps;
}


File contactnumbers = new File ("contactnumbers.txt");
File contactemails = new File ("contactemails.txt");
FileWriter fw = null;FileWriter fm = null; 
    
public void getemails (String contacts)
{ 
    try {
        fm = new FileWriter(contactemails.getAbsoluteFile(), true);
        try (BufferedWriter bm = new BufferedWriter(fm)) {
             bm.write(contacts);
             bm.newLine();
        }
    } catch (IOException ex) { 
        Logger.getLogger(SubPanelUpdater.class.getName()).log(Level.SEVERE, null, ex);System.out.println(ex);
    } finally {
    }
}
public void getNumber (String contact)
{
    try {
        fw = new FileWriter(contactnumbers.getAbsoluteFile(), true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
             bw.write(contact);
             bw.newLine();
        }
    } catch (IOException ex) {
        Logger.getLogger(SubPanelUpdater.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
    }
}

 private void initComponents() 
 {
        
 }
}  