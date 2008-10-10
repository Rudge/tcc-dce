package com.unisa.tcc.propriedades;


public class DceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DceException(){
		
	}
	
	public DceException(String msg) {
		super(msg);
    }

    public DceException(Exception excecao) {
		this(Constantes.ERRO_SISTEMA, excecao);
    }
    
    public DceException(String msg, Exception e) {
		super(msg);
    }

}
