package com.wedding.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.wedding.service.TypeLobbyService;
import com.wedding.utils.UrlConstant;

@WebServlet({UrlConstant.URL_TYPELOBBY})
public class TypeLobbyApiController extends HttpServlet{
	private TypeLobbyService typeLobbyService;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		typeLobbyService = new TypeLobbyService();
	}


}