package cibertec.edu.pe.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLConnect {
	
	Connection cn=null;
	public SQLConnect(){
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			cn = DriverManager.
			getConnection("jdbc:jtds:sqlserver://localhost:1433/pit","sa","sql");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String Ejecutar(String SQL,Object[] arreglo){
		String result="";
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			//SQL="insert into ciudad values(?,?)";
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			int f=cmd.executeUpdate();
			result="Se afectaron "+f+" filas";
		} catch (Exception e) {
			// TODO: handle exception
			result ="Error "+e.getMessage();
		}	
		return result;
	}
	
	public ResultSet Listado(String SQL,Object[] arreglo){
		ResultSet rs=null;
		try {
			PreparedStatement cmd=cn.prepareStatement(SQL);
			for(int i=0;i<arreglo.length;i++){
				cmd.setObject(i+1, arreglo[i]);
			}
			rs=cmd.executeQuery();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return rs;
	}	

}
