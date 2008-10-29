package com.unisa.tcc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unisa.tcc.bean.ChamadaBean;
import com.unisa.tcc.bean.ClasseBean;
import com.unisa.tcc.bean.DisciplinaBean;
import com.unisa.tcc.propriedades.DceException;

public class ControladorChamadasDAO extends TransactionManager{

	public List<ChamadaBean> consultarChamadasPorData(int idProfessor, int ano, int mes, int dia) throws DceException, SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ChamadaBean> listaChamadas= new ArrayList<ChamadaBean>();
		ChamadaBean chamadaBean = new ChamadaBean();
		StringBuffer query = new StringBuffer();
		try{
			conn = getConn();
			query.append("SELECT DISTINCT DISC.NOME AS DISCIPLINA, CL.SERIE_SERIE, CL.SERIE_TURMA, CL.DESCRICAO_SALA " +
						 "FROM CHAMADA CH, CLASSE_CHAMADA CLCH, CLASSE CL, DISCIPLINAS DISC " +
						 "WHERE CH.DATA_CHAMADA = ? " + 
						 "AND DISC.PROFESSOR_IDPROFESSOR = ? " +
						 "AND CH.DISCIPLINAS_IDDISCIPLINA = DISC.IDDISCIPLINA " +
						 "AND CL.IDCLASSE = CLCH.CLASSE_IDCLASSE ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setDate(1, new Date( new java.util.GregorianCalendar(ano, mes, dia).getTimeInMillis()));
			stmt.setInt(2, idProfessor);
			rs = stmt.executeQuery();
			while(rs.next()){
				DisciplinaBean disciplina = new DisciplinaBean();
				ClasseBean classe = new ClasseBean();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				classe.setSerie(rs.getInt("SERIE_SERIE"));
				classe.setTurma(rs.getString("SERIE_TURMA").charAt(0));
				classe.setDescricaoSala(rs.getString("DESCRICAO_SALA"));
				chamadaBean.setClasse(classe);
				chamadaBean.setDisciplina(disciplina);
				listaChamadas.add(chamadaBean);
			}
		}catch (SQLException e) {
			throw new DceException("Erro na consulta das chamadas por data!");
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return listaChamadas;
	}
}
