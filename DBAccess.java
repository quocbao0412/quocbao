/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo3jdbc;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author quocbao0412
 */
public class DBAccess {
  Connection con = null;
  Statement stmt = null;

  public DBAccess() {
  }
  
  public void connectDB(String driver, String url) {
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url);
      stmt = con.createStatement();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  
  public void connectDB(String driver, String url, String uid, String pwd) {
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, uid, pwd);
      stmt = con.createStatement();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
  
  public ResultSet executeQuery(String selectSql) {
    if (con == null) {
      return null;
    }
    try {
      return (stmt.executeQuery(selectSql));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
    return null;
  }
  
  public int executeUpdate(String updateSql) {
    if (con == null) {
      return 0;
    }
    try {
      return (stmt.executeUpdate(updateSql));
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
    return 0;
  }
}
