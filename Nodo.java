
class Nodo{
	private Prozess info;
	private Nodo sig;
   
	public Nodo(Prozess info, Nodo sig){
			this.info=info;
			this.sig=sig;
	}

	public void SetInfo(Prozess dato)
	{
		info = dato;
	}

	public void SetSig(Nodo sig)
	{
		this.sig=sig;
	}

	public Prozess GetInfo()
	{
		return info;
	}

	public Nodo GetSig()
	{
		return sig;
	}
}