
public class Lista{
	private Nodo H;
	private Nodo T;

	public void Insertar(Prozess dato){
		Nodo q= new Nodo (dato, null);
		if (T== null)
                    H=q;
		else
                    T.SetLigaDer(q);
		T=q;
	}

	public void Listar(){
            Nodo q;
            for (q= H; q!= null; q=q.GetLigaDer())
		System.out.println(q.GetInfo().imprimeProzess());
	}
        
        public String getProceso(){
            Nodo q = H;
            Prozess proceso = q.GetInfo();
            H = q.GetLigaDer();
            q = null;
            return info;
        }
        
        public Nodo getNodoH(){
            return H;
        }
}