package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaDeEmergencia = new VectorHeap<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Sistema de Ingreso de Pacientes a Emergencias");
        
        while (true) {
            System.out.println("\n¿Deseas ingresar un nuevo paciente? (Sí: s / No: n)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            
            if (!respuesta.equals("s")) {
                break; // Salir del ciclo si el usuario no quiere ingresar más pacientes.
            }
            
            System.out.println("Ingresa el nombre del paciente:");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingresa la descripción del síntoma:");
            String sintoma = scanner.nextLine();
            
            char codigoEmergencia;
            while (true) {
                System.out.println("Ingresa el código de emergencia (A, B, C, D, E):");
                String codigo = scanner.nextLine().trim().toUpperCase();
                if (codigo.length() == 1 && codigo.charAt(0) >= 'A' && codigo.charAt(0) <= 'E') {
                    codigoEmergencia = codigo.charAt(0);
                    break;
                } else {
                    System.out.println("Código inválido. Por favor, ingresa un código de emergencia válido.");
                }
            }
            
            // Añadir el paciente a la cola de emergencia
            colaDeEmergencia.add(new Paciente(nombre, sintoma, codigoEmergencia));
        }
        
        // Atender a los pacientes según su prioridad
        System.out.println("\nAtendiendo a los pacientes según su prioridad:");
        while (!colaDeEmergencia.isEmpty()) {
            Paciente paciente = colaDeEmergencia.remove();
            System.out.println("Atendiendo a: " + paciente);
        }
        
        scanner.close();
    }
}

