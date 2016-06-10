package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Prescription;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.SideEffect;

public class SiteEffectModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public SiteEffectModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<SideEffect> fetchAll() {
		String sql = "SELECT * from sideEffect;";
		
		ArrayList<SideEffect> al = new ArrayList<SideEffect>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				SideEffect obj = new SideEffect();
				obj.setSideEffect_id(rs.getInt("sideEffect_id"));
				obj.setDescription(rs.getString("description"));
				obj.setName(rs.getString("name"));

				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public SideEffect get(int id) {
		String sql = "SELECT * from sideEffect where siteEffect_id = " + id +";";
		SideEffect obj = new SideEffect();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setSideEffect_id(rs.getInt("sideEffect_id"));
				obj.setDescription(rs.getString("description"));
				obj.setName(rs.getString("name"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
}
