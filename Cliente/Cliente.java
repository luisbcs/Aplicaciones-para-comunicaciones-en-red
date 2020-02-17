import java.net.*;
import java.io.*;
public class Cliente
{
        public String linea_entrada="";
        public int difi=0;
        public Socket s =null;
        public InputStreamReader in = null;
        public BufferedReader bf = null;
        public PrintWriter pr = null;
        
        public Cliente(String ip,int puerto) throws IOException
        {
         s = new Socket(ip,puerto);
         in = new InputStreamReader(s.getInputStream());
         pr = new PrintWriter(s.getOutputStream());
         bf = new BufferedReader(in);
        }
    
            public String GetDatos() throws IOException
        {
            //Metodo para recibir datos -> bf.readLine();
            String datos="";
            datos=bf.readLine();
            
            return  datos;
        }
        
        public void SendDatos(String datos)
        {
            //Metodo para enviar datos --> pr.println("");pr.flush();
            pr.println(""+datos);pr.flush();
        }
        
                public void Cerrar() throws  IOException
        {
             s.close();
        }

}