import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.TypeCodePackage.BadKind;

public class EjecutarServidor 
{
        public static void main(String[] args)
        {
            try {
                Scanner sc = new Scanner(System.in); //Se crea el lector
                String puerto =null;
                String dificultad="";
                int dif=0;
                int jugada=0;
                String input="";
                
                System.out.print("Ingresa el puerto donde va a correr el servidor-> ");puerto=sc.nextLine();
                
                Servidor servidor = new Servidor(Integer.parseInt(puerto));
                System.out.println("Servidor en el puerto: "+puerto);
                System.out.println("Esperando jugadores!!!!");
                
                servidor.Escuchar();
                System.out.println("Jugador conectado!");
                /*
                Cliente envia el tamaño del tablero
                */
                servidor.linea_entrada=servidor.GetDatos();
                dificultad=servidor.linea_entrada;
                dif=Integer.parseInt(dificultad);
                LogicaGatoServer gato = new LogicaGatoServer(dif);
                if(dif==9){dif=dif/3;}
                if(dif==25){dif=dif/5;}
                System.out.println("Se genero un tablero de: "+dif+"x"+dif);
                dif=dif*dif;
                /*
                El tablero se ha generado con exito
                */
                while (true)
                {
                    input = servidor.GetDatos();
                    if((gato.Full()==8 && dif==9)|| (gato.Full()==24 && dif==25 ))
                    {servidor.SendDatos("98");break;} 
                    else
                    {
                        gato.setJugadaCliente(Integer.parseInt(input));
                        /*
                        Se valida si le cliente gano
                        */
                        
                        if(dif==9)
                        {
                            if(gato.Win3x3(gato.tablero))
                            {
                                System.out.println("El cliente gano");
                                servidor.SendDatos("100");
                                break;
                                //servidor.Cerrar();
                            }
                        }
                        
                        if(dif==25)
                        {
                            if(gato.Win5x5(gato.tablero))
                            {
                                System.out.println("El cliente gano");
                                servidor.SendDatos("100");
                                break;
                                //servidor.Cerrar();
                            }
                        }
                        
                        /*
                        */
                        
                        jugada=gato.GenerarTirada(dif);
                        /*
                        Checamos si gano el servidor
                        */
                        
                        if(dif==9)
                        {
                            if(gato.Win3x3s(gato.tablero))
                            {
                                System.out.println("El servidor gano");
                                servidor.SendDatos("99");
                                break;
                                //servidor.Cerrar();
                            }
                        }
                        
                        if(dif==25)
                        {
                            if(gato.Win5x5s(gato.tablero))
                            {
                                System.out.println("El servidor gano");
                                servidor.SendDatos("99");break;
                                //servidor.Cerrar();
                            }
                        }
                        
                        servidor.SendDatos(""+jugada);
                    }
                }
                servidor.Cerrar();
            } catch (IOException ex) {
                Logger.getLogger(EjecutarServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}
