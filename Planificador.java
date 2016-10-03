public class Planificador{
	ColaMemoria memoria;
	ProcesosListos colaprocesoslistos;
	Ordenamientos  or;

	public void Planificador(){
		memoria = new ColaMemoria();
		colaProcesoslistos= new ProcesosListos();
		or= new Ordenamientos();

	}

	public void llenar(Prozess p){
			colaprocesoslistos.Insertar(p);
	}

	public void Run(){

		or.Sortieren(colaprocesoslistos.GetH());
		do{
			
		}
	}
}