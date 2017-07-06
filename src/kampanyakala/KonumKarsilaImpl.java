package kampanyakala;

import javax.jws.WebService;
import java.util.Date;
import java.sql.*;
import javax.sql.*;

@WebService(endpointInterface = "kampanyakala.KonumKarsila")
public class KonumKarsilaImpl implements KonumKarsila {
	
	@Override
	public String getKonumFarki(String x, String y) {
		int numusers = 0;
		double xValue = Double.parseDouble(x);
		double yValue = Double.parseDouble(y);
		double xValueService;
		double yValueService;
		String kampanyaBilgisi = null;
		double enYakinMesafe = 999;
		String enYakinKampanya = null;
		
		String dbUrl = "jdbc:mysql://localhost/kampanyakala_db";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * FROM companies";
		String userName = "asy_erec", password = "123456";
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl, userName, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			
		while (rs.next()) {
			kampanyaBilgisi = rs.getString("campaignInformation");
			xValueService = rs.getDouble("companyLocationX");
			yValueService = rs.getDouble("companyLocationY");
			
			if (Math.sqrt((Math.pow((xValue - xValueService),2)) + (Math.pow((yValue - yValueService),2))) < enYakinMesafe)
			{
				enYakinMesafe =  Math.sqrt((Math.pow((xValue - xValueService),2)) + (Math.pow((yValue - yValueService),2)));
				enYakinKampanya = kampanyaBilgisi;
			}
			/*
			 id
			 companyName
			 companyLocationX
			 companyLocationY
			*/
			
		}
			con.close();
		} 

		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			return "En yakýn: " + enYakinKampanya;
		}		
		//JSONObject obj = new JSONObject();
		//obj.put("sonuc", "merhaba");
	}
}