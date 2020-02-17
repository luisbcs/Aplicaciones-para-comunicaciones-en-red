import java.net.*;
import java.io.*;

public class Servidor
{
                public ServerSocket ss = null;
                public Socket s;
                public InputStreamReader in = null;
                public BufferedReader bf = null;
                public PrintWriter pr = null;
                public String linea_entrada="";
                
        public Servidor(int puerto) throws IOException
        {
                 ss = new ServerSocket(puerto);
        }
        
        public void Escuchar() throws IOException
        {
         s = ss.accept();
         in = new InputStreamReader(s.getInputStream());
         pr = new PrintWriter(s.getOutputStream());
         bf = new BufferedReader(in);
        }
        
        public void Cerrar() throws  IOException
        {
             ss.close();;
             s.close();
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
}