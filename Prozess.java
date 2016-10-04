public class Prozess
{
	private  String idproceso, nomproceso;
	private  int tamproceso,zeit_ex_proceso,vorzug, ankommenzeit=0;
	
	//private  Random  r = new Rsandom();
	

	public void CapturaDatos(int np)
	{
		System.out.println("------------ PROCESO "+np+" ------------");
		nomproceso=Teclado.LeeCadena("Ingrese el nombre del proceso : ");
		idproceso =Teclado.LeeCadena("Ingrese el id del proceso"+nomproceso+" : ");
		do{
			tamproceso=Teclado.LeeEntero("Ingrese el tamaño del proceso "+nomproceso+" : ");
		}while(Valida_Tamproceso());
		do{
			zeit_ex_proceso=Teclado.LeeEntero("Ingrese el tiempo de ejecucion: ");
		}while(ValidaTiempoejecucion());
		do{
			vorzug=Teclado.LeeEntero("Ingrese la prioridad del proceso "+nomproceso+" : ");
		}while(ValidaPrioridad());
		
	}

//Métodos de validaciones para  los datos  ingresados ingresados
	
	public boolean Valida_Tamproceso()
	{
			if(tamproceso < 0 ){
            	System.out.println("EL tamaño minimo es 0 MB  =/  ingrese un nuevo  tamaño ");
            			return true;
            		}
            	else	if (tamproceso > 100) {
            			System.out.println("El tamaño sobrepasa la capacidad maxima de 100 MB ");
            			System.out.println("Ingrese un  nuevo tamaño ");
            			return true;	
            		}
          return false;
    }
    public boolean ValidaTiempoejecucion()
	{
			if(zeit_ex_proceso < 1 ){
            	System.out.println("EL tiempo minimo es 1 mseg  =/  ingrese un nuevo  tiempo ");
            			return true;
            		}
   
          return false;
    }
    public boolean ValidaPrioridad()
	{
			if(vorzug < 0){
            	System.out.println("Error en prioridad, ingrese una prioridad del 0 a 5.  ");
            			return true;
            		}

            if(vorzug > 5){
            	System.out.println("Error en prioridad, ingrese una prioridad del 0 a 5.  ");
            			return true;
            }
   
          return false;
    }

    public void Listar(){

    	System.out.println("Proceso: "+ nomproceso);
    	System.out.println("ID: "+idproceso);
    	System.out.println("Tamaño :"+tamproceso);
    	System.out.println("Tiempo que requiere para  su ejcucion: "+zeit_ex_proceso+" [mseg]");
    	System.out.println("Prioridad: "+ vorzug);
    }

    

	public int GetPrioridad(){
		return vorzug;
	}

	public int GetRafaga(){
		return zeit_ex_proceso;
	}


    }

