/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectopoo;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brandon Hernandez Solis
 */
public class Main {
    public static void main(String[] args){
        String[] tmpDatos = new String[1000];
        boolean rep1 = true,rep2=true,ok;
        int op1=0,op2=0;
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        System.out.println("\tINICIANDO...");
        System.out.println("\nGenerando Base De Datos...");
        ok = validador();
        if(ok == true){ //Lee y crea documentos para la ejecucion
            Modulos ini = new Modulos();
            ini.listaNombres();
            ini.listaApellidos();
            ini.numeroDeCuenta();
            ini.listaCalles();
            ini.listaCP();
            ini.listaColonia();
            ini.listaMunicipio();
            ini.leerRegistros();
            ini.baseDeDatos();
            ini.baseDeDirecciones();
            ini.regAcademicos();
        System.out.println("Base De Datos Generada");
        while(rep1 == true){
            System.out.println("\n\tBIENVENIDO\n");
            System.out.println("Administracion Escolar");
            System.out.println("\nEscriba la opcion deseada");
            System.out.println("\n[1]\tMostrar Lista de Nombres y Numeros De Cuenta");
            System.out.println("\n[2]\tModificar registros");
            System.out.println("\n[3]\tGenerar numeros de inscripcion");
            System.out.println("\n[4]\tSalir\n");
            op1=Integer.parseInt(teclado.next());
            op2 = 0;
            rep2=true;
            switch (op1) {
                case 1:
                    System.out.println("\nMostrar Lista de Nombres y Numeros De Cuenta");
                    System.out.println("N. Cuenta, Nombre, ApellidoP, ApellidoM, Edad");
                    mostrarBaseDeDatos("BaseDeDatos.csv");
                    break;
                case 2:
                    while(rep2 == true){
                        int busq,tmp;
                        System.out.println("\nModificar registros");
                        System.out.println("\nEscriba la opcion deseada\n");
                        System.out.println("\n[1]\tBuscar Informacion Alumno");
                        System.out.println("\n[2]\tCrear Informacion Alumno");
                        System.out.println("\n[3]\tModificar Informacion Alumno");
                        System.out.println("\n[4]\tBorrar Informacion Alumno");
                        System.out.println("\n[5]\tSalir\n");
                        op2=Integer.parseInt(teclado.next());
                        switch (op2) {
                            case 1:
                                System.out.println("\nBuscar Informacion Alumno");
                                System.out.println("\nEscriba el numero de cuenta a buscar:\n");
                                busq = Integer.parseInt(teclado.next());
                                tmp = buscaPerfil(busq);
                                if(tmp==-1){
                                    System.out.println("Alumno no encontrado");
                                }
                                else{
                                    String[] datos = leerLinea(tmp,"BaseDeDatos.csv");
                                    String[] dir = leerLinea(tmp,"Direcciones.txt");
                                    String[] reg = leerLinea(tmp,"RegistrosAcademicos.csv");
                                    String direccion = Arrays.toString(dir);
                                    direccion = direccion.replace("[","");
                                    direccion = direccion.replace("]",""); 
                                    Alumno persona = new Alumno(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],Integer.parseInt(datos[4]),direccion,reg.length);
                                    System.out.println("Numero de Cuenta: "+persona.getNumCuenta());
                                    System.out.println("Nombre: "+persona.getNombre()+" "+persona.getApellidoP()+" "+persona.getApellidoM());
                                    System.out.println("Edad: "+persona.getEdad());
                                    System.out.println("Direccion: "+persona.getDireccion());
                                    System.out.println("Materias Aprobadas: "+persona.getMaterias());
                                }
                                break;
                            case 2:
                                System.out.println("\nCrear Informacion Alumno");
                                System.out.println("\nNumero de Cuenta: ");
                                String cuenta = teclado2.nextLine();
                                System.out.println("\nNombre: ");
                                String nombre = teclado2.nextLine();
                                System.out.println("\nApellido Paterno: ");
                                String apellidoP = teclado2.nextLine();
                                System.out.println("\nApellido Materno: ");
                                String apellidoM = teclado2.nextLine();
                                System.out.println("\nEdad: ");
                                String age = teclado2.nextLine();
                                System.out.println("\nDireccion: ");
                                String direc = teclado2.nextLine();
                                System.out.println("\nNumero de Materias Aprobadas: ");
                                int reg = Integer.parseInt(teclado.next());
                                //Escribir en base de datos
                                String baseDatos = cuenta+","+nombre+","+apellidoP+","+apellidoM+","+age;   
                                escribir(baseDatos,"BaseDeDatos.csv");
                                //Escribir en direcciones
                                escribir(direc,"Direcciones.txt");
                                //Escribir en registro academico
                                int materias[] = new int[reg];
                                for (int i = 0; i < reg; i++) {
                                    materias[i] = i+1;
                                }
                                String mat = Arrays.toString(materias);
                                mat = mat.replace("[","");
                                mat = mat.replace("]","");
                                escribir(mat,"RegistrosAcademicos.csv");
                            case 3:
                                System.out.println("\nModificar Informacion Alumno");
                                break;
                            case 4:
                                System.out.println("\nBorrar Informacion Alumno");
                                System.out.println("\nEscriba el numero de cuenta:\n");
                                String del = teclado2.nextLine();
                                busq = Integer.parseInt(del);
                                tmp = buscaPerfil(busq);
                                if(tmp==-1){
                                    System.out.println("Alumno no encontrado");
                                }
                                else{
                                    String[] datos2 = leerLinea(tmp,"BaseDeDatos.csv");
                                    String[] dir2 = leerLinea(tmp,"Direcciones.txt");
                                    String[] reg2 = leerLinea(tmp,"RegistrosAcademicos.csv");
                                    borrar(del,datos2,"BaseDeDatos.csv");
                                    borrar(del,dir2,"Direcciones.txt");
                                    borrar(del,reg2,"RegistrosAcademicos.csv");
                                    System.out.println("Registro Eliminado");
                                }
                                break;
                            case 5:
                                System.out.println("\nSalir\n");
                                rep2=false;
                                break;
                            default:
                                System.out.println("\nOpcion no valida");
                                //throw new AssertionError();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nGenerar numeros de inscripcion");
                    
                    break;
                case 4:
                    System.out.println("\nSalir");
                    System.out.println("\nGuardando base de datos...");
                    System.out.println("\nCERRANDO...\n\n");
                    rep1 = false;
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    //throw new AssertionError();
            }
        }
        }else{
            System.out.println("\nERROR...");
            System.out.println("\nFaltan archivos ppara generar base de datos");
        }
    }

    public static boolean validador(){
        File nombres = new File("Nombres.csv");
        File apellidos = new File("Apellidos.csv");
        File cuenta = new File("NumeroDeCuenta.csv");
        File calles = new File("Calles.csv");
        File cp = new File("CodigoPostal.csv");
        File col = new File("Colonia.csv");
        File mun = new File("Municipio.csv");
        File mat = new File("Materias.csv");
        if(nombres.exists()){
            if(apellidos.exists()){
                if(cuenta.exists()){
                    if(calles.exists()){
                        if(cp.exists()){
                            if(col.exists()){
                                if(mun.exists()){
                                    if(mat.exists()){
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static int buscaPerfil(int numero) {
        int tmp = 0;
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        try {
            br = new BufferedReader(new FileReader("BaseDeDatos.csv"));
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(",");
                //Imprime datos.
                //Llevar la cuenta
                int temporalnum = Integer.parseInt (datos[0]);
                if(numero == temporalnum){
                    System.out.println("\nAlumno Encontrado\n");
                    return tmp;
                }
                tmp += 1;
            }
            System.out.println("");
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
        return -1;
    }
    
    public static String[] leerLinea(int fila,String archivo){
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(archivo));
            for (int i = 0; i <= fila; i++) {
                // Leer una linea del archivo para avanzar
                String linea = bufferLectura.readLine();
                //Si llega a la fila deseada
                if(i == fila){
                    // Sepapar la linea leída con el separador definido previamente
                    String[] campos = linea.split(",");
                    return campos;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return new String[]{"Default", "Default", "Default", "Default","Default","Default","Default"};
    }
    
    public static void mostrarBaseDeDatos(String archivo){
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(archivo));
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] campos = linea.split(",");
                System.out.println(Arrays.toString(campos));
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public static void escribir(String datos, String archivo){
        try {
            FileWriter fw = new FileWriter(archivo, true);
            //fw.write(System.getProperty( "line.separator" ));
            fw.write(datos);    
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void sobrescribir(String numCuenta, String[] anterior, String[] nuevo,String archivo){
        BufferedReader file;
        String old = Arrays.toString(anterior);
        old = old.replace("[","");
        old = old.replace("]",""); 
        String nvo = Arrays.toString(anterior);
        nvo = nvo.replace("[","");
        nvo = nvo.replace("]",""); 
        try {
            file = new BufferedReader(new FileReader(archivo));
            String line, input = "";
            while((line = file.readLine()) != null){
                if(line.contains(numCuenta))
                    input += line.replaceAll(old,nvo+"\r\n");
                else
                    input += line+"\r\n";
            }
            FileOutputStream fileOut = new FileOutputStream(archivo,true);
            fileOut.write(input.getBytes());
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void borrar(String numCuenta, String[] anterior, String archivo){
        BufferedReader file; 
        String old = Arrays.toString(anterior);
        old = old.replace("[","");
        old = old.replace("]",""); 
        System.out.println(old);
        try {
            file = new BufferedReader(new FileReader(archivo));
            String line, input = "";
            while((line = file.readLine()) != null){
                if(line.contains(numCuenta))
                    input += line.replaceAll(old,"remplazamiento");
                else
                    input += line+"\r\n";
            }
            FileOutputStream fileOut = new FileOutputStream(archivo);
            fileOut.write(input.getBytes());
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
