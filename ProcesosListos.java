class ProcesosListos{

    private Nodo H,T;
    
    public void Insertar(Prozess dato){

            Nodo q= new Nodo(dato,null);
            if(T==  null)
                H=T=q;
            else{
                T.SetSig(q);
                T=q;
            }

    }

    public boolean ValidaVacio()
    {
        if(H==null)
            return false;
        return true;
    }

    public void Listar(){
        Nodo aux=H;

        /*while(aux!=null)
        {
            System.out.println(aux.GetInfo());
            aux=aux.GetSig();
        }*/

        for(aux=H;aux != null;aux=aux.GetSig())
        {
            aux.GetInfo().ListarL();
        }
    }

    
    /*public void Actualizar(Nodo q){
       Prozess aux;
       aux=q.GetInfo();
       aux.Actualizar();
            q.SetInfo(aux);

            //q.GetInfo().Actualizar();
    }
*/
    public Nodo Borrar()
    {
        Nodo actual;
        
                actual=H; //se guarda  la referencia de H
                if(H==T)//si solo  hay un nodo en la lista
                    H=T=null;
                else
                    H=H.GetSig();//ahora H hace referencia  al nodo siguient
        return actual;
    }

    public Nodo GetH(){
        return H;
    }
    public int GetTamPro(){
        return H.GetInfo().GetTam();
    }
    public boolean ValidaId(String id)
    {
        Nodo aux=H;
        while(aux!= null)
        {
            if(id.equals(aux.GetInfo().GetID())){
                System.out.println("El id se repite ingrese uno  diferente");
                return true;
            }
            aux=aux.GetSig();
        }

        return false;

    }
}