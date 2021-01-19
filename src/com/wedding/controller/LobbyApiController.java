package com.wedding.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wedding.models.Lobby;
import com.wedding.service.LobbyService;
import com.wedding.utils.UrlConstant;

@WebServlet({ UrlConstant.URL_LOBBY, UrlConstant.URL_LOBBY_ADD, UrlConstant.URL_LOBBY_DELETE,
		UrlConstant.URL_LOBBY_UPDATE, UrlConstant.URL_LOBBY_CHECK })
public class LobbyApiController extends HttpServlet {

	private LobbyService lobbyService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		lobbyService = new LobbyService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case UrlConstant.URL_LOBBY:
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			List<Lobby> lobbies = lobbyService.getAllLobby();
			Gson gson = new Gson();
			String data = gson.toJson(lobbies);
			PrintWriter writer = resp.getWriter();
			writer.write(data);
			writer.flush();
			break;
		case UrlConstant.URL_LOBBY_CHECK:
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			String weddingDate = req.getParameter("weddingDate");
			//System.out.println(weddingDate);
			int shift = Integer.parseInt(req.getParameter("shift"));
			lobbies = lobbyService.checkLobby(weddingDate, shift);
			gson = new Gson();
			data = gson.toJson(lobbies);
			writer = resp.getWriter();
			writer.write(data);
			writer.flush();
			break;
		default:
			break;
		}
	}

}