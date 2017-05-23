package com.rmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements ServidorRemote{

  /** TODO */
  private static final long serialVersionUID = 1L;

  protected Servidor() throws RemoteException {
    super();
  }
  
  @Override
  public String getMsg() {
    return "Conectado ao Servidor";
  }
}
