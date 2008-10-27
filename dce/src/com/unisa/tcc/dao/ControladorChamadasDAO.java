package com.unisa.tcc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.unisa.tcc.bean.ChamadaBean;
import com.unisa.tcc.bean.ClasseBean;
import com.unisa.tcc.bean.DisciplinaBean;
import com.unisa.tcc.propriedades.DceException;

public class ControladorChamadasDAO extends TransactionManager{

	public List<ChamadaBean> consultarChamadasPorData(int idProfessor, GregorianCalendar data) throws DceException{
		List<ChamadaBean> listaChamadas= new ArrayList<ChamadaBean>();
		ChamadaBean chamadaBean = new ChamadaBean();
		StringBuffer query = new StringBuffer();
		try{
			conn = getConn();
			query.append("SELECT DISC.NOME AS DISCIPLINA, CL.SERIE_SERIE, CL.SERIE_TURMA, CL.DESCRICAO_SALA " +
						 "FROM CHAMADA CH, CLASSE_CHAMADA CLCH, CLASSE CL, DISCIPLINAS DISC " +
						 "WHERE CH.DATA_CHAMADA = ? " + 
						 "AND DISC.PROFESSOR_IDPROFESSOR = ? " +
						 "AND CH.DISCIPLINAS_IDDISCIPLINA = DISC.IDDISCIPLINA " +
						 "AND CL.IDCLASSE = CLCH.CLASSE_IDCLASSE " +
						 "AND DISC.IDDISCIPLINA = CH.DISCIPLINAS_IDDISCIPLINA ");
			PreparedStatement stmt = conn.prepareStatement(query.toString());
			stmt.setDate(1, new Date(data.getGregorianChange().getTime()));
			stmt.setInt(2, idProfessor);
			ResultSet rs = stmt.executeQuery();
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
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			throw new DceException("Erro na consulta das chamadas por data!");
		}
		return listaChamadas;
	}
}
