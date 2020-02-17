public class LogicaGatoServer 
{
     
     public String tablero[];
    
    public LogicaGatoServer(int n)
    {
        tablero=new String[n];
    }    
    public void setJugada(int n)
    {
     this.tablero[n-1]="O";
    }
    
    public void setJugadaCliente(int n)
    {
     this.tablero[n-1]="X";
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
    
    public int Full()
    {
        int c=0;
        for(int i=0;i<this.tablero.length;i++)
        {
            if(this.tablero[i]!=null){c=c+1;} 
        }
        return c;
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
    
    public Boolean Win3x3s(String t[])
    {
    if("O".equals(t[0])&&"O".equals(t[1])&&"O".equals(t[2]))return true;
        else if("O".equals(t[3])&&"O".equals(t[4])&&"O".equals(t[5]))return true;
            else if("O".equals(t[6])&&"O".equals(t[7])&&"O".equals(t[8]))return true;
                else if("O".equals(t[0])&&"O".equals(t[3])&&"O".equals(t[6]))return true; 
                    else if("O".equals(t[1])&&"O".equals(t[4])&&"O".equals(t[7]))return true;
                         else if("O".equals(t[2])&&"O".equals(t[5])&&"O".equals(t[8]))return true;
                              else if("O".equals(t[0])&&"O".equals(t[4])&&"O".equals(t[8]))return true;
                                   else if("O".equals(t[2])&&"O".equals(t[4])&&"O".equals(t[6]))return true;
                                        else return false;
    }
    
        public Boolean Win5x5s(String t[])
    {    
    if("O".equals(t[0])&&"O".equals(t[1])&&"O".equals(t[2])&&"O".equals(t[3])&&"O".equals(t[4]))return true;
        else if("O".equals(t[5])&&"O".equals(t[6])&&"O".equals(t[7])&&"O".equals(t[8])&&"O".equals(t[9]))return true;
             else if("O".equals(t[10])&&"O".equals(t[11])&&"O".equals(t[12])&&"O".equals(t[13])&&"O".equals(t[14]))return true;
                  else if("O".equals(t[15])&&"O".equals(t[16])&&"O".equals(t[17])&&"O".equals(t[18])&&"O".equals(t[19]))return true;
                       else if("O".equals(t[20])&&"O".equals(t[21])&&"O".equals(t[22])&&"O".equals(t[23])&&"O".equals(t[24]))return true;
                            else if("O".equals(t[0])&&"O".equals(t[5])&&"O".equals(t[10])&&"O".equals(t[15])&&"O".equals(t[20]))return true;
                                 else if("O".equals(t[1])&&"O".equals(t[6])&&"O".equals(t[11])&&"O".equals(t[16])&&"O".equals(t[21]))return true;
                                      else if("O".equals(t[2])&&"O".equals(t[7])&&"O".equals(t[12])&&"O".equals(t[17])&&"O".equals(t[22]))return true;
                                           else if("O".equals(t[3])&&"O".equals(t[8])&&"O".equals(t[13])&&"O".equals(t[18])&&"O".equals(t[34]))return true;
                                                else if("O".equals(t[4])&&"O".equals(t[9])&&"O".equals(t[14])&&"O".equals(t[19])&&"O".equals(t[24]))return true;
                                                     else if("O".equals(t[0])&&"O".equals(t[6])&&"O".equals(t[12])&&"O".equals(t[18])&&"O".equals(t[24]))return true;
                                                           else if("O".equals(t[4])&&"O".equals(t[8])&&"O".equals(t[12])&&"O".equals(t[16])&&"O".equals(t[20]))return true;
                                                                else return false;
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
   }
}