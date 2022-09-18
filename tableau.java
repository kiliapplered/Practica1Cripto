import java.util.LinkedList;
import java.util.List;

public class tableau {
    char[][] matriz;  // Matriz 5x5
    char[] abecedario;   // Abecedario con el que se llena
    char[] clave;        // Palabra clave que define su llenado

    public tableau(char[] abecedario, char[] clave){
        this.abecedario=abecedario;
        this.clave=clave;
        //Llenado del tableau
        llenadoTableau();
    }

    public void llenadoTableau(){
        List<Character> letrasUsadas = new LinkedList<>();
        int longClave=clave.length;
        matriz=new char[5][5];
        boolean bandera=false;
        int cont=0;

        //Llenado del tableau mediante ciclos for
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if((i*5)+j == longClave){
                    bandera=true;
                }
                if(bandera){
                    //Llenado del tableau con la palabra clave
                    while(true){
                        if(letrasUsadas.contains(abecedario[cont])){
                            cont++;
                        } else {
                            matriz[i][j]=abecedario[cont];
                            break;
                        }
                    }
                } else {
                    matriz[i][j]=clave[(i*5)+j];
                    
                }
                letrasUsadas.add(matriz[i][j]);
            }
        }
    }

    public String encriptarMensaje(String mensaje){
        mensaje=mensaje.replaceAll("\\s", "");
        char[] mensajeChar=mensaje.toCharArray();
        String mensajeEncriptado="";
        int[] filas=new int[mensajeChar.length*2];
        // Ciclo de encriptación del mensaje
        for(int i=0; i<mensajeChar.length; i++){
            //Se hará la búsqueda de las coordenadas dentro del tableu
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(matriz[j][k]==mensajeChar[i]){
                        filas[i]=j;
                        filas[mensajeChar.length+i]=k;
                        break;
                    }
                }
            }
        }
        //Una vez que tenemos las filas, se genera el mensaje encriptado
        for(int i=0; i<filas.length; i+=2){
            mensajeEncriptado+=matriz[filas[i]][filas[i+1]];
        }
        return mensajeEncriptado;
    }

    public String desencriptarMensaje(String mensaje){
        mensaje=mensaje.replaceAll("\\s", "");
        char[] mensajeChar=mensaje.toCharArray();
        String mensajeDesencriptado="";
        int[] filas=new int[mensajeChar.length*2];
        // Ciclo de desencriptación del mensaje
        for(int i=0; i<mensajeChar.length*2; i+=2){
            //Se hará la búsqueda de las coordenadas dentro del tableu
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(matriz[j][k]==mensajeChar[i/2]){
                        filas[i]=j;
                        filas[1+i]=k;
                        break;
                    }
                }
            }
        }
        //Una vez que tenemos las filas, se genera el mensaje encriptado
        for(int i=0; i<filas.length/2; i++){
            mensajeDesencriptado+=matriz[filas[i]][filas[(filas.length/2)+i]];
        }
        return mensajeDesencriptado;
    }

}
