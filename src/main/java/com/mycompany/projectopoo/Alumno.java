/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Brandon Hernandez Solis
 */
public class Alumno {
    //Atributos
    private int numCuenta;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String direccion;
    //Atributos Academicos
    private int creditos;
    private float promedio;
    private int materias;
    private int semestre;
    private int credSemestre;
    //Atributo numero para calcular inscripcion
    private double num;
    //Constructor

    public Alumno(int numCuenta, int materias, int semestre, int creditos, int credSemestre, float promedio) {
        this.numCuenta = numCuenta;
        this.creditos = creditos;
        this.promedio = promedio;
        this.materias = materias;
        this.semestre = semestre;
        this.credSemestre = credSemestre;
    }
    
    public Alumno(int materias, int edad){
        this.materias = materias;
        this.edad = edad;
    }
    
    public Alumno() {
    }

    public Alumno(int numCuenta, String nombre, String apellidoP, String apellidoM, int edad, String direccion, int materias) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.direccion = direccion;
        this.materias = materias;
    }
    //Getters and Seters

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getMaterias() {
        return materias;
    }

    public void setMaterias(int materias) {
        this.materias = materias;
    }
    //Metodos
    public String[] obtenerDatos(){
        String[] datos = {numCuenta + "," + nombre + "," + apellidoP + "," + apellidoM + "," + edad };
        return datos;
    }
    public String[] obtenerDireccion(){
        String[] datos = {direccion};
        return datos;
    }
    public int obtenerCreditos(){
        int datos = materias;
        return datos;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public int getCredSemestre() {
        return credSemestre;
    }
    public void setCredSemestre(int credSemestre) {
        this.credSemestre = credSemestre;
    }
    public double getNum() {
        return num;
    }
    public void setNum(double num) {
        this.num = num;
    }

    //toString
    @Override
    public String toString() {
        return "Alumno{" + "numCuenta=" + numCuenta + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", edad=" + edad + ", direccion=" + direccion + ", creditos=" + creditos + ", promedio=" + promedio + ", materias=" + materias + '}';
    }
    
    
}
