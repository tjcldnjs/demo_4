package com.tenco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoServlet() {
        super();
    }
    

    
    // get 요청시 동작
    // 주소 설계 - http://localhost:8080/d4/todo-servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 확인");
		URL url = new URL("https://jsonplaceholder.typicode.com/todos");
		
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		
		int response1 = conn.getResponseCode();
		System.out.println(response1);
		
		BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String inputLine;
		StringBuffer responseBuffer = new StringBuffer();
		
		while((inputLine = brIn.readLine()) != null) {
			responseBuffer.append(inputLine);
		}
		response.setContentType("application/json");
		response.getWriter().write(responseBuffer.toString());
//		
	    // Gson
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		
//		Type todoType = new TypeToken<List<Todo>>(){}.getType();
//		List<Todo> todoList = gson.fromJson(responseBuffer.toString(), todoType);
//		
//		for (Todo todo : todoList) {
//			response.setContentType("application/json");
//			response.getWriter().write(todo.toString());
//		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
