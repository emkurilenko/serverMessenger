import com.oreilly.servlet.MultipartRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
    ConnectDB connectDB;
    @Override
    public void init() throws ServletException {
        //connectDB = new ConnectDB();
    }
    private static String message = "Error during Servlet processing";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
       /* String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println(name + " " + login + " "+ password);*/
        try {

            int len = req.getContentLength();
            System.out.println(len);
            byte[] input = new byte[len];
            ServletInputStream sin = req.getInputStream();
           ByteArrayOutputStream buffer = new ByteArrayOutputStream();
           int nRead;
           while((nRead = sin.read(input,0,input.length))!= -1){
               buffer.write(input,0,nRead);
           }
           buffer.flush();
            System.out.println(Arrays.toString(buffer.toByteArray()));
            System.out.println("1");
            InputStream inImage = new ByteArrayInputStream(buffer.toByteArray());
            System.out.println("2");
            BufferedImage bImageFromConvert = ImageIO.read(inImage);
            System.out.println("3");

            ImageIO.write(bImageFromConvert,"jpg",new File("D:\\1.jpg"));
            System.out.println("4");
            System.out.println("sucsefull");
            PrintWriter writer = resp.getWriter();
            writer.write("test");
        } catch (IOException e) {
            try{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().print(e.getMessage());
                resp.getWriter().close();
            } catch (IOException ioe) {
            }
        }

    }

   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       *//* String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        Part p = req.getPart("photo");
        byte[] array = req.getParameter("photo").getBytes();
        System.out.println(login+password+name);
       // System.out.println(Arrays.toString(array));*//*
        //byte[] array = req.getInputStream().readAllBytes();
        PrintWriter writer = resp.getWriter();
       InputStreamReader in = new InputStreamReader(req.getInputStream());
        int a;
        while ((a = in.read())!= -1) {
            System.out.println(a);
        }
        System.out.println("pidor");
        writer.write("Pidor");
    }*/
}
