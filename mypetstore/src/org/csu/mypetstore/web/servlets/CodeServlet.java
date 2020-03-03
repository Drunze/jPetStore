package org.csu.mypetstore.web.servlets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CodeServlet")
public class CodeServlet extends HttpServlet {

    public CodeServlet() {
        super();
    }
    public void destroy() {
        super.destroy();}

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("    This is ");
            out.print(this.getClass());
            out.println(", using the POST method");
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
       }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        Random random = new Random();
        Color c = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
        g.setColor(c);//背景颜色
        g.fillRect(0, 0, 68, 22);//背景框

        //字母数字组合：
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVEXYZ123456789".toCharArray();
        Random r = new Random();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<4;i++){
            index = r.nextInt(len);//随机获得一个起始位置
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));//给字体一个随机的颜色

            g.drawString(ch[index]+"", (i*15)+3, 18);
            sb.append(ch[index]);
        }
        HttpSession session = request.getSession();
        session.setAttribute("piccode", sb.toString());//将生产的验证码保存下来，以便之后的检验输入是否一致
        ImageIO.write(bi,"JPG",response.getOutputStream());





    }
}
