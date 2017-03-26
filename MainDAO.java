package model;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import mycon.MyCon;

public class MainDAO
{
  Connection con = null;
  PreparedStatement ps = null;
  String sql = null;
  String name;
  
  public boolean addUser(User U) throws Exception
  {  
     con = MyCon.getConnection();
     sql="insert into user values(?,?,?,?,?,?,?,?,?)";
     ps = con.prepareStatement(sql);
     ps.setString(1,U.getId());
     ps.setString(2,U.getFname()); 
     ps.setString(3,U.getLname());
     ps.setInt(4,U.getDesig());
     ps.setInt(5, U.getUid());
     ps.setString(6,U.getDept());
     ps.setString(7,U.getMail());
     ps.setString(8, U.getPhone());
     ps.setString(9,U.getPass());
              
    if(ps.executeUpdate()>0)
        return true;
    else
        return false;
  }
  
  public boolean verifyUser(String id,String pass) throws Exception
  {
       con = MyCon.getConnection();
       sql="select pass,fname from user where id=?";
       ps= con.prepareStatement(sql);
       ps.setString(1, id);
       ResultSet rs = ps.executeQuery();
       while(rs.next())
       {
          String p = rs.getString(1);
          if (p.equals(pass))
          {
              name= rs.getString(2);
              return true;
          }
       }
      return false;
  }
  public boolean uploadImage( String id) throws Exception
  {
  con = MyCon.getConnection();    
  sql = "insert into documents(photo,id) values(LOAD_FILE('D:\\please.jpg'),?)";
  ps = con.prepareStatement(sql);
  ps.setString(1,id);   
  int n = ps.executeUpdate();
  if(n>0)
      return true;
  else
     return false;
  }
  
  public List<Document> downloadImage(String id) throws Exception
  {
      con = MyCon.getConnection();
      ResultSet rs;
      sql = "select * from documents where id=?";
      ps = con.prepareStatement(sql);
      ps.setString(1, id);
      rs = ps.executeQuery();
      List<Document> list = new ArrayList<Document>();
      
      while(rs.next())
      {
          Document D = new Document();
          D.setPid(rs.getString(4));
          D.setAid(rs.getString(3));
          D.setId(rs.getString(2));
          D.setDname(rs.getString(5));
          D.setBlob(rs.getBlob(1));
          list.add(D);
          D=null;
      }     
      return list;
  }
  
  public boolean addAdmin(Admin A) throws Exception
  {
      con = MyCon.getConnection();
      sql = "insert into admin values(?,?,?,?,?)";
      ps = con.prepareStatement(sql);
      
      ps.setString(1, A.getId());
      ps.setString(2, A.getPass());
      ps.setString(3, A.getName());
      ps.setString(4, A.getContact());
      ps.setString(5, A.getMail());
      
      if(ps.executeUpdate()>0)
          return true;
      else
          return false;
  }
  
    public String getName() {
        return name;
    }
}
