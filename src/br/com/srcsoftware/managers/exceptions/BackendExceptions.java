package br.com.srcsoftware.managers.exceptions;

public class BackendExceptions extends Exception{

	public BackendExceptions( String message ){
		super( message );
	}

	public BackendExceptions( String message, Throwable cause ){
		super( message, cause );
	}
}
