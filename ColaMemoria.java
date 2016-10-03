
public class ProcesosListos{
	private Nodo H;
	private Nodo T;

	public void Insertar(Prozess dato){
		Nodo q= new Nodo (dato, null);
		if (T== null)
                    H=q;
		else
                    T.SetSig(q);
		T=q;
	}

	public void Listar(){
            Nodo q;
            for (q= H; q!= null; q=q.GetSig())
		System.out.println(q.GetInfo().imprimeProzess());
	}
        
        public String getProceso(){
            Nodo q = H;
            Prozess proceso = q.GetInfo();
            H = q.GetSig();
            q = null;
            return info;
        }
        
        public Nodo getNodoH(){
            return H;
        }
        public Nodo Borrar(){
            Nodo actual;
            actual=H; //se guarda  la referencia de H

                if(H==T)//si solo  hay un nodo en la lista
                    H=T=null;
                else
                    H=H.GetSig();
        return actual;

        }


}