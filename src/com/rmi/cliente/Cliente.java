package com.rmi.cliente;

import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.Remote;
import com.rmi.servidor.ServidorRemote; 

public class Cliente {
  
  
  /* objeto "server" é o identificador que iremos
   * utilizar para fazer
   * referencia ao objeto remoto que será implementado
   */
  private static ServidorRemote serverRmi;
  private static final String PORT = "1099";
  private static final String IP = "localhost";

  public static void main(String[] args) {
    
    String retorno = null;

    try {
      System.setProperty("java.security.policy","policy");
      
      /* lookup carrega o Servidor_Stub do CLASSPATH 127.0.0.1 - é o IP da máquina de onde o servidor está  rodando.
       * "Mensagem" é o nome que utilizamos para fazer referencia ao objeto no servidor.
       */
      // aqui instanciamos o objeto remoto
      Remote reference =  Naming.lookup("//"+IP+":"+PORT+"/servidorRmi");
      serverRmi = (ServidorRemote) reference;
     
      // agora executamos o metodo "mostraMensagem" no
      // objeto remoto
      retorno = serverRmi.getMsg();
      
      System.out.println(retorno);
      } catch (ConnectException e) {
      System.out.println("ERRO:Servidor Desconectado: " + e.getMessage());
      } catch (Exception e) {
      System.out.println("Erro Interno: " + e.getMessage());
      }
  }
}
