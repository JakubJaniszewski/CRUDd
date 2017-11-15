package com.CRUD;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class StudentController implements HttpHandler {

    StudentRepo repo = new StudentRepo();

    public void handle(HttpExchange httpExchange) throws IOException {

        URI uri = httpExchange.getRequestURI();

        Map<String, String> parsedUri = parseURI(uri.getPath());

        String action = parsedUri.get("action");
        String data = parsedUri.get("data");

        String response = "";

        switch (action) {
            case "list":
                response = list();
                break;

            case "edit":
                response = edit(data);
                break;

            case "delete":
                response = delete(data);
                break;

            case "add":
                response = add(httpExchange);
                break;
        }

        final byte[] finalResponseBytes = response.getBytes("UTF-8");
        httpExchange.sendResponseHeaders(200, finalResponseBytes.length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(finalResponseBytes);
        os.close();
    }

    private String add(HttpExchange httpExchange) {
        
        return "";
    }

    private String delete(String data) {
        return "";
    }

    private String edit(String data) {
        return "";
    }

    private String list() {
        StringBuilder response = new StringBuilder();

        response.append("<html><head></head><body>");

        for(Student student : this.repo.getStudents()) {
            response.append("<p>");
            response.append(student.toString());
            response.append("</p>");
        }

        response.append("</body></html>");

        return response.toString();
    }

    private Map<String, String> parseURI (String uri) {
        Map<String, String> parsedURI = new HashMap<String, String>();
        String[] uriList = uri.split("/");
        if (uriList.length == 3 && uriList[1].equals("students")) {
            parsedURI.put("action", uriList[2]);
            parsedURI.put("data", "");
        } else if (uriList.length == 4 && uriList[1].equals("students") &&
                (uriList[2].equals("delete") || uriList[2].equals("edit"))) {
            parsedURI.put("action", uriList[2]);
            parsedURI.put("data", uriList[3]);
        } else {
            parsedURI.put("action", "list");
            parsedURI.put("data", "");
        }

        return parsedURI;
    }

}
