There are two ways of deploying EJB3 beans to server.
1- The manual way:

    Do not have any ibm-ejb-jar-bnd.xml file and do this manually:
        Enterprise Applications > Devide_EJB > EJB JNDI names > (All empty!)

        Enterprise Applications > Devide_EJB > Bind EJB Business >
        Module           Bean                     URI                               Business interface                  JNDI Name
    DevideEJB_ejb.jar   DevideBean   DevideEJB_ejb.jar,META-INF/ejb-jar.xml  com.thenational.ejb.local.DevideLocal      ejblocal:nab/local
    DevideEJB_ejb.jar   DevideBean   DevideEJB_ejb.jar,META-INF/ejb-jar.xml  com.thenational.ejb.remote.DevideRemote             nab/remote
 
    Only one of "EJB JNDI names" OR 
 
    Now at server logs:
        The server is binding the com.thenational.ejb.remote.DevideRemote interface of the RemoteDevideBean enterprise bean in the DevideEJB_ejb.jar module of the Devide_EJB application.  The binding location is: nab/remote
        The server is binding the com.thenational.ejb.remote.DevideRemote interface of the RemoteDevideBean enterprise bean in the DevideEJB_ejb.jar module of the Devide_EJB application.  The binding location is: java:global/Devide_EJB/DevideEJB_ejb/RemoteDevideBean!com.thenational.ejb.remote.DevideRemote
        The server is binding the com.thenational.ejb.local.DevideLocal interface of the RemoteDevideBean enterprise bean in the DevideEJB_ejb.jar module of the Devide_EJB application.  The binding location is: ejblocal:nab/local
        The server is binding the com.thenational.ejb.local.DevideLocal interface of the RemoteDevideBean enterprise bean in the DevideEJB_ejb.jar module of the Devide_EJB application.  The binding location is: java:global/Devide_EJB/DevideEJB_ejb/RemoteDevideBean!com.thenational.ejb.local.DevideLocal
 
    And we can access the EJB via Remote / Local interface via below calls (Different name for remote/local):
        ((DevideLocal)context.lookup("ejblocal:nab/local")).devide("A","D")
        ((DevideRemote)context.lookup("nab/remote")).devide("A","F")
        
2- The deployment way:
    
    This will resolve in Enterprise Applications > Devide_EJB > EJB JNDI names > Target Resource JNDI Name > JNDI name for all interfaces Value 
    picked up from ibm-ejb-jar-bnd.xml file. 
        <session name="MyDevideBean" simple-binding-name="nab/devideService"/>
        
    Still we can access the EJB via Remote / Local interface via below calls (Same name for remote/local with different prefix):
             ((DevideLocal)context.lookup("ejblocal:nab/devideService")).devide("A","D")
             ((DevideRemote)context.lookup("nab/devideService")).devide("A","F")
           
3- You should only use one of approaches.  