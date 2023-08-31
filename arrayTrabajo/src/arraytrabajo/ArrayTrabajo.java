/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraytrabajo;

//importaciones

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Urbano
 */
public class ArrayTrabajo {

    /**
     * @param args the command line arguments
     * Definimos la clase main
     */
    
    public static void main(String[] args) {
        // inicio del array
        
             Scanner scanner = new Scanner(System.in);
             //digita en la matriz
             
        ArrayList<ArrayList<Integer>> columna = new ArrayList<>();
        
        System.out.println("Bienvenido este es el algoritmo que crea una matriz 5x5 :) ");
        System.out.println("Ingrese los números para la matriz 5x5:");
        System.out.println("-----------------------------------------------------------");
//for para recorrer el array

        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            
            //se incrementa cada vez que mandamos un numero
            //definimos como int ya que son numeros enteros
            
            for (int j = 0; j < 5; j++) {
                System.out.print("Ingrese el elemento en la posición [" + i + "][" + j + "]: ");
                int numero = scanner.nextInt();
                
                //inicia por las filas 
                
                fila.add(numero);
            }
            //agregar un elemento a la matriz y las columnas
            
            columna.add(fila);
        }
//se verifica el tamaño de la matriz, utilizamos \n para salto de linea  

        System.out.println("\nMatriz ingresada:");
//recorre el array
        for (ArrayList<Integer> fila : columna) {
            
            for (int num : fila) {
                
                //concatenamos el numero
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int determinante = calcularDeterminante(columna);
        System.out.println("\nEl determinante de la matriz es: " + determinante);

        scanner.close();
    }
    
    //funcion 
    //size obtener un numero de elementos
    //get obtener un elemento especifico
    public static int calcularDeterminante(ArrayList<ArrayList<Integer>> matriz) {
        if (matriz.size() != 5 || matriz.get(0).size() != 5) {
            //mensaje de excepción
            throw new IllegalArgumentException("La matriz debe ser de tamaño 5x5");
        }
        //inicializamos el determinante 
        int det = 0;
        //se recorre cada fila de la matriz y se almacenan en la matriz del determinante
        for (int i = 0; i < 3; i++) {
            int diagonalPrincipal = 1;
            int diagonalSecundaria = 1;
            
            for (int j = 0; j < 3; j++) {
                //obtiene el elemento de cada una de las diagonales
                
                diagonalPrincipal *= matriz.get((i + j) % 5).get(j);
                diagonalSecundaria *= matriz.get((i + j) % 5).get(4 - j);
            }
            //agregar y designar 
            det += diagonalPrincipal - diagonalSecundaria;
        }
        //se retorna el valor del determinante
        return det;
    }
    
}
