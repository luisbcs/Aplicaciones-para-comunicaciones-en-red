import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjecutarCliente 
{
        public static void main(String[] args)
    {
            try {
                Scanner sc = new Scanner(System.in); //Se crea el lector
                String ip =null;
                String puerto=null;
                String dificultad=null;
                int dif=0;
                int jugada=0;
                String input="";
                
                //Pedir ip y puerto
                System.out.print("Ingresa la ip o host -> ");ip=sc.nextLine();
                System.out.print("Ingresa el puerto -> ");puerto=sc.nextLine();
                
                Cliente cliente = new Cliente(ip,Integer.parseInt(puerto));
                //Pedir dificultad para generar tablero
                System.out.println("Selecciona la dificultad:");
                System.out.println("1- Facil");
                System.out.println("2- Avanzado");
                System.out.print("--> ");dificultad=sc.nextLine();
                
                if("1".equals(dificultad))dif=9;
                else if ("2".equals(dificultad))dif=25;
                
                LogicaGatoCliente gato = new LogicaGatoCliente(dif);
                
                if(dif==9){dif=dif/3;}
                if(dif==25){dif=dif/5;}
                System.out.println("Se genero un tablero de: "+dif+"x"+dif);
                dif=dif*dif;
                cliente.SendDatos(""+dif);
                /*
                El tablero se ha generado con exito en el cliente y servidor
                */
                
                while (true)
                {
                    if(dif==9){gato.ImpirmirT3x3();}if(dif==25){gato.Imprimirt5x5();}
                    do {
                        System.out.println("¿Donde vas a tirar? ->");input=sc.nextLine();
                    } while (gato.Buscar(Integer.parseInt(input)));
                    gato.setJugada(Integer.parseInt(input));
                    cliente.SendDatos(input);
                    input=cliente.GetDatos();
                    if(input.equals("100")){if(dif==9){gato.ImpirmirT3x3();}if(dif==25){gato.Imprimirt5x5();}System.out.println("Ganaste!");break;}
                    else if(input.equals("99")){if(dif==9){gato.ImpirmirT3x3();}if(dif==25){gato.Imprimirt5x5();}System.out.println("Perdiste :c");break;}
                    else if(input.equals("98")){if(dif==9){gato.ImpirmirT3x3();}if(dif==25){gato.Imprimirt5x5();}System.out.println("Empate!");break;}
                    else gato.setJugadaServidor(Integer.parseInt(input));
                }
                cliente.Cerrar();
            } catch (IOException ex) {
                Logger.getLogger(EjecutarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
