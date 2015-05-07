package cibertec.edu.pe.daos;

import java.sql.ResultSet;
import java.util.ArrayList;

import cibertec.edu.pe.beans.Pais;

public class PaisDAO {
	
	public ArrayList<Pais> Listar(){
		ArrayList<Pais> lista=new ArrayList<Pais>();
		try {
			SQLConnect sql=new SQLConnect();
			ResultSet  rs=sql.Listado("select * from pais",
					new Object[]{});
			Pais obj;
			while(rs.next()){
				obj=new Pais();
				obj.setIdPais(rs.getString("idpais"));
				obj.setDesPais(rs.getString("despais"));
				lista.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return lista;
	}
}
