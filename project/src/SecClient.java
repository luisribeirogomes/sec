import java.rmi.*;import java.rmi.server.*;import java.lang.SecurityManager;import java.lang.System;public class SecClient {    public static void main(String args[]) { 		if(System.getSecurityManager() == null) {        	System.setSecurityManager(new SecurityManager());        } else System.out.println("Already has a security manager, so cant set RMI SM");        BlockServer blockServer = null;        try {            blockServer  = (BlockServer) Naming.lookup("//localhost/BlockServer"); 			System.out.println("Found server");            byte[] aux = new byte[2];            aux[0] = (byte) 0;            aux[1] = (byte) 0;            blockServer.get(0);            blockServer.put_k(aux, aux, aux);            blockServer.put_h(aux);        } catch(RemoteException e) {            System.out.println("blockServer: " + e.getMessage());	    } catch(Exception e) {            System.out.println("Lookup: " + e.getMessage());        }    }}