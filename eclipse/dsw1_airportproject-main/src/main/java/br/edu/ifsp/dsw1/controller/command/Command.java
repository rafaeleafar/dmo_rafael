package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {

	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
