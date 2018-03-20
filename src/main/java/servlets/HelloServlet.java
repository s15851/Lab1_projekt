package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Credit;
import model.CreditType;

@WebServlet("/Calculation")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{	
		Credit credit = processCredit(request, response);
	    if(credit.getCapital()==0 || credit.getInstallments()==0 || credit.getFee()==0 || credit.getRate()==0) {
	    	response.sendRedirect("/");
	    }
	    else {
	    	request.setAttribute("credit", credit);
	    	include("calculation.jsp", request, response);			
	    }
	}
	
    protected Credit processCredit(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        Double capital = Double.valueOf(request.getParameter("capital"));
        Integer installments = Integer.valueOf(request.getParameter("installments"));
        Double rate = Double.valueOf(request.getParameter("rate"));
        Double fee = Double.valueOf(request.getParameter("fee"));
        String type = request.getParameter("type");
        
        Credit credit = new Credit(capital, installments, rate, fee, CreditType.valueOf(type));
        
        return credit; 
    }	

    protected void include(String page, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher(page).include(request, response);
    }
}
