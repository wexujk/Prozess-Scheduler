public class Planificador1{
	ColaMemoria memoria;
	ProcesosListos colaprocesoslistos;
	Ordenamientos  or;
	int quantum = 5;
	
	public void Planificador(){
		memoria = new ColaMemoria();
		colaProcesoslistos= new ProcesosListos();
		or= new Ordenamientos();

	}

	public void llenar(Prozess p){
			colaprocesoslistos.Insertar(p);
	}

	public void Spiel(){
		int qRest = 0;
		int quaResp=0;
		
		Prozess proccesTemp = ProcesosListos.Borrar();
		if( (proccesTemp.getRafaga() ) < quamtun ){
			qrestante = -1*( (ProccesTemp.getrafaga() ) - quamtun );
			System.out.println("Termino el procesos "+ proccesTemp.listar);
		    proccesTemp = ProcesosListos.Borrar();
		    quanResp = proccesTemp.getRafaga - qRest;
		    proccesTemp.Actualizar(quanResp);
		    
		    if ( proccesTemp.GetRafaga() <= 0)
				System.out.println("Termino el procesos "+ proccesTemp.listar());
		    	
		    else
		    	ProcesosListo.Insertar(proccesTemp);
		}
		else{
		    quaResp = proccesTemp.getRafaga() - quamtun;
		    proccesTemp.Actualizar(quanResp);
		    ProcesosListo.Insertar(proccesTemp);
		}
	}
}