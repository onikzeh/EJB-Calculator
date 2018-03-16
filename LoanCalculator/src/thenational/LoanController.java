package thenational;

import com.thenational.ejb.local.AddLocal;
import com.thenational.ejb.local.DevideLocal;
import com.thenational.ejb.local.MultiplyLocal;
import com.thenational.ejb.remote.DevideRemote;
import com.thenational.util.NabUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoanController extends AbstractController {

    private AddLocal add;
    private MultiplyLocal multiply;
    private DevideLocal devideLocal;
    private DevideRemote devideRemote;

    public LoanController(AddLocal add, MultiplyLocal multiply, DevideRemote devideRemote, DevideLocal devideLocal) {
        this.add = add;
        this.multiply = multiply;
        this.devideLocal = devideLocal;
        this.devideRemote = devideRemote;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("result");
        String value1 = "A";
        String value2 = "B";
        String message = "add(" + value1 + "," + value2 + ") : '" + NabUtils.format(add.add(value1, value2)) + "'";
        message += "<BR><BR>";
        message += "multiply(" + value1 + "," + value2 + ") : '" + NabUtils.format(multiply.multiply(value1, value2)) + "'";
        message += "<BR><BR>";
        message += "devideRemote(" + value1 + "," + value2 + ") : '" + NabUtils.format(devideRemote.devide(value1, value2)) + "'";
        message += "<BR><BR>";
        message += "devideLocal(" + value1 + "," + value2 + ") : '" + NabUtils.format(devideLocal.devide(value1, value2)) + "'";
        message += "<BR><BR>";
        message += "Number of NabUtils class calls : '" + NabUtils.getNumberOfClassCalls() + "'";

        model.addObject("msg", "<h1><b>Loan Calculator</b><BR><BR><BR>" + message + "</h1>");
        return model;
    }
}