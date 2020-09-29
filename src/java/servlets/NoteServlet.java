/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 727045
 */
public class NoteServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        /**
         * display the note.txt on the webpage for both view and edit
         */
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();

        Note note = new Note(title, content);
        br.close();

        String edit = request.getParameter("edit");
        if (!"".equals(edit))
        {
            request.setAttribute("title", note.getTitle());
            request.setAttribute("content", note.getContent());
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        } else
        {
            request.setAttribute("title", note.getTitle());
            request.setAttribute("content", note.getContent());
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        /**
         * Save changes from editnote
         */
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();

        Note note = new Note(title, content);
        br.close();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String nTitle = request.getParameter("title");
        String nContent = request.getParameter("content");
        
        pw.println(nTitle);
        pw.println(nContent);
        
        note.setTitle(nTitle);
        note.setContent(nContent);
        
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());

        
        pw.close();
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);

    }

}
