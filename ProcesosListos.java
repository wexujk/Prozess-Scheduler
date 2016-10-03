class ProcesosListos{

    private Nodo H,T;
    private boolean existe;
   
   
   
    
    public void InsertaAlFinal(EmpleadoCorto dato){

            Nodo q= new Nodo(dato,null);
            if(T==  null)
                H=T=q;
            else{
                T.SetSig(q);
                T=q;
            }

    }

    public void InsertaAlPrincipio(EmpleadoCorto dato){

            Nodo q= new Nodo(dato,H);
            if(H==null)
                T=q;
            H=q;
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
            aux.GetInfo().Listar();
        }
    }

    public void InsertaDespues(Nodo anterior, EmpleadoCorto dato){
        Nodo q;
        if(anterior== T)
            InsertaAlFinal(dato);
        else{
            q=new Nodo(dato,anterior.GetSig());
            anterior.SetSig(q);
        }
    }
    public void InsertaAntes(Nodo anterior, EmpleadoCorto dato){
        Nodo q;
        if(anterior==null)
            InsertaAlPrincipio(dato);
        else
        {
            q=new Nodo(dato,anterior.GetSig());
            anterior.SetSig(q);
        }
    }//Buscar se manda a llamar desde el main
    public void Actualizar(Nodo q){
       EmpleadoCorto aux;
       aux=q.GetInfo();
       aux.Actualizar();
            q.SetInfo(aux);

            //q.GetInfo().Actualizar();
    }

    public Nodo Borrar(int clave)
    {
        Nodo actual;
        
                actual=H; //se guarda  la referencia de H
                if(H==T)//si solo  hay un nodo en la lista
                    H=T=null;
                else
                    H=H.GetSig();//ahora H hace referencia  al nodo siguient
        return actual;
    }

    public boolean GetExiste()
    {
        return existe;
    }
   
   public Nodo GetH(){
   return H;
   }

}