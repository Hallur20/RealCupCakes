
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/DataServlet"})
public class DataServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        DataMapper dm = new DataMapper();

        //hent ToppingsListen.
        ArrayList<Toppings> tList = dm.Toppings();
        //hent BottomsListen
        ArrayList<Bottoms> bList = dm.Bottoms();

        //udvælg toppings/bottoms-name og toppings/bottoms-price
        ArrayList<String> bName = new ArrayList<>();
        ArrayList<Integer> bPrice = new ArrayList<>();
        ArrayList<String> tName = new ArrayList<>();
        ArrayList<Integer> tPrice = new ArrayList<>();
        for (int i = 0; i < tList.size(); i++) {
            tName.add(tList.get(i).gettName());
            tPrice.add(tList.get(i).gettPrice());
        }
        for (int i = 0; i < bList.size(); i++) {
            bName.add(bList.get(i).getbName());
            bPrice.add(bList.get(i).getbPrice());
        }

        request.setAttribute("bName", bName);
        request.setAttribute("bPrice", bPrice);
        request.setAttribute("tName", tName);
        request.setAttribute("tPrice", tPrice);

                try {
            int totalSum = (Integer) Integer.parseInt((String) request.getAttribute("totalSum"));
            request.setAttribute("payment", totalSum);
        } catch (Exception ex) {

        }

        RequestDispatcher rd = request.getRequestDispatcher("access.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
