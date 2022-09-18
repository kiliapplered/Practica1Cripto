import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Entrada de datos del usuario
        Scanner sc= new Scanner(System.in);
        //Palabra clave que permitirá el llenado del tableau
        char[] clave="ENCRYPT".toCharArray();
        //Abecedario modificado sin la J
        char[] abecedario=new char[]{'A','B','C','D','E','F','G','H','I',
            'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        //Tomando en cuenta el abecedario modificado y la palabra clave
        //Se inicia y se llena el tableau
        tableau matriz5x5=new tableau(abecedario, clave);

        String mensaje;

        System.out.println(" **********     Bifid Cipher     ********** ");
        System.out.println(" *****    Created by: Karla Najera    ***** ");

        int op=0;
        while(op!=3){
            System.out.println("\n Select an option: ");
            System.out.println("  1.-Encrypt ");
            System.out.println("  2.-Decrypt ");
            System.out.println("  3.-Exit \n ");
            
            op=sc.nextInt();
            sc.nextLine();

            System.out.println("");

            switch(op){
                case 1:
                    System.out.print("Message: ");
                    mensaje=sc.nextLine();
                    String mensajeEncriptado=matriz5x5.encriptarMensaje(mensaje);
                    System.out.println("Encrypted Message: "+mensajeEncriptado);
                    break;
                case 2:
                    System.out.print("Message: ");
                    mensaje=sc.nextLine();
                    String mensajeDesencriptado=matriz5x5.desencriptarMensaje(mensaje);
                    System.out.println("Decrypted Message: "+mensajeDesencriptado);
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Wrong option. Try again");
                    break;
            }
            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }
        sc.close();
    }
}
