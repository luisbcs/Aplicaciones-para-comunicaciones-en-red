public class LogicaGatoCliente
{
     
     public String tablero[];
    
    public LogicaGatoCliente(int n)
    {
        tablero=new String[n];
    }    
    public void setJugada(int n)
    {
     this.tablero[n-1]="X";
    }
    
    public void setJugadaServidor(int n)
    {
     this.tablero[n-1]="O";
    }
    
    public Boolean Buscar(int n)
    {
        if("X".equals(this.tablero[n-1]) || "O".equals(this.tablero[n-1]))return true;
        return false;
    }
    
    public int GenerarNumero(int n)
    {
        return (int) (Math.random() * ((n + 1) - 1)) + 1; 
    }
    
    public int GenerarTirada(int n)
    {
        int i;
        do
        {
        i=GenerarNumero(n);
        }
        while(Buscar(i));
        setJugada(i);
        return i;
    }
    
    public Boolean Win3x3(String t[])
    {
    if("X".equals(t[0])&&"X".equals(t[1])&&"X".equals(t[2]))return true;
        else if("X".equals(t[3])&&"X".equals(t[4])&&"X".equals(t[5]))return true;
            else if("X".equals(t[6])&&"X".equals(t[7])&&"X".equals(t[8]))return true;
                else if("X".equals(t[0])&&"X".equals(t[3])&&"X".equals(t[6]))return true; 
                    else if("X".equals(t[1])&&"X".equals(t[4])&&"X".equals(t[7]))return true;
                         else if("X".equals(t[2])&&"X".equals(t[5])&&"X".equals(t[8]))return true;
                              else if("X".equals(t[0])&&"X".equals(t[4])&&"X".equals(t[8]))return true;
                                   else if("X".equals(t[2])&&"X".equals(t[4])&&"X".equals(t[6]))return true;
                                        else return false;
    }
    
    public Boolean Win5x5(String t[])
    {    
    if("X".equals(t[0])&&"X".equals(t[1])&&"X".equals(t[2])&&"X".equals(t[3])&&"X".equals(t[4]))return true;
        else if("X".equals(t[5])&&"X".equals(t[6])&&"X".equals(t[7])&&"X".equals(t[8])&&"X".equals(t[9]))return true;
             else if("X".equals(t[10])&&"X".equals(t[11])&&"X".equals(t[12])&&"X".equals(t[13])&&"X".equals(t[14]))return true;
                  else if("X".equals(t[15])&&"X".equals(t[16])&&"X".equals(t[17])&&"X".equals(t[18])&&"X".equals(t[19]))return true;
                       else if("X".equals(t[20])&&"X".equals(t[21])&&"X".equals(t[22])&&"X".equals(t[23])&&"X".equals(t[24]))return true;
                            else if("X".equals(t[0])&&"X".equals(t[5])&&"X".equals(t[10])&&"X".equals(t[15])&&"X".equals(t[20]))return true;
                                 else if("X".equals(t[1])&&"X".equals(t[6])&&"X".equals(t[11])&&"X".equals(t[16])&&"X".equals(t[21]))return true;
                                      else if("X".equals(t[2])&&"X".equals(t[7])&&"X".equals(t[12])&&"X".equals(t[17])&&"X".equals(t[22]))return true;
                                           else if("X".equals(t[3])&&"X".equals(t[8])&&"X".equals(t[13])&&"X".equals(t[18])&&"X".equals(t[34]))return true;
                                                else if("X".equals(t[4])&&"X".equals(t[9])&&"X".equals(t[14])&&"X".equals(t[19])&&"X".equals(t[24]))return true;
                                                     else if("X".equals(t[0])&&"X".equals(t[6])&&"X".equals(t[12])&&"X".equals(t[18])&&"X".equals(t[24]))return true;
                                                           else if("X".equals(t[4])&&"X".equals(t[8])&&"X".equals(t[12])&&"X".equals(t[16])&&"X".equals(t[20]))return true;
                                                                else return false;
    }
    
   public void ImpirmirT3x3()
   {        System.out.println("");
            System.out.println(" #### Tablero ####");
            for(int i=0;i<tablero.length;i++)
            {
                if(i==3 || i==6){System.out.println("");}
                if(tablero[i]==null)System.out.print(" - ");
                else System.out.print(" "+tablero[i]+" ");
            }
            System.out.println("");
   }   
   
   public void Imprimirt5x5()
   {        System.out.println("");
            System.out.println(" #### Tablero ####");
            for(int i=0;i<tablero.length;i++)
            {
                if(i==5 || i==10 || i==15 || i==20){System.out.println("");}
                if(tablero[i]==null)System.out.print(" - ");
                else System.out.print(" "+tablero[i]+" ");
            }
            System.out.println("");
   }
}