/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon Hernandez Solis
 */
public class Modulos{
    //Atributos
    //Datos
    List name = new ArrayList();
    List secondName = new ArrayList();
    List nCuenta = new ArrayList();
    List edad = new ArrayList();
    //Direcciones
    List street = new ArrayList();
    List zipCode = new ArrayList();
    List colonia = new ArrayList();
    List municipio = new ArrayList();
    //Academico
    List creditosMat = new ArrayList();
    List numeroMat = new ArrayList();
    List nombreMat = new ArrayList();
    //Constructores
    public Modulos() {
    }
    
    //Metodos
    //Crear listas con bases de datos
    public void listaNombres(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Nombres.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                name.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listaApellidos(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Apellidos.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                secondName.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void numeroDeCuenta(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("NumeroDeCuenta.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                nCuenta.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Direcciones
    public void listaCalles(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Calles.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                street.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listaCP(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("CodigoPostal.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                zipCode.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listaColonia(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Colonia.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                colonia.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void listaMunicipio(){
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Municipio.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                municipio.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Crear documento de 500 direecciones aleatorias
    public void baseDeDirecciones(){
        Random rand = new Random();
        try {
            FileWriter fw = new FileWriter("Direcciones.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            for (int i=0; i<500; i++){
                int a1 = rand.nextInt(street.size()-1);
                int a2 = rand.nextInt(1,99);
                int a3 = rand.nextInt(zipCode.size()-1);
                salida.println((String)street.get(a1)+" #"+a2+", "+(String)colonia.get(a3)+", "+(String)municipio.get(a3)+", "+(String)zipCode.get(a3)+", Ciudad de México, México");
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Crear documento de 500 nombres aleatorios
    public void baseDeDatos(){
        Random rand = new Random();
        try {
            FileWriter fw = new FileWriter("BaseDeDatos.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            for (int i=0; i<500; i++){
                int a1 = rand.nextInt(name.size()-1);
                int a2 = rand.nextInt(secondName.size()-1);
                int a3 = rand.nextInt(secondName.size()-1);
                int a4 = rand.nextInt(18,27);
                //Guardar edad en lista para los registros academicos
                edad.add(a4);
                salida.println((String)nCuenta.get(i)+","+(String)name.get(a1)+","+(String)secondName.get(a2)+","+(String)secondName.get(a3)+","+a4);
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Registros Academicos
    public void leerRegistros(){
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        try {
            br = new BufferedReader(new FileReader("Materias.csv"));
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(",");
                //Guardar Datos
                numeroMat.add(datos[0]);
                nombreMat.add(datos[1]);
                creditosMat.add(datos[2]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            }
        }
    }
    //Crear documento de 500 registros academicos aleatorios
    public void regAcademicos(){
        Random rand = new Random();
        try {
            FileWriter fw = new FileWriter("RegistrosAcademicos.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            for (int i=0; i<500; i++){
                int age = (int) edad.get(i);
                if(age == 18){
                    int a1 = 5;  //Cuantas materias tiene aprobadas
                    int registro[] = new int[a1];
                    for (int j = 0; j < a1; j++) {
                        registro[j] = j+1;
                    }
                    //Guardar informacion en csv con comas
                    String temp = Arrays.toString(registro);
                    temp = temp.replace("[","");
                    temp = temp.replace("]","");
                    salida.println(temp);
                }
                if(age >= 19 && age <= 20){
                    int a1 = rand.nextInt(5,20);
                    int registro[] = new int[a1];
                    for (int j = 0; j < a1; j++) {
                        registro[j] = j+1;
                    }
                    String temp = Arrays.toString(registro);
                    temp = temp.replace("[","");
                    temp = temp.replace("]","");
                    salida.println(temp);
                }
                if(age >= 21 && age <= 23){
                    int a1 = rand.nextInt(20,40);
                    int registro[] = new int[a1];
                    for (int j = 0; j < a1; j++) {
                        registro[j] = j+1;
                    }
                    String temp = Arrays.toString(registro);
                    temp = temp.replace("[","");
                    temp = temp.replace("]","");
                    salida.println(temp);
                }
                if(age >= 24 && age <= 25){
                    int a1 = rand.nextInt(35,50);
                    int registro[] = new int[a1];
                    for (int j = 0; j < a1; j++) {
                        registro[j] = j+1;
                    }
                    String temp = Arrays.toString(registro);
                    temp = temp.replace("[","");
                    temp = temp.replace("]","");
                    salida.println(temp);
                }
                if(age >= 26 && age <= 27){
                    int a1 = rand.nextInt(40,51);
                    int registro[] = new int[a1];
                    for (int j = 0; j < a1; j++) {
                        registro[j] = j+1;
                    }
                    String temp = Arrays.toString(registro);
                    temp = temp.replace("[","");
                    temp = temp.replace("]","");
                    salida.println(temp);
                }   
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}


