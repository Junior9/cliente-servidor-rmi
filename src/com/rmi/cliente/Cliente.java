package com.rmi.cliente;

import java.rmi.ConnectException;
import java.rmi.Naming;
import com.rmi.servidor.Servidor;

public class Cliente {
  
  
  /* objeto "server" é o identificador que iremos
   * utilizar para fazer
   * referencia ao objeto remoto que será implementado
   */
  private static Servidor server;
  private static final String PORT = "1099";
  private static final String IP = "localhost";

  public static void main(String[] args) {
    
    // ip da máquina do servidor: 127.0.0.1
    String ipConfig = "//"+IP +":"+ PORT+"/";
    String retorno = null;

    try {
      /* - o lookup carrega o Servidor_Stub do CLASSPATH 127.0.0.1 - é o IP da máquina de onde o servidor está
       * rodando.
       * "Mensagem" é o nome que utilizamos para fazer referencia ao objeto no servidor.
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
