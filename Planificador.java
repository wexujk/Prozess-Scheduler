public class Planificador{
	ColaMemoria memoria = new ColaMemoria();
	ProcesosListos colaprocesoslistos = new ProcesosListos();
	Ordenamientos  or= new Ordenamientos();


	public void Llenar(int numpros){
		for (int i=1;i<= numpros ;i++ ) {
			Prozess p = new Prozess();
			p.CapturaDatos(i);
			colaprocesoslistos.Insertar(p);
		}
			
	}

	public void Run(){

		or.Sortieren(colaprocesoslistos.GetH());
		colaprocesoslistos.Listar();
		
	}
}