public class Planificador{
	ColaMemoria memoria;
	ProcesosListos colaProcesoslistos;

	public void Planificador(){
		memoria = new ColaMemoria();
		colaProcesoslistos= new ProcesosListos();

	}

	public void llenar(Prozess p){
			colaProcesoslistos.Insertar(p);
	}

	public void
}