package com.rmi.servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
  
  
  public static void main(String[] args) {
    int port = 1099; //n�mero-padr�o da porta para o rmiregistry,
     
    //propriedade de privil�gios de acesso ao servidor.
    System.setProperty("java.security.policy", "policy");
    
    try {
      //registra a porta
      LocateRegistry.createRegistry( port );
    } catch ( Exception e1 ) {   }
    
    //Cria��o do gerenciador de seguran�a (Security Manager)
    if ( System.getSecurityManager() == null )
     System.setSecurityManager(new SecurityManager());

    try {

      // aqui criamos o objeto que sera acessado
      // remotamente
      Servidor servidor = new Servidor();
      Registry registry = LocateRegistry.getRegistry( port );

      // aqui registramos o objeto 'servidor' como 'name'
      // no servidor
      registry.rebind("servidorRmi",servidor);

      System.out.println( " Servidor RMI Rodando... ");

      } catch (Exception e) {

      System.err.println("exce��o RMI:");
      e.printStackTrace();

      }
  }

}
