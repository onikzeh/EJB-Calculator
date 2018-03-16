package thenational;

import com.thenational.ejb.local.AddLocal;
import com.thenational.ejb.local.DevideLocal;
import com.thenational.ejb.remote.DevideRemote;
import com.thenational.util.NabUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Controller
public class SalaryController {

    @Autowired
    private InitialContext context;

    @RequestMapping(value = {"/calculate"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() throws NamingException {
        ModelAndView model = new ModelAndView("result");
        String message = "NULL!!";

        String value1 = "6";
        String value2 = "2";

        /*
         * look up each time, before calling the EJB eliminates need of restarting the Calculator App, each time the AddEJB gets redeploy.
         */
        AddLocal addLocal = (AddLocal) context.lookup("ejblocal:nab/addService");
        DevideLocal devideLocal = (DevideLocal) context.lookup("ejblocal:nab/devideService");
        DevideLocal devideLocalGlobal =
                (DevideLocal) context.lookup("java:global/Devide_EJB/DevideEJB_ejb/MyDevideBean!com.thenational.ejb.local.DevideLocal");

        DevideRemote devideRemote = (DevideRemote) context.lookup("nab/devideService");
        DevideRemote devideRemoteGlobal =
                (DevideRemote) context.lookup("java:global/Devide_EJB/DevideEJB_ejb/MyDevideBean!com.thenational.ejb.remote.DevideRemote");


        if (addLocal != null) {
            message = "add(" + value1 + "," + value2 + ") : '" + NabUtils.format(addLocal.add(value1, value2)) + "'";
            message += "<BR><BR>";
            message += "devideLocal(" + value1 + "," + value2 + ") : '" + devideLocal.devide(value1, value2) + "'";
            message += "<BR><BR>";
            message += "devideLocalGlobal(" + value1 + "," + value2 + ") : '" + devideLocalGlobal.devide(value1, value2) + "'";
            message += "<BR><BR>";
            message += "devideRemote(" + value1 + "," + value2 + ") : '" + devideRemote.devide(value1, value2) + "'";
            message += "<BR><BR>";
            message += "devideRemoteGlobal(" + value1 + "," + value2 + ") : '" + devideRemoteGlobal.devide(value1, value2) + "'";
            message += "<BR><BR>";
            message += "Number of NabUtils class calls : '" + NabUtils.getNumberOfClassCalls() + "'";
        }

        model.addObject("msg", "<h1><b>Salary Calculator</b><BR><BR><BR>" + message + "</h1>");
        return model;
    }

}