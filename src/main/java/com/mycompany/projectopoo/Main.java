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
        boolean rep1 = true,rep2=true,rep3=true,ok;
        int op1=0,op2=0,op3=0,cantAlu=500;
        System.out.println("\n\tINICIANDO...");
        System.out.println("\nLeyendo archivos necesarios...");
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
        System.out.println("Archivos leidos correctamente");
        System.out.println("\nGenerando Base De Datos...");
        System.out.println("Base De Datos Generada");
        System.out.println("----------------------------------\n");
        while(rep1 == true){
            System.out.println("\tBIENVENIDO\n");
            System.out.println("Administracion Escolar");
            System.out.println("\nEscriba la opcion deseada");
            System.out.println("\n[1]\tMostrar Lista de Nombres y Numeros De Cuenta");
            System.out.println("\n[2]\tModificar registros");
            System.out.println("\n[3]\tGenerar numeros de inscripcion");
            System.out.println("\n[4]\tSalir\n");
            op1 = leerInt();
            rep2 = true;
            op2 = 0;
            switch (op1) {
                case 1:
                    System.out.println("----------------------------------\n");
                    System.out.println("Mostrar Lista de Nombres y Numeros De Cuenta");
                    System.out.println("\nN. Cuenta, Nombre, ApellidoP, ApellidoM, Edad\n");
                    mostrarBaseDeDatos("BaseDeDatos.csv");
                    System.out.println("----------------------------------\n");
                    break;
                case 2:
                    rep2=true;
                    while(rep2 == true){
                        System.out.println("----------------------------------\n");
                        int busq,tmp;
                        op3=0;
                        System.out.println("Modificar registros");
                        System.out.println("\nEscriba la opcion deseada\n");
                        System.out.println("\n[1]\tBuscar Informacion Alumno");
                        System.out.println("\n[2]\tCrear Informacion Alumno");
                        System.out.println("\n[3]\tModificar Informacion Alumno");
                        System.out.println("\n[4]\tBorrar Informacion Alumno");
                        System.out.println("\n[5]\tSalir\n");
                        op2 = leerInt();
                        switch (op2) {
                            case 1:
                                System.out.println("----------------------------------\n");
                                System.out.println("Buscar Informacion Alumno");
                                System.out.println("\nEscriba el numero de cuenta a buscar:\n");
                                busq = leerInt();
                                tmp = buscaPerfil(busq);
                                if(tmp==-1){
                                    System.out.println("\nAlumno no encontrado");
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
                                System.out.println("----------------------------------\n");
                                System.out.println("Crear Informacion Alumno");
                                System.out.println("\nNumero de Cuenta: ");
                                int cuenta = leerInt();
                                System.out.println("\nNombre: ");
                                String nombre = leerStr();
                                System.out.println("\nApellido Paterno: ");
                                String apellidoP = leerStr();
                                System.out.println("\nApellido Materno: ");
                                String apellidoM = leerStr();
                                System.out.println("\nEdad: ");
                                int age = leerInt();
                                System.out.println("\nDireccion: ");
                                String direc = leerStr();
                                System.out.println("\nNumero de Materias Aprobadas: ");
                                int reg = leerInt();
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
                                System.out.println("\nRegistro Creado Correctamente");
                                cantAlu += 1;
                                break;
                            case 3:
                                rep3=true;
                                System.out.println("----------------------------------\n");
                                System.out.println("Modificar Informacion Alumno");
                                System.out.println("\nEscriba el numero de cuenta a modificar\n");
                                busq = leerInt();
                                tmp = buscaPerfil(busq);
                                if(tmp==-1){
                                    System.out.println("\nAlumno no encontrado");
                                }
                                else{
                                    String[] datos = leerLinea(tmp,"BaseDeDatos.csv");
                                    String[] dir = leerLinea(tmp,"Direcciones.txt");
                                    String[] reg2 = leerLinea(tmp,"RegistrosAcademicos.csv");
                                    String direccion = Arrays.toString(dir);
                                    direccion = direccion.replace("[","");
                                    direccion = direccion.replace("]",""); 
                                    Alumno persona = new Alumno(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],Integer.parseInt(datos[4]),direccion,reg2.length);

                                    while(rep3==true){
                                        System.out.println("----------------------------------\n");
                                        System.out.println("Escriba la opcion deseada\n");
                                        System.out.println("\n[1]\tModificar Numero de Cuenta");
                                        System.out.println("\n[2]\tModificar Nombre");
                                        System.out.println("\n[3]\tModificar Apellido Paterno");
                                        System.out.println("\n[4]\tModificar Apellido Materno");
                                        System.out.println("\n[5]\tModificar Edad");
                                        System.out.println("\n[6]\tModificar Direccion");
                                        System.out.println("\n[7]\tModificar Materias Aprobadas");
                                        System.out.println("\n[8]\tSalir\n");
                                        op3 = leerInt();
                                        System.out.println(op3);
                                        int num;
                                        String str;
                                        switch (op3) {
                                            case 1:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Numero de Cuenta\n");
                                                System.out.println("Nuevo valor: ");
                                                num = leerInt();
                                                persona.setNumCuenta(num);
                                                System.out.println("\nDato Registrado Correctamente");
                                                break;
                                            case 2:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Nombre\n");
                                                System.out.println("Nuevo valor: ");
                                                str = leerStr();
                                                persona.setNombre(str);
                                                break;
                                            case 3:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Apellido Paterno\n");
                                                System.out.println("Nuevo valor: ");
                                                str = leerStr();
                                                persona.setApellidoP(str);
                                                break;
                                            case 4:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Apellido Materno\n");
                                                System.out.println("Nuevo valor: ");
                                                str = leerStr();
                                                persona.setApellidoM(str);
                                                break;
                                            case 5:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Edad\n");
                                                System.out.println("Nuevo valor: ");
                                                num = leerInt();
                                                persona.setEdad(num);
                                                System.out.println("\nDato Registrado Correctamente");
                                                break;
                                            case 6:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Direccion\n");
                                                System.out.println("Nuevo valor: ");
                                                str = leerStr();
                                                persona.setDireccion(str);
                                                break; 
                                            case 7:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Modificar Materias Aprobadas\n");
                                                System.out.println("Nuevo valor: ");
                                                num = leerInt();
                                                persona.setMaterias(num);
                                                System.out.println("\nDato Registrado Correctamente");
                                                break;
                                             case 8:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Salir");
                                                System.out.println("----------------------------------\n");
                                                rep3=false;
                                                break;   
                                            default:
                                                System.out.println("----------------------------------\n");
                                                System.out.println("Opcion no valida");
                                                System.out.println("----------------------------------\n");
                                        }
                                    }
                                    
                                    sobrescribir(tmp,persona.obtenerDatos(),"BaseDeDatos.csv");
                                    sobrescribir(tmp,persona.obtenerDireccion(),"Direcciones.txt");
                                    System.out.println("Informacion guardada");
                                    //Escribir Materias
                                    String mate[] = new String[persona.obtenerCreditos()];
                                    for (int i = 0; i < persona.obtenerCreditos(); i++) {
                                        mate[i] = i+1+"";
                                    }
                                    sobrescribir(tmp,mate,"RegistrosAcademicos.csv");
                                }
                                break;
                            case 4:
                                System.out.println("----------------------------------\n");
                                System.out.println("Borrar Informacion Alumno");
                                System.out.println("\nEscriba el numero de cuenta:\n");
                                busq = leerInt();
                                tmp = buscaPerfil(busq);
                                if(tmp == -1){
                                    System.out.println("Alumno no encontrado");
                                }
                                else{
                                    String[] borrar = {""};
                                    sobrescribir(tmp,borrar,"BaseDeDatos.csv");
                                    sobrescribir(tmp,borrar,"Direcciones.txt");
                                    sobrescribir(tmp,borrar,"RegistrosAcademicos.csv");
                                    System.out.println("Registro Eliminado");
                                }
                                break;
                            case 5:
                                System.out.println("----------------------------------\n");
                                System.out.println("Salir");
                                System.out.println("----------------------------------\n");
                                rep2=false;
                                break;
                            default:
                                System.out.println("----------------------------------\n");
                                System.out.println("Opcion no valida");
                                System.out.println("----------------------------------\n");
                                //throw new AssertionError();
                        }
                    }
                    break;
                case 3:
                    System.out.println("----------------------------------\n");
                    System.out.println("Generando numeros de inscripcion...\n");
                    crearArchivoVacio("HistorialAcademico.csv");    //Evita errores
                    crearArchivoVacio("NumeroDeInscripcion.csv");
                    int[] creditos = creditosMaterias();
                    double [][] lista = new double [cantAlu][2];
                    int numeroOrdenado = 1;
                    for (int i = 0; i < cantAlu; i++) {
                        String[] reg = leerLinea(i,"RegistrosAcademicos.csv");
                        String valir = Arrays.toString(reg);
                        //validar que existe registro
                        if(valir.length() >= 3){
                            String[] dato = leerLinea(i,"BaseDeDatos.csv");
                            Alumno generador = new Alumno(reg.length,Integer.parseInt(dato[4]));
                            escribir(generarHistorial(generador.getEdad(),generador.getMaterias(),creditos),"HistorialAcademico.csv");
                        }
                    }
                    for (int i = 0; i < cantAlu; i++) {     //Generar numero de inscripcion
                        String[] datosParaNumero = leerLinea(i,"HistorialAcademico.csv");
                        String[] dato = leerLinea(i,"BaseDeDatos.csv");
                        //System.out.println(Integer.parseInt(dato[0])+Integer.parseInt(datosParaNumero[0])+Integer.parseInt(datosParaNumero[1])+Integer.parseInt(datosParaNumero[2])+Integer.parseInt(datosParaNumero[3])+Integer.parseInt(datosParaNumero[4]));
                        Alumno inscripcion = new Alumno(Integer.parseInt(dato[0]),Integer.parseInt(datosParaNumero[0]),Integer.parseInt(datosParaNumero[1]),Integer.parseInt(datosParaNumero[2]),Integer.parseInt(datosParaNumero[3]),Float.parseFloat(datosParaNumero[4]));
                        inscripcion.setNum(num(inscripcion.getMaterias(),inscripcion.getSemestre(),inscripcion.getCreditos(),inscripcion.getCredSemestre(),inscripcion.getPromedio()));
                        //System.out.println("Numero de cuenta: "+inscripcion.getNumCuenta()+" Aprobadas: "+inscripcion.getMaterias()+" Inscritas: "+inscripcion.getSemestre()+" Creditos: "+inscripcion.getCreditos()+" Creditos Semestre: "+inscripcion.getCredSemestre()+" Promedio: "+inscripcion.getPromedio()+" Num: "+inscripcion.getNum());
                        lista [i][0] = inscripcion.getNumCuenta();
                        lista [i][1] = inscripcion.getNum();
                    }
                    ordenarNumeros(lista,2);    //Ordenamos la lista de numeros de inscripcion
                    for (int i = cantAlu-1; i >=0; i--) {
                        int numeroCuenta = (int) lista[i][0];
                        String linea = numeroOrdenado+","+numeroCuenta+","+lista[i][1];
                        escribir(linea,"NumeroDeInscripcion.csv");
                        numeroOrdenado += 1;    //Numero en orden de inscripcion
                    }
                    System.out.println("Numeros de inscripcion generados con exito\n");
                    System.out.println("Archivo generado: 'NumeroDeInscripcion.csv'");
                    System.out.println("----------------------------------\n");
                    break;
                case 4:
                    System.out.println("----------------------------------\n");
                    System.out.println("Salir");
                    System.out.println("\nGuardando base de datos...");
                    System.out.println("\nCERRANDO...\n\n");
                    rep1 = false;
                    System.out.println("----------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------\n");
                    System.out.println("Opcion no valida\n");
                    System.out.println("----------------------------------\n");
                    //throw new AssertionError();
            }
        }
        } else{
            System.out.println("----------------------------------\n");
            System.out.println("ERROR...");
            System.out.println("\nFaltan archivos ppara generar base de datos");
            System.out.println("----------------------------------\n");
        }
    }
    
    public static int leerInt(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        try {
            numero = teclado.nextInt();
            return numero;
        } catch (InputMismatchException ex){
            System.out.println("----------------------------------\n");
            System.out.println("¡Cuidado! Solo puedes insertar números. \n");
        }
        return 0;
    }
    
    public static String leerStr(){
        Scanner teclado = new Scanner(System.in);
        String texto;
        try {
            texto = teclado.nextLine();
            return texto;
        } catch (InputMismatchException ex){
            System.out.println("----------------------------------\n");
            System.out.println("¡Cuidado! Solo puedes insertar texto \n");
        }
        return "";
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
        return new String[]{"Default","Default","Default","Default","Default","Default","Default"};
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
    
    public static void crearArchivoVacio(String archivo){   //Crea un archivo sin nada
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void escribir(String datos, String archivo){
        try {
            FileWriter fw = new FileWriter(archivo, true);
            //fw.write(System.getProperty( "line.separator" ));
            fw.write(datos+"\n");    
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void sobrescribir(int renglon,String[] remp,String archivo) {
        int cont = 0;
        String nvo = Arrays.toString(remp);
        nvo = nvo.replace("[","");
        nvo = nvo.replace("]",""); 
        try {
            BufferedReader file = new BufferedReader(new FileReader(archivo));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                if(cont == renglon){
                    inputBuffer.append(nvo);
                    inputBuffer.append('\n');
                }
                else{
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                cont += 1;
            }
            file.close();

            FileOutputStream fileOut = new FileOutputStream(archivo);
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static int[] creditosMaterias(){
        int[] creditos = new int[50];
        int i = 0;
        try {
            BufferedReader br;
            FileReader fr = new FileReader("Materias.csv");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leer varias lineas con ciclo
            while(linea != null){
                String[] datos = linea.split(",");
                creditos[i] = Integer.parseInt (datos[2]);
                linea = br.readLine();
                i += 1;
            }
            br.close();
            return creditos;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return creditos;
    }
    
    public static String generarHistorial(int age, int materiasAprobadas, int[] creditos){
        Random rand = new Random();
        int inscritas=0,credObt=0,credSem=0;
        String[] historial = new String[5];
        float prom = rand.nextFloat(5, 10);
        for (int i = 0; i < materiasAprobadas; i++) {
            credObt += creditos[i];
        }
        if(age == 18){
            for (int i = 0; i < 5; i++) {  //Calcular creditos del semestre 1
                credSem += creditos[i];
            }
            inscritas = 5;  //Es de primer semestre
        }
        if(age == 19){
            int semestre = rand.nextInt(1,3);   //Calcula en que semestre esta 2-4
            if(semestre == 1){  //Semestre 2
                for (int i = 0; i < 10; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 2){  //Semestre 3
                for (int i = 0; i < 15; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 3){  //Semestre 4
                for (int i = 0; i < 20; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,20);
        }
        if(age == 20){
            int semestre = rand.nextInt(1,3);   //Calcula en que semestre esta 4-6
            if(semestre == 1){  //Semestre 4
                for (int i = 0; i < 20; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 2){  //Semestre 5
                for (int i = 0; i < 25; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 3){  //Semestre 6
                for (int i = 0; i < 30; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,30);
        }
        if(age == 21){
            int semestre = rand.nextInt(1,3);   //Calcula en que semestre esta 6-8
            if(semestre == 1){  //Semestre 6
                for (int i = 0; i < 30; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 2){  //Semestre 7
                for (int i = 0; i < 35; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 3){  //Semestre 8
                for (int i = 0; i < 40; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,40);
        }
        if(age == 22){
            int semestre = rand.nextInt(1,3);   //Calcula en que semestre esta 8-10
            if(semestre == 1){  //Semestre 8
                for (int i = 0; i < 40; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 2){  //Semestre 9
                for (int i = 0; i < 45; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            if(semestre == 3){  //Semestre 10
                for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                    credSem += creditos[i];
                }
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,50);
        }
        if(age == 23){
            //Semestre 10
            for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                credSem += creditos[i];
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,60);
        }
        if(age == 24){
            //Semestre 10
            for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                credSem += creditos[i];
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,65);
        }
        if(age == 25){
            //Semestre 10
            for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                credSem += creditos[i];
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,70);
        }
        if(age == 26){
            //Semestre 10
            for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                credSem += creditos[i];
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,75);
        }
        if(age == 27){
            //Semestre 10
            for (int i = 0; i < 50; i++) {  //Calcular creditos del semestre
                credSem += creditos[i];
            }
            //Calcular materia inscritas alt
            inscritas = rand.nextInt(materiasAprobadas,80);
        }
        //Guardar valores
        historial[0] = String.valueOf(materiasAprobadas);    // *
        historial[1] = String.valueOf(inscritas);    //materias inscritas
        historial[2] = String.valueOf(credObt);      //creditos de materias cursadas *
        historial[3] = String.valueOf(credSem);      //creditos semestre
        historial[4] = String.valueOf(prom);         //promedio
        String resultante = Arrays.toString(historial);
        resultante = resultante.replace("[","");
        resultante = resultante.replace("]","");
        resultante = resultante.replaceAll(" ","");
        return resultante;
    }
    
    //Numero de Inscripcion 
    public static double num(int materias,int semestre,int creditos,int credSemestre,float promedio){
        double numero,velocidad,escolaridad,a,b,c,d,e;
        a = materias;
        b = semestre;
        c = creditos;
        d = credSemestre;
        e = promedio;
        escolaridad = (a/b)*100;
        velocidad = (c/d)*100;
        numero = e * escolaridad * velocidad;
        return numero;
    }
    
    public static  void ordenarNumeros(double[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<double[]>() {
            @Override
            public int compare(double[] first, double[] second) {
               if(first[columnNumber-1] > second[columnNumber-1]) return 1;
               else return -1;
            }
        })
                ;
    }


}
