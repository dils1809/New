## # Sistema de Colas con Prioridad para Emergencias Hospitalarias



## Autor

- Dilary Sarahí Cruz López



## Descripción

- Este proyecto implementa un sistema para manejar la atención de pacientes en la sección de emergencias de un hospital utilizando una cola de prioridad. Los pacientes son atendidos en función de la urgencia de sus síntomas, clasificados de la letra A (máxima prioridad) hasta la E (menor prioridad). Este sistema está desarrollado en Java y utiliza una estructura de datos tipo heap para gestionar las prioridades.

## Objetivos

- **Implementar una cola de prioridad usando heap para gestionar la atención de emergencias. **

- **Facilitar la interacción mediante consola para el ingreso y atención de pacientes. **
  
  

## Estructura del Código

- Main.java: Contiene el flujo principal del programa, manejo de entrada/salida y la lógica para añadir y atender pacientes. 

- Paciente.jav: Define la clase `Paciente`, que implementa `Comparable` para determinar el orden de atención basado en la urgencia.

- PriorityQueue.java**: Interfaz para la cola de prioridad.

- VectorHeap.java: Implementación concreta de la cola de prioridad utilizando un vector para simular un heap.



## Funcionamiento del programa

- El programa permite la entrada de pacientes a través de la consola, donde cada paciente tiene un nombre, síntoma y un código de emergencia. Una vez ingresados, los pacientes pueden ser atendidos en orden de prioridad.



## Ejemplo de Entrada/Salida

- **Entrada del paciente **:

- Nombre: Dilary Cruz

- Síntoma: Luxación de rotula

- Código de emergencia: B

- **Salida **: Atendiendo a: Dilary Cruz, Luxación de rotula, B



## Diagramas UML

![](C:\Users\dilar\OneDrive\Desktop\New\MainUML.png)

![](C:\Users\dilar\OneDrive\Desktop\New\VectorHeapUML.png)

![](C:\Users\dilar\OneDrive\Desktop\New\PacienteUML.png)

![](C:\Users\dilar\OneDrive\Desktop\New\InterfaceUML.png)





## Instalación y Ejercución



### **Requisitos. **

- Java  11 o superior



### 




