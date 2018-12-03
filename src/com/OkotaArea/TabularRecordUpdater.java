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


import java.util.HashMap;
import javax.swing.table.DefaultTableModel;


public class TabularRecordUpdater {
    Admin ad;
    MVP mvp;
    Membership mem;
    NewBeliver NB;
    Workers Wk;
    Cell cell;
    AreaReport ap;
    Discipleship dis;
    HashMap<String, String[]> objMap;
    public TabularRecordUpdater(HashMap<String, String[]> objMap,Admin ad) {
           initComponents();
        this.objMap = objMap;
        this.ad = ad;
    } 
    public TabularRecordUpdater(HashMap<String, String[]> objMap,Membership mem) {
           initComponents();
        this.objMap = objMap;
        this.mem = mem;
    } 
    public TabularRecordUpdater(HashMap<String, String[]> objMap,MVP mvp) {
           initComponents();
        this.objMap = objMap;
        this.mvp =mvp;
    } 
    public TabularRecordUpdater(HashMap<String, String[]> objMap,NewBeliver NB) {
           initComponents();
        this.objMap = objMap;
        this.NB =NB;
    } 
    public TabularRecordUpdater(HashMap<String, String[]> objMap,Workers Wk) {
           initComponents();
        this.objMap = objMap;
        this.Wk =Wk;
    } 

    TabularRecordUpdater(HashMap<String, String[]> objMap, Cell cell) {
       this.objMap = objMap;
       this.cell = cell;  
    }

    TabularRecordUpdater(HashMap<String, String[]> objMap, AreaReport ap) {
       this.objMap = objMap;
       this.ap = ap;  
    }

    TabularRecordUpdater(HashMap<String, String[]> objMap, Discipleship dis) {
       this.objMap = objMap;
       this.dis = dis; 
    }
    
    public void populateallMemberTable(HashMap<String, String[]> obj)
    {
        DefaultTableModel DTM = (DefaultTableModel)mem.getAllareamemberTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         mem.getAllareamemberTable().setRowHeight(i, 25);
        }
    }
    public void populateOnememberTable(HashMap<String, String[]> obj)
    {
        DefaultTableModel DTM = (DefaultTableModel)mem.getViewareamemberTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         mem.getViewareamemberTable().setRowHeight(i, 25);
        }
    }

    public void populateallMvpTable(HashMap<String, String[]> obj) {
        DefaultTableModel DTM = (DefaultTableModel)mvp.getAllmvpTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         mvp.getAllmvpTable().setRowHeight(i, 25);
        }
    }
    public void populateOneMvpTable(HashMap<String, String[]> obj) {
        DefaultTableModel DTM = (DefaultTableModel)mvp.getViewmvpTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         mvp.getViewmvpTable().setRowHeight(i, 25);
        }
    }
    public void populateallNBTable(HashMap<String, String[]> obj) {
        DefaultTableModel DTM = (DefaultTableModel)NB.getAllnewbeliverTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         NB.getAllnewbeliverTable().setRowHeight(i, 25);
        }
        }
   public void populateOneNBTable(HashMap<String, String[]> obj) {
       DefaultTableModel DTM = (DefaultTableModel)NB.getViewnewbeliverTable().getModel();
       DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         NB.getViewnewbeliverTable().setRowHeight(i, 25);
        } 
    }
public void populateallWorkersTable(HashMap<String, String[]> obj)
    {
        DefaultTableModel DTM = (DefaultTableModel)Wk.getAllworkersTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         Wk.getAllworkersTable().setRowHeight(i, 25);
        }
    }
    public void populateOneWorkerTable(HashMap<String, String[]> obj)
    {   
        DefaultTableModel DTM = (DefaultTableModel)Wk.getViewworkerTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         Wk.getViewworkerTable().setRowHeight(i, 25);
        }
    }
 public void populateallCellMemberTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)cell.getAllareamemberTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         cell.getAllareamemberTable().setRowHeight(i, 30);
        } }    } 
public void populateallCellReportTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)cell.getAllcellreportTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         cell.getAllcellreportTable().setRowHeight(i, 25);
        } }        }
public void populateoneCellReportTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)cell.viewallcellreportTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         cell.viewallcellreportTable().setRowHeight(i, 25);
        } }        }
public void populateallareaReportTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)ap.getAllareareportTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         ap.getAllareareportTable().setRowHeight(i, 25);
        } }     
}
public void populateoneareaReportTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)ap.getEditareareportTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         ap.getEditareareportTable().setRowHeight(i, 25);
        } }           
}
public void populateallattendTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)dis.getAlldiscipleshipTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         dis.getAlldiscipleshipTable().setRowHeight(i, 25);
        } }  
    }
public void populateOneInExTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)ad.getViewINexTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         ad.getViewINexTable().setRowHeight(i, 25);
        } }  
    }
public void populateAllInExTable(HashMap<String, String[]> obj) {
        {   
        DefaultTableModel DTM = (DefaultTableModel)ad.getAllINexTable().getModel();
        DTM.setRowCount(0);
        for (int i=0; i<obj.size(); i++)
        { 
         String data []  = obj.get(String.valueOf(i));
         DTM.addRow(data);
         ad.getAllINexTable().setRowHeight(i, 25);
        } }  
    }
 private void initComponents() {}    

}
