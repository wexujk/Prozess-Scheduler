public class Planificador{
	ColaMemoria memoria = new ColaMemoria();
	ProcesosListos colaprocesoslistos = new ProcesosListos();
	ProcesosListos procesosm= new ProcesosListos();
	Ordenamientos  or= new Ordenamientos();
	Prozess proccesTemp ;
	static int quamtun=5;
	int qrestante=0;
	int aux, tammemoria=100;


	public void Llenar(int numpros){
		for (int i=1;i<= numpros ;i++ ) {
			Prozess p = new Prozess();
			p.CapturaDatos(i);
			colaprocesoslistos.Insertar(p);
		}
			
	}
     
	public void  arranca(){

		or.Sortieren(colaprocesoslistos.GetH());
		do{
			colaprocesoslistos.Listar();
			int aux =colaprocesoslistos.GetH().GetInfo().GetTam();
     while((tammemoria - aux)> 0){
     	proccesTemp=colaprocesoslistos.Borrar().GetInfo();
     tammemoria= tammemoria- proccesTemp.GetTam();
     memoria.Insertar(proccesTemp);
          }

		
				proccesTemp = memoria.Borrar();
			if( (proccesTemp.GetRafaga() ) < quamtun ){
			proccesTemp.ActualizAparcion();
			proccesTemp.SetRafaga(0);
			System.out.println("Termino el procesos " );
			proccesTemp.Listar();
			procesosm.Insertar(proccesTemp);
			}
			else{
			qrestante = proccesTemp.GetRafaga() - quamtun;
			proccesTemp.ActualizAparcion();
		    proccesTemp.SetRafaga(qrestante);
		    colaprocesoslistos.Insertar(proccesTemp);
		    System.out.println("Baja proceso "+proccesTemp.GetNombre()+" de la memoria se libero "+proccesTemp.GetTam()+" unidades de memoria");
		    tammemoria=tammemoria+proccesTemp.GetTam();
		}

			}while(colaprocesoslistos.GetH()!= null);	
	}
}