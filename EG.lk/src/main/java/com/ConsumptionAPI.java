package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ConsumptionAPI
 */
@WebServlet("/ConsumptionAPI")
public class ConsumptionAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Consumption consumeObj = new Consumption();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsumptionAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String output = consumeObj.createConsume(request.getParameter("id"), request.getParameter("accountNo"),
				request.getParameter("date"), request.getParameter("units"));
		response.getWriter().write(output);
		doGet(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(req);
		String output = consumeObj.updateConsume(paras.get("hidConsumIDSave").toString(), paras.get("id").toString(),
				paras.get("accountNo").toString(), paras.get("date").toString(), paras.get("units").toString());
		resp.getWriter().write(output);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(req);
		String output = consumeObj.deleteConsume(paras.get("ConsumID").toString());
		resp.getWriter().write(output);

	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UIF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {

		}
		return map;
	}

}

