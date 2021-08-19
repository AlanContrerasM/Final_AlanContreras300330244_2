package com.example.final_alancontreras300330244_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Github link: https://github.com/AlanContrerasM/Final_AlanContreras300330244_2
@SessionAttributes({"id","desc","errMsg","errorMessage"})
@RequestMapping
@Controller
public class InventoryController {
    DatabaseService service1;
    @Autowired
    Connection123 connect;

    //a mapping when someone enters file
    @RequestMapping(value = "/loantable", method = RequestMethod.GET)
    public String showLoanTablePage(ModelMap model,@RequestParam(defaultValue = "") String id) throws
            ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());
        List<Loan> filteredTodos = new ArrayList<Loan>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getClientno());
        model.put("name",filteredTodos.get(0).getClientname());
        model.put("amount",filteredTodos.get(0).getLoanamount());
        model.put("years",filteredTodos.get(0).getYears());
        model.put("type",filteredTodos.get(0).getLoantype());


        return "loantable";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoanTablePage2(ModelMap model) throws ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());
        List<Loan> filteredTodos = new ArrayList<Loan>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getClientno());
        model.put("name",filteredTodos.get(0).getClientname());
        model.put("amount",filteredTodos.get(0).getLoanamount());
        model.put("years",filteredTodos.get(0).getYears());
        model.put("type",filteredTodos.get(0).getLoantype());




        return "loantable";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "loanadd";
    }
    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String clientno, @RequestParam String clientname,
                          @RequestParam Double loanamount, @RequestParam int years, @RequestParam String loantype)
            throws SQLException, ClassNotFoundException {

        if (!((service1.search(clientno)) ==null)){
            model.put("errorMessage","The record you re trying to add is already existing");
            return "redirect:/loantable";
        }
        Loan cc = new Loan(clientno, clientname, loanamount, years, loantype);

        service1.add(cc);
        model.clear();
        return "redirect:/loantable";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws SQLException, ClassNotFoundException {
        model.put("id", id);
        Loan loan = service1.search(id);
        model.put("clientno",loan.getClientno());
        model.put("clientname",loan.getClientname());
        model.put("loanamount",loan.getLoanamount());
        model.put("years",loan.getYears());
        model.put("loantype",loan.getLoantype());


        return "loanedit";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,@RequestParam String clientno, @RequestParam String clientname,
                             @RequestParam Double loanamount, @RequestParam int years, @RequestParam String loantype) throws SQLException, ClassNotFoundException {

        String iid = (String) model.get("id");
        Loan loan = new Loan(clientno, clientname, loanamount, years, loantype);
        service1.edit(loan,iid);
        return "redirect:/";
    }

    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException,
            ClassNotFoundException {
        service1.delete(id);
        model.clear();
        return "redirect:/";
    }


    @RequestMapping(value = "/amortizate-todo", method = RequestMethod.GET)
    public String showAmortizatePage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws SQLException, ClassNotFoundException {
        model.put("id", id);
        Loan loan = service1.search(id);
        model.put("clientno",loan.getClientno());
        model.put("clientname",loan.getClientname());
        model.put("loanamount",loan.getLoanamount());
        model.put("years",loan.getYears());
        model.put("loantype",loan.getLoantype());

        //we have to create an array list with month, Starting amount, interest, monthly payment, and balance
        double interest =.06;

        if (loan.getLoantype().equals("Business")){
            interest = .09;
        }
        double monthlyPayment= (loan.getLoanamount()*(interest/12)) / (1-Math.pow(1+ interest/12, loan.getYears()*12));

        ArrayList<AmortInfo> row = new ArrayList<AmortInfo>();
        double finalAmt = loan.getLoanamount();
        for(int i = 0 ; i < loan.getYears()*12; i++){
            row.add(new AmortInfo(i,0,0, monthlyPayment, finalAmt));
            finalAmt -= monthlyPayment;
        }

        model.addAttribute("todos", row);

        return "loanamort";
    }




}