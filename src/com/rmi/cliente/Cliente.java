package com.rmi.cliente;

import java.rmi.ConnectException;
import java.rmi.Naming;
import com.rmi.servidor.Servidor;

public class Cliente {
  
  
  /* objeto "server" � o identificador que iremos
   * utilizar para fazer
   * referencia ao objeto remoto que ser� implementado
   */
  private static Servidor server;
  private static final String PORT = "1099";
  private static final String IP = "localhost";

  public static void main(String[] args) {
    
    // ip da m�quina do servidor: 127.0.0.1
    String ipConfig = "//"+IP +":"+ PORT+"/";
    String retorno = null;

    try {
      /* - o lookup carrega o Servidor_Stub do CLASSPATH 127.0.0.1 - � o IP da m�quina de onde o servidor est�
       * rodando.
       * "Mensagem" � o nome que utilizamos para fazer referencia ao objeto no servidor.
       */
      // aqui instanciamos o objeto remoto
      //server = (Servidor) Naming.lookup(ipConfig +"servidorRmi");
      server = (Servidor) Naming.lookup("//" + IP + ":1099/servidorRmi");
      
      // agora executamos o metodo "mostraMensagem" no
      // objeto remoto
      retorno = server.getMsg();
      System.out.println(retorno);
      } catch (ConnectException e) {
      System.out.println("ERRO:Servidor Desconectado: " + e.getMessage());
      } catch (Exception e) {
      System.out.println("Erro Interno: " + e.getMessage());
      }
  }
  
  
}
