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
     
     public void Proz1(){
     	int aux =colaprocesoslistos.GetH().GetInfo().GetTam();
        while(((tammemoria - aux)> 0) && (colaprocesoslistos.ValidaVacio())){
     	         proccesTemp=colaprocesoslistos.Borrar().GetInfo();
                 tammemoria= tammemoria- proccesTemp.GetTam();
                 memoria.Insertar(proccesTemp);
             }

     }

    public void Proz2(){
    		proccesTemp = memoria.Borrar();
			if( (proccesTemp.GetRafaga() ) <= quamtun ){
			proccesTemp.ActualizAparcion();
			proccesTemp.SetRafaga(0);
			System.out.printf("Termino el proceso "+proccesTemp.GetNom() );
			//proccesTemp.ListarL();
			procesosm.Insertar(proccesTemp);
			}
			else{
			qrestante = proccesTemp.GetRafaga() - quamtun;
			proccesTemp.ActualizAparcion();
		    proccesTemp.SetRafaga(qrestante);
		    colaprocesoslistos.Insertar(proccesTemp);
		    System.out.printf("Baja proceso "+proccesTemp.GetNombre()+" de la memoria se libero "+proccesTemp.GetTam()+" unidades de memoria");
            tammemoria=tammemoria+proccesTemp.GetTam();
		    System.out.println(" memoria restante: "+tammemoria);
		}

    }
	public void  arranca(){

		or.Sortieren(colaprocesoslistos.GetH());
		System.out.println("------ COMIENZA ROUND ROBIN ------");
		colaprocesoslistos.Listar();
	
		do{

			if (colaprocesoslistos.ValidaVacio()) {
				Proz1();
				if (memoria.ValidaVacio()) {
					Proz2();
				}
				
			}else if (memoria.ValidaVacio()) {
						Proz2();				
			}
				
	}while(colaprocesoslistos.ValidaVacio() || memoria.ValidaVacio());
		}
}