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
import com.wedding.models.Food;
import com.wedding.service.FoodService;
import com.wedding.utils.UrlConstant;

@WebServlet({ UrlConstant.URL_FOOD, UrlConstant.URL_FOOD_ADD, UrlConstant.URL_FOOD_DELETE,
		UrlConstant.URL_FOOD_UPDATE })
public class FoodApiController extends HttpServlet {

	private FoodService foodService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		foodService = new FoodService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
			case UrlConstant.URL_FOOD:
				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json");
				List<Food> foods = foodService.getAllFood();
				Gson gson = new Gson();
				String foodJson = gson.toJson(foods);
				PrintWriter writer = resp.getWriter();
				writer.write(foodJson);
				writer.flush();
				break;
			default:
				break;
		}
	}


}