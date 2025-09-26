package com.mycompany.estudiante;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Integer> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(int nota) {
        // Validar que nota esté entre 0 y 100
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
        }
        notas.add(nota);
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (int n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    public boolean aprobo() {
        return calcularPromedio() >= 60;
    }
}
