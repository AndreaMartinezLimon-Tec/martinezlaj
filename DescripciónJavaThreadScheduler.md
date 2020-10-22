# ¿Qué es el "Java Thread Scheduler"?
---
<p align = center><img src="https://www.j2eeonline.com/java-certification/module7/images/scheduling.gif"></p>

Es un algoritmo de programación preventivo basado en prioridades, siendo la prioridad más alta el 10 y la más baja el 1, por defecto todos los subprocesos tienen de prioridad 5.  El *Scheduler* en Java, es una lista de procesos que monitoriza todos los hilos que se ejecutan en los programas y decide cuales ejecutar y cuales debe preparar para su ejecución. Hay dos características de los hilos que el scheduler identifica: una es la prioridad del hilo de ejecución y la otra es el indicador de demonio. Si solamente existen hilos demonio ejecutándose, la JVM concluirá.

Los nuevos hilos heredan la prioridad y el indicador de demonio de los hilos de ejecución que los han creado. El scheduler determina qué hilos deberán ejecutarse comprobando la prioridad de todos ellos, aquellos con prioridad más alta dispondrán del procesador antes de los que tienen prioridad más baja.

El scheduler puede seguir dos patrones, *preemptive* y *no-preemptive* dependiendo del sistema en el que esté corriendo Java, el scheduler será de un tipo u otro:
* **Scheduler preemptive:** Este scheduler proporciona un segmento de tiempo a todos los hilos que están corriendo en el sistema. Se decide cual será el siguiente hilo a ejecutarse y se llama al método resume() para darle vida durante un período fijo de tiempo. Cuando el hilo ha estado en ejecución ese período de tiempo, se llama al método suspend() y el siguiente hilo en la lista será relanzado (manda llamar de nuevo el método resume()). 


* **Scheduler no-preemptive:** Decide que hilo debe correr y lo ejecuta hasta que concluye. El hilo tiene un control total del sistema mientras está en ejecución. La forma en la que un hilo fuerza al scheduler a comenzar la ejecución del siguiente hilo en la lista es a través del método yield