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
		StringBuffer query = new StringBuffer();
		try{
			conn = getConn();
			query.append("SELECT CH.IDCHAMADA, DIS.NOME AS DISCIPLINA, CL.SERIE_SERIE, CL.SERIE_TURMA, CL.DESCRICAO_SALA ");
			query.append("FROM CHAMADA CH, CLASSE_CHAMADA CLCH, CLASSE CL, DISCIPLINAS DIS ");
			query.append("WHERE CLCH.CHAMADA_IDCHAMADA = CH.IDCHAMADA ");
			query.append("AND CL.IDCLASSE = CLCH.CLASSE_IDCLASSE ");
			query.append("AND CH.DISCIPLINAS_IDDISCIPLINA = DIS.IDDISCIPLINA ");
			query.append("AND CH.DATA_CHAMADA = ? ");
			query.append("AND DIS.PROFESSOR_IDPROFESSOR = ? ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setDate(1, new Date( new java.util.GregorianCalendar(ano, mes, dia).getTimeInMillis()));
			stmt.setInt(2, idProfessor);
			rs = stmt.executeQuery();
			while(rs.next()){
				DisciplinaBean disciplina = new DisciplinaBean();
				ClasseBean classe = new ClasseBean();
				ChamadaBean chamadaBean = new ChamadaBean();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				classe.setSerie(rs.getInt("SERIE_SERIE"));
				classe.setTurma(rs.getString("SERIE_TURMA").charAt(0));
				classe.setDescricaoSala(rs.getString("DESCRICAO_SALA"));
				chamadaBean.setId(rs.getInt("IDCHAMADA"));
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
