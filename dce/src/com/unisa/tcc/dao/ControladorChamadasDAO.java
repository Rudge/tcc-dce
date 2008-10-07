package com.unisa.tcc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.unisa.tcc.bean.ChamadaBean;
import com.unisa.tcc.bean.DisciplinaBean;
import com.unisa.tcc.bean.ProfessorBean;

public class ControladorChamadasDAO extends TransactionManager{

	public List<ChamadaBean> consultarChamada(int idProfessor, GregorianCalendar data){
		List<ChamadaBean> listaChamadas= new ArrayList<ChamadaBean>();
		ChamadaBean chamadaBean = new ChamadaBean();
		StringBuffer query = new StringBuffer();
		try{
			conn = getConn();
			query.append("SELECT " +
					   	 	" * " +
					   	 "FROM LISTAPRESENCA, DISCIPLINA, CLASSE " +
				 		 "WHERE IDPROFESSOR = ? AND DATE = ?");
			PreparedStatement stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, idProfessor);
			stmt.setDate(2, new Date(data.getGregorianChange().getTime()));
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				DisciplinaBean disciplina = new DisciplinaBean();
				ProfessorBean professor = new ProfessorBean();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				disciplina.setProfessor(professor);
				chamadaBean.setDisciplina(disciplina);
				chamadaBean.setData(data);
				listaChamadas.add(chamadaBean);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			
		}
		
		return listaChamadas;
	}
}
