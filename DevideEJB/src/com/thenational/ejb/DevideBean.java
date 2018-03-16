package com.thenational.ejb;

import com.thenational.ejb.local.DevideLocal;
import com.thenational.ejb.remote.DevideRemote;
import com.thenational.util.NabUtils;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

//@Path("/payment/")
//@Consumes({ "application/xml", "application/json" })
//@Produces({ "application/xml", "application/json" })
@Local({DevideLocal.class})
@Remote({DevideRemote.class})
@Stateless(name = "MyDevideBean")
public class DevideBean implements DevideRemote, DevideLocal {

    public DevideBean() {
    }

    public String devide(String value1, String value2) {
        if (NabUtils.isNumber(value1) && NabUtils.isNumber(value2)) {
            return "" + Integer.parseInt(value1) / Integer.parseInt(value2);
        } else {
            return "  [" + value1 + " / " + value2 + "]";
        }
    }

//    public static void main(String[] args) {
//        try {
//            Properties p = new Properties();
//            p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
//            p.put(Context.PROVIDER_URL, "localhost:1099");
//            p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
//            InitialContext ctx = new InitialContext(p);
//
//            CalculatorRemote calculatorRemote = (CalculatorRemote) ctx.lookup("Calculator/remote");
//            System.out.println("Total of 9+3: "+calculatorRemote.addNumbers(9, 3));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//}
}
