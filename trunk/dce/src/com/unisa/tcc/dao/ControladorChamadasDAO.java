package com.unisa.tcc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.unisa.tcc.bean.AlunoBean;
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
			query.append("SELECT DISTINCT CH.IDCHAMADA, DIS.NOME AS DISCIPLINA, CL.SERIE_SERIE, ");
			query.append("CL.SERIE_TURMA, CL.DESCRICAO_SALA, CH.HORA_AULA, CL.IDCLASSE ");
			query.append("FROM CHAMADA CH, CLASSE_CHAMADA CLCH, CLASSE CL, DISCIPLINAS DIS ");
			query.append("WHERE CLCH.CHAMADA_IDCHAMADA = CH.IDCHAMADA ");
			query.append("AND CL.IDCLASSE = CLCH.CLASSE_IDCLASSE ");
			query.append("AND CH.DISCIPLINAS_IDDISCIPLINA = DIS.IDDISCIPLINA ");
			query.append("AND CH.DATA_CHAMADA = ? ");
			query.append("AND DIS.PROFESSOR_IDPROFESSOR = ? ");
			stmt = conn.prepareStatement(query.toString());
			if(ano != 0 && mes != 0 && dia != 0){
				stmt.setDate(1, new Date( new GregorianCalendar(ano, mes, dia).getTimeInMillis()));
			}else{
				stmt.setDate(1, new Date( new GregorianCalendar().getTimeInMillis()));
			}
			stmt.setInt(2, idProfessor);
			rs = stmt.executeQuery();
			while(rs.next()){
				DisciplinaBean disciplina = new DisciplinaBean();
				ClasseBean classe = new ClasseBean();
				ChamadaBean chamadaBean = new ChamadaBean();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				classe.setId(rs.getInt("IDCLASSE"));
				classe.setSerie(rs.getInt("SERIE_SERIE"));
				classe.setTurma(rs.getString("SERIE_TURMA").charAt(0));
				classe.setDescricaoSala(rs.getString("DESCRICAO_SALA"));
				chamadaBean.setId(rs.getInt("IDCHAMADA"));
				chamadaBean.setHoraAula(rs.getString("HORA_AULA"));
				chamadaBean.setClasse(classe);
				chamadaBean.setDisciplina(disciplina);
				listaChamadas.add(chamadaBean);
			}
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return listaChamadas;
	}
	
	public List<AlunoBean> consultarAlunosChamada(int idChamada, int idClasse) throws SQLException, DceException {
		List<AlunoBean> listaAlunosBean = new ArrayList<AlunoBean>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			StringBuffer query = new StringBuffer();
			conn = getConn();
			query.append("SELECT AL.NOME, AL.MATRICULA, CLCH.PRESENCA " +
						 "FROM CLASSE_CHAMADA CLCH, ALUNO AL " +
						 "WHERE CLCH.CHAMADA_IDCHAMADA = ? " +
						 " AND CLCH.CLASSE_IDCLASSE = ? " +
						 " AND AL.MATRICULA = CLCH.ALUNO_MATRICULA " +
						 "ORDER BY NOME ASC ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, idChamada);
			stmt.setInt(2, idClasse);
			rs = stmt.executeQuery();
			while(rs.next()){
				AlunoBean aluno = new AlunoBean();
				aluno.setMatricula(rs.getInt("MATRICULA"));
				aluno.setNome(rs.getString("NOME"));
				aluno.setPresenca(rs.getBoolean("PRESENCA"));
				listaAlunosBean.add(aluno);
			}
		}finally{
			rs.close();
			stmt.close();
			conn.close();
		}
		return listaAlunosBean;
	}
	
	public boolean salvarChamada(List<AlunoBean> listaAlunos, int idChamada, int idClasse) throws SQLException, DceException {
		PreparedStatement stmt = null;
		int resultado = 0;
		boolean comResultado = true;
		try{
			StringBuffer query = new StringBuffer();
			conn = getConn();
			query.append("UPDATE CLASSE_CHAMADA SET PRESENCA = ?  WHERE ALUNO_MATRICULA= ? " +
						 "AND CHAMADA_IDCHAMADA = ? AND CLASSE_IDCLASSE = ?");
			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(3, idChamada);
			stmt.setInt(4, idClasse);
			Iterator<AlunoBean> itrListaAlunos = listaAlunos.iterator();
			while (itrListaAlunos.hasNext() && comResultado){
				AlunoBean aluno = itrListaAlunos.next();
				stmt.setBoolean(1, aluno.isPresenca());
				stmt.setInt(2, aluno.getMatricula());
				resultado = stmt.executeUpdate();
				if(resultado == 0){
					comResultado = false;
				}
			}
			if(comResultado){
				conn.commit();
			}else{
				conn.rollback();
			}
		}finally{
			stmt.close();
			conn.close();
		}
		return comResultado;
	}
}
