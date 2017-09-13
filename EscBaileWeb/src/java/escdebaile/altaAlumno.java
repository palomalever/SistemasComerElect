/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escdebaile;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sdist
 */
@WebService(serviceName = "altaAlumno")
public class altaAlumno {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "darAlta")
    public boolean darAlta(@WebParam(name = "clave") String clave, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellidoP") String apellidoP, @WebParam(name = "apellidoM") String apellidoM) {
                  ClsGestorEscBaile gestor = new ClsGestorEscBaile();
                  gestor.conectaBD("rafa","rafa");
           if(gestor != null)
           {
              if( gestor.conectado() )
              {          

                   String[] arr_nomCampos = new String[4];
                   String[] arr_valCampos = new String[4];

                   arr_valCampos[0] = clave;
                   arr_valCampos[1] = nombre;
                   arr_valCampos[2] = apellidoP; //request.getParameter("strPrimerApellido");
                   arr_valCampos[3] = apellidoM; //request.getParameter("strSegundoApellido");

                   arr_nomCampos[0] = "clvAlumno";
                   arr_nomCampos[1] = "nombre";
                   arr_nomCampos[2] = "apPaterno";
                   arr_nomCampos[3] = "apMaterno";
                   
                   return gestor.altaAlumno(arr_nomCampos, arr_valCampos);
              }
           }
           
        return false;
    }
}
