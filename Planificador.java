public class Planificador{
	ColaMemoria memoria = new ColaMemoria();
	ProcesosListos colaprocesoslistos = new ProcesosListos();
	ProcesosListos procesosm= new ProcesosListos();
	Ordenamientos  or= new Ordenamientos();
	Prozess proccesTemp ;
	static int quamtun=5;
	int qrestante=0;
	int aux, tammemoria=100;
	int procAnt = 0;
	String idproceso;


	public void Llenar(int numpros){
		for (int i=1;i<= numpros ;i++ ) {
			Prozess p = new Prozess();
			p.CapturaDatos(i);
			do{
			idproceso =Teclado.LeeCadena("Ingrese el id del proceso "+p.GetNombre()+" : ");
				p.SetID(idproceso);
		    }while(colaprocesoslistos.ValidaId(idproceso));
			colaprocesoslistos.Insertar(p);
		}
			
	}
     
     public void Proz1(){
     	
     	
        while( colaprocesoslistos.ValidaVacio()  && ( (tammemoria - (colaprocesoslistos.GetH().GetInfo().GetTam()))> 0 )  ){
     	         proccesTemp=colaprocesoslistos.Borrar().GetInfo();
                 tammemoria= tammemoria- proccesTemp.GetTam();
                 System.out.println("Subio a memoria el proceso: "+proccesTemp.GetNom()+" Y restan "+tammemoria+" unidades de memoria");
                 memoria.Insertar(proccesTemp);
             }

     }

    public void Proz2(){
    		    System.out.println("\n\n     MEMORIA ");
		  		memoria.Listar();
    		proccesTemp = memoria.Borrar();
    		procAnt++;
			if( (proccesTemp.GetRafaga() ) <= quamtun ){
			proccesTemp.SetAnt(procAnt);
			proccesTemp.ActualizAparcion();
			
			if( proccesTemp.GetApariciones() == 1)
				proccesTemp.Setesp(procAnt);
			System.out.println("\n\n     CPU   ");
			for (int i=proccesTemp.GetRafaga();i>0;i-- ) {
				System.out.println(proccesTemp.GetNombre()+" en ejecucion "+i+" [msg]");
			}

			proccesTemp.SetRafaga(0);
			procesosm.Insertar(proccesTemp);
			System.out.println("\nTermino "+proccesTemp.GetNombre()+" se libero "+proccesTemp.GetTam()+" de memoria");
			tammemoria=tammemoria+proccesTemp.GetTam();
			System.out.println("Memoria restante: "+tammemoria+"\n");
			}
			else{
				  System.out.println("\n\n     CPU   ");
				  int j=1;
			     for (int i=proccesTemp.GetRafaga();j<6;i-- ) {
				     System.out.println(proccesTemp.GetNombre()+" en ejecucion "+i+" [msg]");
			         j++;
			        }
			      qrestante = proccesTemp.GetRafaga() - quamtun;
			      proccesTemp.ActualizAparcion();
			
			if( proccesTemp.GetApariciones() == 1)
				proccesTemp.Setesp(procAnt);
			
		    proccesTemp.SetRafaga(qrestante);
		    colaprocesoslistos.Insertar(proccesTemp);
		    System.out.printf("\n\nBaja "+proccesTemp.GetNombre()+" de la memoria se libero "+proccesTemp.GetTam()+" unidades de memoria");
            tammemoria=tammemoria+proccesTemp.GetTam();
		    System.out.println("\nMemoria restante: "+tammemoria);
		}

    }
	public void  arranca(){

		Ordenamientos.Sortieren(colaprocesoslistos.GetH());
	
		do{
				System.out.println("\n\n-----------LISTA DE PROCESOS LISTOS-----------");
		  		colaprocesoslistos.Listar();
				System.out.println("\n---------------------------------------------");
			if (colaprocesoslistos.ValidaVacio()) {
				Proz1();
				if (memoria.ValidaVacio()) {
					Proz2();
				}
				//System.out.println("error");

				
			}else if (memoria.ValidaVacio()) {
						Proz2();				
			}
         else
         	System.out.println("no  ValidaVacio");
         		
		}while(colaprocesoslistos.ValidaVacio() || memoria.ValidaVacio());
	}
	
	
	public void Trespuesta(int numProc){
		float tiempoF,tiemposApa, tiempoResp = 0;
		
		for(int i=0; i<numProc; i++){
			Prozess proccesCuen = procesosm.Borrar().GetInfo();
			tiempoF=(proccesCuen.GetAnt() * 5) -5;
			tiemposApa= (proccesCuen.GetApariciones() - 1)*5;
			tiempoResp= (tiempoF - tiemposApa) + tiempoResp;
			procesosm.Insertar(proccesCuen);
		}
		
		tiempoResp= (tiempoResp/numProc);
		System.out.println("El tiempo de respuesta es :"+ tiempoResp);
	}
	
	public void Tejec(int numProc){
		float tiempoF, tiempoEjec = 0;
		
		for(int i=0; i<numProc; i++){
			Prozess proccesCuen = procesosm.Borrar().GetInfo();
			tiempoF=(proccesCuen.GetAnt() * 5);
			tiempoEjec= tiempoF + tiempoEjec;
			procesosm.Insertar(proccesCuen);
		}
		
		tiempoEjec= (tiempoEjec/numProc);
		System.out.println("El tiempo de ejecucion es :"+ tiempoEjec);
	}
	
	public void Tesper(int numProc){
		float  tiempoEsp = 0;
		
		for(int i=0; i<numProc; i++){
			Prozess proccesCuen = procesosm.Borrar().GetInfo();
			tiempoEsp= ((proccesCuen.Getesp() * 5) - 5) + tiempoEsp;
			procesosm.Insertar(proccesCuen);
		}
		
		tiempoEsp= (tiempoEsp/numProc);
		System.out.println("El tiempo de espera es :"+ tiempoEsp);
	}

}