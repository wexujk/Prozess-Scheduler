public class Prozess
{
	private  String idproceso, nomproceso;
	private  int tamproceso,zeit_ex_proceso,vorzug, ankommenzeit=0;
	
	//private  Random  r = new Random();

	public void CapturaDatos()
	{
		nomproceso=Teclado.LeeCadena("Ingrese el nombre del proceso : ");
		idproceso =Teclado.LeeCadena("Ingrese el id del proceso"+nomproceso+" : ");
		tamproceso=Teclado.LeeEntero("Ingrese el tamaño del proceso "+nomproceso+" : ");
		vorzug=Teclado.LeeEntero("Ingrese la prioridad del proceso "+nomproceso+" : ");
	}

//Métodos de validaciones para  los datos  ingresados ingresados
	
	public boolean Valida_Tamproceso()
	{
			if(tamproceso < 0 ){
            	System.out.println("EL tamaño minimo es 0 MB  =/  ingrese un nuevo  tamaño ");
            			return true;
            		}
            	else	if (tamproceso > 1000) {
            			System.out.println("El tamaño sobrepasa la capacidad maxima de 1000 MB ");
            			System.out.println("Ingrese un  nuevo tamaño ");
            			return true;	
            		}
          return false;
    }

    public boolean imprimeProzess(){
    	System.out.println("Proceso: "+ nomproceso);
    	System.out.println("ID: "+idproceso);
    	System.out.println("Tamaño :"+tamproceso);
    	System.out.println("Tiempo que requiere para  su ejcucion: "+zeit_ex_proceso+" [mseg]");
    	System.out.println("Prioridad: "+ vorzug);
    }

		
	}

