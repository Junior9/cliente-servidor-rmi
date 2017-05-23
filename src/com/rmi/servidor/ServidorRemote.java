package com.rmi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorRemote extends Remote{
  
  public String getMsg() throws RemoteException;
}
