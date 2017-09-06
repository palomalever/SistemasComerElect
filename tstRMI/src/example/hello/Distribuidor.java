/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;

import java.lang.reflect.Method;

/**
 *
 * @author RGGH
 */
public class Distribuidor 
{
    public static void main( String args[])
    {

        System.out.println("Distribuidor, inciando con:");
        if( args.length == 0)
            System.out.println("Sin argumentos");
        else
            for(int i = 0; i < args.length; i++)
                System.out.println("args[" + i + "]:" + args[i]);
        System.out.println("------------------------------------------");

        String[] argsPar = new String[0];
        
        if( args.length > 1 )
        {
           argsPar = new String[args.length-1];
           for(int i=1;i<args.length;i++)
             argsPar[i-1] = args[i];  
        }
        if( args.length == 0 ) 
        {
            System.out.println("uso:\n" + 
                               "Distribuidor Master  ip_host_localhost reset deltaTEnSegs\n" +
                               "Distribuidor Master  ip_host_localhost [reporta]\n"            +
                               "Distribuidor Cliente ip_host_localhost");
        } else {
            try {
                Class cArgs[] = new Class[1];
                cArgs[0] = String[].class;
                Class cl = Class.forName("example.hello." + args[0]);
                Method m = cl.getMethod("main", cArgs);
                m.invoke(cl, (Object) argsPar);
                System.out.println("Ok");
            } catch (Exception e) {
                //Logger.getLogger(TstMiClase.class.getName()).log(Level.SEVERE, null,"Class Not Found");
                System.out.println(e.getMessage());
            
        }
    }


    }
    
    
    
}
