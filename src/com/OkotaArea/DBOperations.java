/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OkotaArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author chinex
 */
public class DBOperations {
    private Connection con;
    private PreparedStatement pt;
    private PreparedStatement st;
    private ResultSet rs;
    private String userDb = "root";
    private String passwordDb = "";
    private String urlDb = "jdbc:mysql://localhost:3306/dcokota_db";
    String a = "NULL";char b = ' ';
    SubPanelUpdater sub = new SubPanelUpdater(this);
     public DBOperations()
    {
        try {
            con = DriverManager.getConnection(urlDb, userDb, passwordDb);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
    } }
    
    public Map login(String un, String pwd)
    {
        try {
            String command = "SELECT * FROM user_tb WHERE username=? AND password = ?";
            pt = con.prepareStatement(command);
            pt.setString(1, un);
            pt.setString(2, pwd);
            
            rs = pt.executeQuery();
            
            if(rs.next())
            {
                Map <String, String> userInfo = new HashMap<>();
                userInfo.put("firstName", rs.getString("firstname"));
                userInfo.put("lastName", rs.getString("lastname"));
                userInfo.put("username", rs.getString("username"));
                userInfo.put("Role", rs.getString("Role"));
                return userInfo;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void NewMembersave (String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String basic, String maturity, String enc, String dli)
            
    {   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date, dca_basic, maturity, enc, dli) VALUES (?, ?,?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, basic);
            pt.setString(12, maturity);
            pt.setString(13, enc);
            pt.setString(14, dli);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

   public void NewMembersave0 (String fname,String lname, String ph, String mail,String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String basic, String maturity, String enc){   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date, dca_basic, maturity, enc) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, basic);
            pt.setString(12, maturity);
            pt.setString(13, enc);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }     }

   public void NewMembersave1 (String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String basic, String maturity) {   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date, dca_basic, maturity) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, basic);
            pt.setString(12, maturity);
            
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       }

   public void NewMembersave2(String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String basic){   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date, dca_basic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, basic);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }      }

   public void NewMembersave3(String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp){   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
           pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
           
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       }
public HashMap<String, String[]> getAllMemberList() 
{
         try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null; 
     }

public HashMap<String, String[]> getamemberphRecord(String PhoneNo) 
     {
         try {
            
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE phone_no = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, PhoneNo);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                 
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
     }

   public void NewMvpsave(String fname,String lname, String ph,String mail, String addr, String cell,String gen, String mStatus, String dob, String mvp) {
           try {
            String command = "INSERT INTO mvp_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
           
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }         
   }
   
   public void NewMvpsave1(String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String second){
         try {
            String command = "INSERT INTO mvp_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date,2nd_date) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
           pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11,second);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }         
   }
 public void NewMvpsave2(String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String second,String third ){
     try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date,2nd_date,3rd_date) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11,second);
            pt.setString(12,third);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }         
 }
    public HashMap<String, String[]> getAnMVPRecordfname(String text) {
       try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM mvp_tb WHERE first_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, text);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
    }
    public HashMap<String, String[]> getAnMVPRecordlname(String text) {
       try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM mvp_tb WHERE last_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, text);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                 
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
    }
public HashMap<String, String[]> getAnMVPRecordnum(String text) {
       try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM mvp_tb WHERE phone_no = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, text);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
}

    public void NewBelieversave(String fname,String lname, String ph,String mail, String addr, String cell, 
            String gen, String mStatus, String savdate) {
        try {
            String command = "INSERT INTO new_believer_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status,salvation_date ) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, savdate);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }

   public HashMap<String, String[]> getAllMvpList() {
       try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM mvp_tb";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  }

public HashMap<String, String[]> getAllNewBelieverList() {
  try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM new_believer_tb";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("salvation_date");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
}

public HashMap<String, String[]> getANewBelieverRecordfname(String name) {
    try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM new_believer_tb WHERE first_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, name);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                  String dataArray[] = new String [12];               
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("salvation_date");
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;     
    }

public HashMap<String, String[]> getANewBelieverRecordlname(String name) {
    try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM new_believer_tb WHERE last_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, name);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                  String dataArray[] = new String [12];               
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("salvation_date");
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;     
    }

public HashMap<String, String[]> getANewBelieverRecordnum(String num) {
     try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM new_believer_tb WHERE phone_no = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, num);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("salvation_date");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;     
}

public void NewWorkersave(String fname,String lname, String ph, String cell, String dept) {
      try {
            String query = "UPDATE membership_tb SET dept = ? WHERE first_name = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, dept);
            st.setString(2, fname);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       }

public HashMap<String, String[]> getAworkerfname(String name) {
  try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE first_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, name);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [13];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dept");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;            
}

public HashMap<String, String[]> getAworkerdept(String dept) {
  try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE dept = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, dept);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [13];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dept");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;                     
}

public HashMap<String, String[]> getAworkerlname(String name) {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE last_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, name);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [13];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dept");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;                
    
}

public HashMap<String, String[]> getAllWorkersList() {
   try {
       
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE dept != ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [13];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dept");
                 
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);                
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;          }

 public HashMap<String, String[]> getCellMemberList(String name) {
        try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE cell_jurisdiction = ?";
             pt = con.prepareStatement(command);
             pt.setString(1, name);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [17];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null; }
 
public HashMap<String, String[]> getallCellreport() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM cell_report";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [19];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date_of_report");
                 dataArray[2] = rs.getString("name_of_cell");
                 dataArray[3] = rs.getString("name_of_cellleader");
                 dataArray[4] = rs.getString("target");
                 dataArray[5] = rs.getString("cell_population");
                 dataArray[6] = rs.getString("start_time");
                 dataArray[7] = rs.getString("end_time");
                 dataArray[8] = rs.getString("church_attend");
                 dataArray[9] = rs.getString("cell_attend");
                 dataArray[10] = rs.getString("church_mvp");
                 dataArray[11] = rs.getString("cell_mvp");
                 dataArray[12] = rs.getString("2nd_timer");
                 dataArray[13] = rs.getString("offering");
                 dataArray[14] = rs.getString("dca_basic");
                 dataArray[15] = rs.getString("maturity");
                 dataArray[16] = rs.getString("enc");
                 dataArray[17] = rs.getString("dli");
                 dataArray[18] = rs.getString("visits");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
  return null;        
}

public HashMap<String, String[]> getoneCellreport(String report) {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM cell_report WHERE date_of_report = ?";
             pt = con.prepareStatement(command);
             pt.setString(1,report);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [19];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date_of_report");
                 dataArray[2] = rs.getString("name_of_cell");
                 dataArray[3] = rs.getString("name_of_cellleader");
                 dataArray[4] = rs.getString("target");
                 dataArray[5] = rs.getString("cell_population");
                 dataArray[6] = rs.getString("start_time");
                 dataArray[7] = rs.getString("end_time");
                 dataArray[8] = rs.getString("church_attend");
                 dataArray[9] = rs.getString("cell_attend");
                 dataArray[10] = rs.getString("church_mvp");
                 dataArray[11] = rs.getString("cell_mvp");
                 dataArray[12] = rs.getString("2nd_timer");
                 dataArray[13] = rs.getString("offering");
                 dataArray[14] = rs.getString("dca_basic");
                 dataArray[15] = rs.getString("maturity");
                 dataArray[16] = rs.getString("enc");
                 dataArray[17] = rs.getString("dli");
                 dataArray[18] = rs.getString("visits");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
 return null;        
}

public void NewCellReportSave(String datereport, String CeTarget, String CePopulation, String CellStart, String CellEnd,
                              String Cellattend, String SundayAttend, String CellLeader, String CellMvp, String ChurchMVP, 
                              String CellOffering, String Dcabasic, String dcaMat, 
                              String Enc, String DLI, String Visit, String CellName, String SecTimer) 
{
  try {
    String command="INSERT INTO cell_report "
            + "(date_of_report,name_of_cell,name_of_cellleader,target,cell_population,start_time,end_time,church_attend,cell_attend,church_mvp,cell_mvp,\n" +
              "2nd_timer,offering,dca_basic,maturity,enc,dli,visits) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, datereport);
            pt.setString(2, CellName);
            pt.setString(3, CellLeader);
            pt.setString(4, CeTarget);
            pt.setString(5, CePopulation);
            pt.setString(6, CellStart);
            pt.setString(7, CellEnd);
            pt.setString(8, SundayAttend);
            pt.setString(9, Cellattend);
            pt.setString(10, ChurchMVP);
            pt.setString(11,CellMvp);
            pt.setString(12,SecTimer);
            pt.setString(13,CellOffering);
            pt.setString(14,Dcabasic);
            pt.setString(15,dcaMat);
            pt.setString(16, Enc);
            pt.setString(17, DLI);
            pt.setString(18,Visit);
                    
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } }

public void NewAreaReportSave(String datereport, String Target, String Tmem, String TCell, String Pmvp, String Cellattend, String SundayAttend, 
        String NewCell,String call, String NMvp, String Cheld, String Outreach, String Dcabasic, String dcaMat, String Enc, String DLI, String Visit, String work, String SecTimer) {
           try {
    String command="INSERT INTO area_report_tb "
            + "(date_of_report,target,total_member,total_cell,total_held,new_cell,cell_attend,church_attend,pre_mvp,new_mvp,2nd_timer,\n" +
              "joined_work,outreach,dca_basic,maturity,enc,dli,visits,calls) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, datereport);
            pt.setString(2,  Target);
            pt.setString(3, Tmem);
            pt.setString(4, TCell);
            pt.setString(5, Cheld);
            pt.setString(6, NewCell);
            pt.setString(7, Cellattend);
            pt.setString(8, SundayAttend);
            pt.setString(9, Pmvp);
            pt.setString(10, NMvp);
            pt.setString(11,SecTimer);
            pt.setString(12,work);
            pt.setString(13,Outreach);
            pt.setString(14,Dcabasic);
            pt.setString(15,dcaMat);
            pt.setString(16, Enc);
            pt.setString(17, DLI);
            pt.setString(18,Visit);
            pt.setString(19,call);       
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } }

public HashMap<String, String[]> getallareareport() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM area_report_tb";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [20];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date_of_report");
                 dataArray[2] = rs.getString("target");
                 dataArray[3] = rs.getString("total_member");
                 dataArray[4] = rs.getString("total_cell");
                 dataArray[5] = rs.getString("total_held");
                 dataArray[6] = rs.getString("new_cell");
                 dataArray[7] = rs.getString("cell_attend");
                 dataArray[8] = rs.getString("church_attend");
                 dataArray[9] = rs.getString("pre_mvp");
                 dataArray[10] = rs.getString("new_mvp");
                 dataArray[11] = rs.getString("2nd_timer");
                 dataArray[12] = rs.getString("joined_work");
                 dataArray[13] = rs.getString("outreach");
                 dataArray[14] = rs.getString("dca_basic");
                 dataArray[15] = rs.getString("maturity");
                 dataArray[16] = rs.getString("enc");
                 dataArray[17] = rs.getString("dli");
                 dataArray[18] = rs.getString("visits");
                 dataArray[19] = rs.getString("calls");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
 return null;                
}

public HashMap<String, String[]> getoneareareport(String report) {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM area_report_tb WHERE date_of_report = ?";
             pt = con.prepareStatement(command);
             pt.setString(1,report);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [20];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date_of_report");
                 dataArray[2] = rs.getString("target");
                 dataArray[3] = rs.getString("total_member");
                 dataArray[4] = rs.getString("total_cell");
                 dataArray[5] = rs.getString("total_held");
                 dataArray[6] = rs.getString("new_cell");
                 dataArray[7] = rs.getString("cell_attend");
                 dataArray[8] = rs.getString("church_attend");
                 dataArray[9] = rs.getString("pre_mvp");
                 dataArray[10] = rs.getString("new_mvp");
                 dataArray[11] = rs.getString("2nd_timer");
                 dataArray[12] = rs.getString("joined_work");
                 dataArray[13] = rs.getString("outreach");
                 dataArray[14] = rs.getString("dca_basic");
                 dataArray[15] = rs.getString("maturity");
                 dataArray[16] = rs.getString("enc");
                 dataArray[17] = rs.getString("dli");
                 dataArray[18] = rs.getString("visits");
                 dataArray[19] = rs.getString("calls");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
 return null;               
}

public void updatebasic(String date, String fname, String home, String lname, String ph) {
try {
            String query = "UPDATE membership_tb SET dca_basic = ? WHERE first_name = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, fname);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
}

public void updatedli(String date, String fname, String home, String lname, String ph) {
   try {
            String query = "UPDATE membership_tb SET dli = ? WHERE first_name = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, fname);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
}     

public void updateenc(String date, String fname, String home, String lname, String ph) {
 try {
            String query = "UPDATE membership_tb SET enc = ? WHERE first_name = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, fname);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }                  
}

public void updatemat(String date, String fname, String home, String lname, String ph) {
 try {
            String query = "UPDATE membership_tb SET maturity = ? WHERE first_name = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, fname);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
}       

public HashMap<String, String[]> getallattenddli() {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,dli FROM membership_tb WHERE dli != ? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("dli");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;         
}

public HashMap<String, String[]> getallattendenc() {
  try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,enc FROM membership_tb WHERE enc != ? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("enc");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }  
return null;         
}

public HashMap<String, String[]> getallattendmat() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,maturity FROM membership_tb WHERE maturity != ? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("maturity");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;        
}

public HashMap<String, String[]> getallattendbasic() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,dca_basic FROM membership_tb WHERE dca_basic != ? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                 dataArray[11] = rs.getString("dca_basic");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;              
}

public void NewMembersave4(String fname,String lname, String ph, String mail,String addr, String cell, 
            String gen, String mStatus, String dob, String mvp, 
            String enc) {   
        try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date, enc) VALUES ( ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
             pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, enc);
            
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       }

public Map<String, String> getMvpDetails(String id) 
{
    try {
            String command = "SELECT * FROM mvp_tb WHERE id =? ";
            pt = con.prepareStatement(command);
            pt.setString(1, id); 
            rs = pt.executeQuery();
            
            if(rs.next())
            {
                Map <String, String> mvpInfo = new HashMap<>();
                mvpInfo.put("firstName", rs.getString("first_name"));
                mvpInfo.put("lastName", rs.getString("last_name"));
                mvpInfo.put("1stdate", rs.getString("mvp_date"));
                mvpInfo.put("gender", rs.getString("gender"));
                mvpInfo.put("phone", rs.getString("phone_no"));
                mvpInfo.put("cell", rs.getString("cell_jurisdiction"));
                mvpInfo.put("address", rs.getString("address"));
                mvpInfo.put("2nddate", rs.getString("2nd_date"));
                mvpInfo.put("3rddate", rs.getString("3rd_date"));
                mvpInfo.put("id", rs.getString("id"));
                mvpInfo.put("marital", rs.getString("marital_status"));
                mvpInfo.put("dob", rs.getString("dob"));
                mvpInfo.put("note", rs.getString("note"));
                mvpInfo.put("mail", rs.getString("mail"));
                return mvpInfo;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
}
public HashMap<String, String[]> getmonthMvpDetails(String mon) 
{      String Time = sub.Timestamper();int y = Time.length();String Year = Time.substring(y-4);
    try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {   String jan = Year +" " + "January"; 
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+jan+"%'";}
             if("February".equals(mon))
             {   String feb = Year +" " + "February"; 
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+feb+"%'";}    
             if("March".equals(mon))
             {   String mar = Year +" " + "March"; 
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+mar+"%'";}    
             if("April".equals(mon))
             {   String apr = Year +" " + "April";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+apr+"%'";}    
             if("May".equals(mon))
             {   String may = Year +" " + "May";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+may+"%'";}    
             if("June".equals(mon))
             {   String jun = Year +" " + "June";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+jun+"%'";}    
             if("July".equals(mon))
             {   String jul = Year +" " + "July";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+jul+"%'";}    
             if("August".equals(mon))
             {   String aug = Year +" " + "August";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+aug+"%'";}    
             if("September".equals(mon))
             {   String sep = Year +" " + "September";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+sep+"%'";}    
             if("October".equals(mon))
             {   String oct = Year +" " + "October";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+oct+"%'";}    
             if("November".equals(mon))
             {   String nov = Year +" " + "November";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+nov+"%'";}    
             if("December".equals(mon))
             {   String dec = Year +" " + "December";
                 command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%"+dec+"%'";}    
             
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null; 
}
public void EditNewMvpsave(String fname,String lname,String ph,String mail,String addr, String cell,String second,String ted,String id,String gen,String mStatus,String dob,String mvp) {
         try {
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date,2nd_date) VALUES ( ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, second);
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String query = "UPDATE mvp_tb SET 2nd_date = ?,3rd_date=? WHERE id = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, second);
            st.setString(2, ted);
            st.setString(3, id);
            st.setString(4, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
    } 
    
public void EditNewMvpsave1(String fname, String lname, String ph,String mail, String addr, String cell, String second, String id) {
         try {
            String query = "UPDATE mvp_tb SET 2nd_date = ? WHERE id = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, second);
            st.setString(2, id);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
public void EditNewMvpsave2(String fname,String lname,String ph,String mail,String addr, String cell,String second,String ted,String id,String gen,String mStatus,String dob,String mvp) {
         try {
 
            String command = "INSERT INTO membership_tb (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date,2nd_date) VALUES ( ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fname);
            pt.setString(2, lname);
            pt.setString(3, ph);
            pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mStatus);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, second);
           
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String query = "UPDATE mvp_tb SET 3rd_date=? WHERE id = ? AND phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, ted);
            st.setString(2, id);
            st.setString(3, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "MVP SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }           
    } 

public void Expensave(String amt, String date, String desc, String loc, String amtW) {
  try {
            String command = "INSERT INTO admin_tb (date, expen, Amt_in_words, descri, location) VALUES (?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, date);
            pt.setString(2, amt);
            pt.setString(3, amtW);
            pt.setString(4, desc);
            pt.setString(5, loc);
  int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void incomesave(String amt, String date, String desc, String loc, String amtW) {
      try {
            String command = "INSERT INTO admin_tb (date,income,Amt_in_words,descri,location) VALUES (?, ?, ?, ?, ?)";
            pt = con.prepareStatement(command);
            pt.setString(1, date);
            pt.setString(2, amt);
            pt.setString(3, amtW);
            pt.setString(4, desc);
            pt.setString(5, loc);
     
            int row = pt.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
public void Expensave1(String amt, String date, String desc, String loc, String amtW,String id) {
  try {
            String query = "UPDATE admin_tb SET date = ?,expen = ? , Amt_in_words=?,descri=?,location=? WHERE id = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, amt);
            st.setString(3, amtW);
            st.setString(4, desc);
            st.setString(5, loc);
            st.setString(6, id);
  int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
}

public void incomesave1(String amt, String date, String desc, String loc, String amtW,String id) {
try {
            String query = "UPDATE admin_tb SET date = ?,income = ? , Amt_in_words=?,descri=?,location=? WHERE id = ? ";
            st = con.prepareStatement(query);
            st.setString(1, date);
            st.setString(2, amt);
            st.setString(3, amtW);
            st.setString(4, desc);
            st.setString(5, loc);
            st.setString(6, id);
  int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
public HashMap<String, String[]> viewoneExp(String date) {  
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM admin_tb WHERE date =? ";
             pt = con.prepareStatement(command);
             pt.setString(1,date);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [6];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date");
                 dataArray[2] = rs.getString("expen");
                 dataArray[3] = rs.getString("Amt_in_words");
                 dataArray[4] = rs.getString("descri");
                 dataArray[5] = rs.getString("location");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;              
}
public HashMap<String, String[]> viewoneincome(String date) {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM admin_tb WHERE date =? ";
             pt = con.prepareStatement(command);
             pt.setString(1,date);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [6];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date");
                 dataArray[2] = rs.getString("income");
                 dataArray[3] = rs.getString("Amt_in_words");
                 dataArray[4] = rs.getString("descri");
                 dataArray[5] = rs.getString("location");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;              

}

public HashMap<String, String[]> getamemberlnRecord(String text) {
 try {
            
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE last_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, text);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;         
}

public HashMap<String, String[]> getamemberfnRecord(String text) {
try {
            
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_tb WHERE first_name = ? ";            
             pt = con.prepareStatement(command);
             pt.setString(1, text);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;  
}
public void InsertmemNote(String note,String ph,String Prenote){   
try {
    
            
            String Time = sub.Timestamper(); 
            String notes = Time + "\n" + note + "\n" + Prenote;
            String query = "UPDATE membership_tb SET followup = ? WHERE phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, notes);
            st.setString(2, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } 
}
public void moveNdel(String fn, String ln, String gen, String pho,String mail, String cell, String addr, String sec, String mvp, String id, String mari, 
                     String dob, String dca, String mat, String enc, String dli, String dept, String note) {
try
{
String command = "INSERT INTO membership_arc (first_name,last_name,phone_no,mail, address, cell_jurisdiction, gender, marital_status, dob, mvp_date,"
               + "2nd_date, dca_basic, maturity, enc, dli,dept,followup) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?,?,?,?)";
            pt = con.prepareStatement(command);
            pt.setString(1, fn);
            pt.setString(2, ln);
            pt.setString(3, pho);
             pt.setString(4, mail);
            pt.setString(5, addr);
            pt.setString(6, cell);
            pt.setString(7, gen);
            pt.setString(8, mari);
            pt.setString(9, dob);
            pt.setString(10, mvp);
            pt.setString(11, sec);
            pt.setString(12, dca);
            pt.setString(13, mat);
            pt.setString(14, enc);
            pt.setString(15, dli);
            pt.setString(16, dept);
            pt.setString(17, note); 
  int row = pt.executeUpdate();     
      if(row>0)
            {
                try
            {
              String icommand = "DELETE FROM membership_tb WHERE phone_no = ?";
            pt = con.prepareStatement(icommand);
            pt.setString(1, pho);
            pt.executeUpdate();
            }
            catch (SQLException ex) {
                        Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
                    }
                JOptionPane.showMessageDialog(null, "MOVE SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "MOVE FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public Map<String, String> moveMemArc(String ph) {
try {
     String command = "SELECT * FROM membership_tb WHERE phone_no = ? ";            
     pt = con.prepareStatement(command);
     pt.setString(1, ph);
     rs = pt.executeQuery();
     if(rs.next())
            {
                Map <String, String> mvpInfo = new HashMap<>();
                mvpInfo.put("fn", rs.getString("first_name"));
                mvpInfo.put("ln", rs.getString("last_name"));
                mvpInfo.put("1st", rs.getString("mvp_date"));
                mvpInfo.put("gen", rs.getString("gender"));
                mvpInfo.put("ph", rs.getString("phone_no"));
                mvpInfo.put("cell", rs.getString("cell_jurisdiction"));
                mvpInfo.put("addr", rs.getString("address"));
                mvpInfo.put("2nd", rs.getString("2nd_date"));
                mvpInfo.put("id", rs.getString("id"));
                mvpInfo.put("mari", rs.getString("marital_status"));
                mvpInfo.put("dob", rs.getString("dob"));
                mvpInfo.put("dca", rs.getString("dca_basic"));
                mvpInfo.put("mat", rs.getString("maturity"));
                mvpInfo.put("enc", rs.getString("enc"));
                mvpInfo.put("dli", rs.getString("dli"));
                mvpInfo.put("dept", rs.getString("dept"));
                mvpInfo.put("fol", rs.getString("followup"));
                mvpInfo.put("mail", rs.getString("mail"));
                return mvpInfo;
            }
           }
     catch (SQLException ex) {
Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
} 
return null;
}
public void updatememdata(String nufn, String nuln, String nugen, String nuph,String upmail, String nuaddr, String numari,
                          String nucell, String nudob,String id) {
try {
            String query = "UPDATE membership_tb SET first_name =?,last_name=?,phone_no=?,address=?,cell_jurisdiction=?, gender=?, marital_status=?, dob=? WHERE id = ? ";
            st = con.prepareStatement(query);
            st.setString(1, nufn);
            st.setString(2, nuln);
            st.setString(3, nuph);
            st.setString(4, upmail);
            st.setString(5, nuaddr);
            st.setString(6, nucell);
            st.setString(7, nugen);
            st.setString(8, numari);
            st.setString(9, nudob);
            st.setString(10, id);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }       
}

public HashMap<String, String[]> birthmonth(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%January%'";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%February%'";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%March%'";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%April%'";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%May%'";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%June%'";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%July%'";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%August%'";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%September%'";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%October%'";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%November%'";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE dob LIKE '%December%'";}    
             
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
    return null;
}

public HashMap<String, String[]> getArchievedMemberList() {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM membership_arc";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [18];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("dca_basic");
                 dataArray[13] = rs.getString("maturity");
                 dataArray[14] = rs.getString("enc");
                 dataArray[15] = rs.getString("dli");
                 dataArray[16] = rs.getString("dept");
                 dataArray[17] = rs.getString("followup");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;         
}

public Map<String, String> getInExView(String word) {
try {
     String command = "SELECT * FROM admin_tb WHERE id = ? ";            
     pt = con.prepareStatement(command);
     pt.setString(1, word);
     rs = pt.executeQuery();
     if(rs.next())
            {
                Map <String, String> inExInfo = new HashMap<>();
                inExInfo.put("ex", rs.getString("expen"));
                inExInfo.put("in", rs.getString("income"));
                inExInfo.put("aw", rs.getString("Amt_in_words"));
                inExInfo.put("des", rs.getString("descri"));
                inExInfo.put("loc", rs.getString("location"));
                return inExInfo;
            }
           }
     catch (SQLException ex) {
Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
} 
return null;   
}

public HashMap<String, String[]> AllAreaEx() {
    try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM admin_tb WHERE expen !=? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [6];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date");
                 dataArray[2] = rs.getString("expen");
                 dataArray[3] = rs.getString("Amt_in_words");
                 dataArray[4] = rs.getString("descri");
                 dataArray[5] = rs.getString("location");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;      
}

public HashMap<String, String[]> AllAreaIn() {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT * FROM admin_tb WHERE income !=? ";
             pt = con.prepareStatement(command);
             pt.setString(1,a);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [6];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("date");
                 dataArray[2] = rs.getString("income");
                 dataArray[3] = rs.getString("Amt_in_words");
                 dataArray[4] = rs.getString("descri");
                 dataArray[5] = rs.getString("location");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;              
}

public HashMap<String, String[]> getmonthThirdTimerDetails(String mon) {
 try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%January%' AND 3rd_date != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%February%' AND 3rd_date != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%March%'  AND 3rd_date != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%April%'  AND 3rd_date != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%May%'  AND 3rd_date != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%June%'  AND 3rd_date != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%July%' AND 3rd_date != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%August%'  AND 3rd_date != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%September%'  AND 3rd_date != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%October%'  AND 3rd_date != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%November%'  AND 3rd_date != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%December%'  AND 3rd_date != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null; 
}

public HashMap<String, String[]> getmonthsecTimerDetails(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%January%' AND 2nd_date != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%February%' AND 2nd_date != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%March%'  AND 2nd_date != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%April%'  AND 2nd_date != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%May%'  AND 2nd_date != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%June%'  AND 2nd_date != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%July%' AND 2nd_date != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%August%'  AND 2nd_date != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%September%'  AND 2nd_date != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%October%'  AND 2nd_date != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%November%'  AND 2nd_date != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM mvp_tb WHERE mvp_date LIKE '%December%'  AND 2nd_date != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("note");
                
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;     
}

public void InsertmvpNote(String note, String ph, String Prenote) {
try {
            String Time = sub.Timestamper(); 
            String notes = Time + "\n" + note + "\n" + Prenote;
            String query = "UPDATE mvp_tb SET Note = ? WHERE phone_no = ? ";
            st = con.prepareStatement(query);
            st.setString(1, notes);
            st.setString(2, ph);
            int row = st.executeUpdate();
            if(row>0)
            {
                JOptionPane.showMessageDialog(null, "SUCCESS");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "FAILURE");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }         
}

public HashMap<String, String[]> getmonthWorkDetails(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%January%' AND dept != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%February%' AND dept != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%March%'  AND dept != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%April%'  AND dept != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%May%'  AND dept != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%June%'  AND dept != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%July%' AND dept != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%August%'  AND dept != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%September%'  AND dept != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%October%'  AND dept != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%November%'  AND dept != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%December%'  AND dept != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("followup");
                
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;             
}

public HashMap<String, String[]> getmonthDLIDetails(String mon) {
 try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%January%' AND dli != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%February%' AND dli != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%March%'  AND dli != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%April%'  AND dli != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%May%'  AND dli != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%June%'  AND dli != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%July%' AND dli != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%August%'  AND dli != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%September%'  AND dli != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%October%'  AND dli != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%November%'  AND dli != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%December%'  AND dli != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("followup");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;             
}

public HashMap<String, String[]> getmonthEncDetails(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%January%' AND enc != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%February%' AND enc != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%March%'  AND enc != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%April%'  AND enc != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%May%'  AND enc != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%June%'  AND enc != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%July%' AND enc != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%August%'  AND enc != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%September%'  AND enc != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%October%'  AND enc != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%November%'  AND enc != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%December%'  AND enc != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("followup");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;                    
}

public HashMap<String, String[]> getmonthmatDetails(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%January%' AND maturity != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%February%' AND maturity != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%March%'  AND maturity != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%April%'  AND maturity != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%May%'  AND maturity != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%June%'  AND maturity != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%July%' AND maturity != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%August%'  AND maturity != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%September%'  AND maturity != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%October%'  AND maturity != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%November%'  AND maturity != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%December%'  AND maturity != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("followup");
                
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;                     
}

public HashMap<String, String[]> getmonthBasicDetails(String mon) {
try {
             String command=null;
             HashMap<String, String[]> objMap = new HashMap<>();
             if("January".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%January%' AND dca_basic != ?";}
             if("February".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%February%' AND dca_basic != ?";}    
             if("March".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%March%'  AND dca_basic != ?";}    
             if("April".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%April%'  AND dca_basic != ?";}    
             if("May".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%May%'  AND dca_basic != ?";}    
             if("June".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%June%'  AND dca_basic != ?";}    
             if("July".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%July%' AND dca_basic != ?";}    
             if("August".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%August%'  AND dca_basic != ?";}    
             if("September".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%September%'  AND dca_basic != ?";}    
             if("October".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%October%'  AND dca_basic != ?";}    
             if("November".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%November%'  AND dca_basic != ?";}    
             if("December".equals(mon))
             {command = "SELECT * FROM membership_tb WHERE mvp_date LIKE '%December%'  AND dca_basic != ?";}    
             
             pt = con.prepareStatement(command);
             pt.setString(1, a); 
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [14];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("dob");
                 dataArray[10] = rs.getString("mvp_date");
                 dataArray[11] = rs.getString("2nd_date");
                 dataArray[12] = rs.getString("3rd_date");
                 dataArray[13] = rs.getString("followup");
                
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);    
                 count++;
            }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);}
    return null;                    
}

public HashMap<String, String[]> getallnotattendenc() {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,enc FROM membership_tb WHERE enc IS NULL";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }  
return null;                 
}

public HashMap<String, String[]> getallnotattendmat() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,maturity FROM membership_tb WHERE maturity IS NULL ";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;             
}

public HashMap<String, String[]> getallnotattendbasic() {
try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date,dca_basic FROM membership_tb WHERE dca_basic IS NULL ";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                String dataArray[] = new String [12];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }      
return null;                  
}

public HashMap<String, String[]> getallnotattenddli() {
 try {
             HashMap<String, String[]> objMap = new HashMap<>();
             String command = "SELECT id,first_name, last_name, phone_no,mail, address, cell_jurisdiction, gender, marital_status,mvp_date,"
                     + "2nd_date FROM membership_tb WHERE dli IS NULL ";
             pt = con.prepareStatement(command);
             rs = pt.executeQuery();
             int count = 0;
             while (rs.next())
             {
                 String dataArray[] = new String [11];
                 dataArray[0] = rs.getString("id");
                 dataArray[1] = rs.getString("first_name");
                 dataArray[2] = rs.getString("last_name");
                 dataArray[3] = rs.getString("phone_no");
                 dataArray[4] = rs.getString("mail");
                 dataArray[5] = rs.getString("address");
                 dataArray[6] = rs.getString("cell_jurisdiction");
                 dataArray[7] = rs.getString("gender");
                 dataArray[8] = rs.getString("marital_status");
                 dataArray[9] = rs.getString("mvp_date");
                 dataArray[10] = rs.getString("2nd_date");
                
                 String countStr = String.valueOf(count);
                 objMap.put(countStr, dataArray);
                 
                 count++;
             }
             return objMap;
         } catch (SQLException ex) {
             Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;             
 }
 
}
