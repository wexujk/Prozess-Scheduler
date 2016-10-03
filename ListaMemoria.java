public class ColaMemoria
{
    private Prozess []cola;
    private int h;
    private int t;

    public ColaMemoria()
    {
        cola = new Prozess[100];
        h=t=-1;
    }

    public boolean ValidaEspacio()
    {
        return(t<cola.length-1);
    }

    public void Insertar(Prozess dato)
    {
        if (h==-1)
            h++;
            t++;
        cola[t]=Prozess;
    }

    public int Borrar()
    {
        int aux = cola[h];
        if(h==t)
            h=t=-1;
        else h++;
        return aux;
    }

    public boolean ValidaVacio()
    {
        return(h==-1);
    }

    /*public void Listar()
    {
        for(int i=h;i<=t;i++)
        {
            System.out.println(cola[i]);
        }
    }*/
}