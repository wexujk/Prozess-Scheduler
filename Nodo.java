

public class Nodo{
	private Prozess info;
	private Nodo ligaDer;

	//Constructor
	public Nodo(Prozess dato, Nodo ld){
		info= dato;
		ligaDer= ld;
	}

	//Metodos
	public void SetInfo(Prozess dato){
		info= dato;
	}

	public void SetLigaDer(Nodo ld){
		ligaDer= ld;
	}

	public String GetInfo(){
		return info;
	}

	public Nodo GetLigaDer(){
		return ligaDer;
	}
}